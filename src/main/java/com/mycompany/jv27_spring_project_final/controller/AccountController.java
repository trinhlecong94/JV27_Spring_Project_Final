/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jv27_spring_project_final.controller;

import com.mycompany.jv27_spring_project_final.Ultil.AccountUltil;
import com.mycompany.jv27_spring_project_final.entities.AccountEntity;
import com.mycompany.jv27_spring_project_final.entities.AccountRoleEntity;
import com.mycompany.jv27_spring_project_final.entities.OrderEntity;
import com.mycompany.jv27_spring_project_final.entities.VerifyEmailEntity;
import com.mycompany.jv27_spring_project_final.entities.enums.ActiveStatus;
import com.mycompany.jv27_spring_project_final.entities.enums.Role;
import com.mycompany.jv27_spring_project_final.service.AccountRoleService;
import com.mycompany.jv27_spring_project_final.service.AccountService;
import com.mycompany.jv27_spring_project_final.service.OrderService;
import com.mycompany.jv27_spring_project_final.service.VerifyEmailService;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author taing
 */
@Controller
public class AccountController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRoleService accountRoleService;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private VerifyEmailService verifyEmailService;

    @RequestMapping("/account")
    public String viewAccount(Model model,
            @RequestParam(value = "action", required = false) String action,
            @RequestParam(value = "page", required = false) Integer page) {
        if (action == null || action.isEmpty()) {
            AccountEntity account = AccountUltil.getAccount();
            model.addAttribute("account", account);
            return "account/profile";
        } else if (action.equals("myorder")) {
            if (page == null || page <= 0) {
                page = 1;
            }
            AccountEntity account = AccountUltil.getAccount();
            Page<OrderEntity> ordersPage = orderService.getOrdersByAccountId(account.getId(), page);
            model.addAttribute("orders", ordersPage.getContent());
            model.addAttribute("page", ordersPage.getTotalPages());
            return "account/myorder";
        } else if (action.equals("changepassword")) {
            return "account/changepassword";
        } else {
            AccountEntity account = AccountUltil.getAccount();
            model.addAttribute("account", account);
            return "account/profile";
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String viewRegister(Model model) {
        return "register";
    }

    @RequestMapping("/login")
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/register-account", method = RequestMethod.POST)
    public String registerAccount(Model model, @ModelAttribute(value = "account") AccountEntity account, @ModelAttribute(value = "password1") String password1, @ModelAttribute(value = "password2") String password2) {
        if (!Pattern.matches("^[a-zA-Z0-9_]+$", account.getUsername())) {
            model.addAttribute("messageError", "The username contains illegal characters.");
            return "register";
        }
        if (password1.length() < 5) {
            model.addAttribute("messageError", "Password must be greater than or equal to 5 characters");
            return "register";
        }
        if (!password1.equals(password2)) {
            model.addAttribute("messageError", "Password is not the same, please check again");
            return "register";
        }
        AccountEntity checkUsername = accountService.getAccountByUsername(account.getUsername());
        if (checkUsername != null) {
            model.addAttribute("messageError", "This username already exists");
            return "register";
        }
        AccountEntity checkEmail = accountService.getAccountByEmail(account.getEmail());
        if (checkEmail != null) {
            model.addAttribute("messageError", "This email address already exists");
            return "register";
        }
        account.setPassword(password2);
        List<AccountRoleEntity> accountRoleEntitys = new ArrayList<>();
        accountRoleEntitys.add(accountRoleService.getAccountRolesByRole(Role.ROLE_USER));
        account.setAccountRoles(accountRoleEntitys);
        AccountEntity accountSaved = accountService.saveAccount(account);
        if (accountSaved != null && accountSaved.getId() > 0) {
            String verifyCode = UUID.randomUUID().toString();
            VerifyEmailEntity verify = new VerifyEmailEntity();
            verify.setEmail(accountSaved.getEmail());
            verify.setCode(verifyCode);
            VerifyEmailEntity verifyCodeSaved = verifyEmailService.save(verify);
            if (verifyCodeSaved != null & verifyCodeSaved.getId() > 0) {
                try {
                    MimeMessage mimeMessage = mailSender.createMimeMessage();
                    MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
                    String htmlMsg = "<p>To activate your account, please verify your email address by clicking on the link below:</p><a href=\"http://localhost:8080/JV27_Spring_Project_Final/verify?email=" + accountSaved.getEmail() + "&code=" + verifyCode + "\">Verify now</a>";
                    mimeMessage.setContent(htmlMsg, "text/html");
                    helper.setTo(accountSaved.getEmail());
                    helper.setSubject("Activate your account");
                    mailSender.send(mimeMessage);
                } catch (MailException | MessagingException m) {
                    model.addAttribute("messageError", "Successful account registration but email confirmation failed<br/>" + m);
                    return "register";
                }
                model.addAttribute("messageSuccess", "Successful account registration, please confirm the link has been sent to the email");
                return "register-success";
            } else {
                model.addAttribute("messageError", "Successful account registration but can't create email verify code");
            }

        } else {
            model.addAttribute("messageError", "Unable to register your account");
        }

        return "register";
    }

    @RequestMapping(value = "/update-account", method = RequestMethod.POST)
    public String updateAccount(Model model, @ModelAttribute(value = "account") AccountEntity acc) {
        AccountEntity account = AccountUltil.getAccount();
        account.setFullName(acc.getFullName());
        account.setAddress(acc.getAddress());
        account.setBirthday(acc.getBirthday());
        account.setPhone(acc.getPhone());
        AccountEntity checkEmail = accountService.getAccountByEmail(acc.getEmail());
        if (checkEmail == null) {
            account.setEmail(acc.getEmail());
        }
        accountService.saveAccount(account);
        model.addAttribute("messageSuccess", "Successfully updated account profile");
        model.addAttribute("account", account);
        return "account/profile";
    }

    @RequestMapping(value = "/update-password", method = RequestMethod.POST)
    public String updatePassword(Model model, 
            @ModelAttribute(value = "password") String password, 
            @ModelAttribute(value = "newpassword1") String newpassword1, 
            @ModelAttribute(value = "newpassword2") String newpassword2) {
        if (newpassword1.equals(newpassword2)) {
            AccountEntity account = AccountUltil.getAccount();
            if (account.getPassword().equals(password)) {
                account.setPassword(newpassword1);
                accountService.saveAccount(account);
                model.addAttribute("messageSuccess", "Successfully updated password");
            } else {
                model.addAttribute("messageError", "Password incorrect");
            }
        } else {
            model.addAttribute("messageError", "The new password is not the same");
        }
        return "account/changepassword";
    }

    @RequestMapping(value = "/verify")
    public String verify(Model model,
            @RequestParam(value = "email") String email,
            @RequestParam(value = "code") String code) {
        VerifyEmailEntity verify = verifyEmailService.getVerify(email, code);
        if (verify == null) {
            model.addAttribute("messageError", "Verify code or email invalid");
        } else {
            AccountEntity account = accountService.getAccountByEmail(email);
            account.setStatus(ActiveStatus.ACTIVE);
            accountService.saveAccount(account);
            verifyEmailService.delete(verify);
            model.addAttribute("messageSuccess", "Email validation successful");
        }
        return "verifyStatus";
    }
}
