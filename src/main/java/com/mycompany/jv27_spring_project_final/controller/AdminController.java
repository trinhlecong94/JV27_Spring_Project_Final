/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jv27_spring_project_final.controller;

import com.mycompany.jv27_spring_project_final.entities.AccountEntity;
import com.mycompany.jv27_spring_project_final.entities.AccountRoleEntity;
import com.mycompany.jv27_spring_project_final.entities.enums.ActiveStatus;
import com.mycompany.jv27_spring_project_final.entities.enums.Role;
import com.mycompany.jv27_spring_project_final.service.AccountRoleService;
import com.mycompany.jv27_spring_project_final.service.AccountService;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
public class AdminController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRoleService accountRoleService;

    @RequestMapping("/admin")
    public String viewAdmin(Model model,
            @RequestParam(value = "action", required = false) String action,
            @RequestParam(value = "page", required = false) Integer page) {
        if (page == null || page <= 0) {
                page = 1;
            }
        if (action.equals("account-manager")) {            
            Page<AccountEntity> accountsPage = accountService.getAccounts(page);
            model.addAttribute("accounts", accountsPage.getContent());
            model.addAttribute("page", accountsPage.getTotalPages());
            return "admin/account-manager";
        } else if (action.equals("add-account")) {
            model.addAttribute("roles", accountRoleService.getAccountRoles());
            return "admin/add-account";
        } else {
            return "redirect:/account";
        }
    }

    @RequestMapping("/admin/edit-account")
    public String viewPageAccount(Model model, @RequestParam(value = "id") int id) {
        AccountEntity account = accountService.getAccountById(id);
        model.addAttribute("account", account);
        model.addAttribute("roles", accountRoleService.getAccountRoles());
        model.addAttribute("activeStatus", ActiveStatus.values());
        return "admin/viewaccount";
    }

    @RequestMapping(value = "/admin/add-account", method = RequestMethod.POST)
    public String addAccount(Model model,
            @ModelAttribute(value = "account") AccountEntity account,
            @ModelAttribute(value = "roleradio") int roleId) {
        if (Pattern.matches("^[a-zA-Z0-9_]+$", account.getUsername())) {
            AccountEntity checkUsername = accountService.getAccountByUsername(account.getUsername());
            if (checkUsername == null) {
                AccountEntity checkEmail = accountService.getAccountByEmail(account.getEmail());
                if (checkEmail == null) {
                    List<AccountRoleEntity> accountRoles = new ArrayList<>();
                    AccountRoleEntity admin = accountRoleService.getAccountRolesByRole(Role.ROLE_ADMIN);
                    AccountRoleEntity seller = accountRoleService.getAccountRolesByRole(Role.ROLE_SELLER);
                    AccountRoleEntity user = accountRoleService.getAccountRolesByRole(Role.ROLE_USER);
                    if (roleId == 1) {
                        accountRoles.add(user);
                        accountRoles.add(admin);
                    } else if (roleId == 2) {
                        accountRoles.add(seller);
                        accountRoles.add(user);
                    } else {
                        accountRoles.add(user);
                    }
                    account.setAccountRoles(accountRoles);
                    account.setStatus(ActiveStatus.ACTIVE);
                    AccountEntity accountSaved = accountService.saveAccount(account);
                    if (accountSaved != null && accountSaved.getId() > 0) {
                        model.addAttribute("messageSuccess", "Successful add account");
                    } else {
                        model.addAttribute("messageError", "Error add account");
                    }
                } else {
                    model.addAttribute("messageError", "This email address already exists");
                }
            } else {
                model.addAttribute("messageError", "This username already exists");
            }
        } else {
            model.addAttribute("messageError", "The username contains illegal characters.");
        }
        model.addAttribute("roles", accountRoleService.getAccountRoles());
        return "admin/add-account";
    }

    @RequestMapping(value = "/admin/update-account", method = RequestMethod.POST)
    public String viewUpdateAccount(Model model,
            @ModelAttribute(value = "account") AccountEntity acc,
            @ModelAttribute(value = "roleradio") int roleId,
            @ModelAttribute(value = "statusradio") String status) {
        AccountEntity checkemailAccount = accountService.getAccountByEmail(acc.getEmail());
        AccountEntity account = accountService.getAccountById(acc.getId());
        if (checkemailAccount == null) {            
            account.setFullName(acc.getFullName());
            account.setAddress(acc.getAddress());
            account.setBirthday(acc.getBirthday());
            account.setEmail(acc.getEmail());
            account.setPhone(acc.getPhone());
            account.setStatus(ActiveStatus.valueOf(status));
            List<AccountRoleEntity> accountRoles = new ArrayList<>();
            AccountRoleEntity admin = accountRoleService.getAccountRolesByRole(Role.ROLE_ADMIN);
            AccountRoleEntity seller = accountRoleService.getAccountRolesByRole(Role.ROLE_SELLER);
            AccountRoleEntity user = accountRoleService.getAccountRolesByRole(Role.ROLE_USER);
            if (roleId == 1) {
                accountRoles.add(user);
                accountRoles.add(admin);
            } else if (roleId == 2) {
                accountRoles.add(seller);
                accountRoles.add(user);
            } else {
                accountRoles.add(user);
            }
            account.setAccountRoles(accountRoles);
            AccountEntity accountupdated = accountService.saveAccount(account);

            if (accountupdated != null && accountupdated.getId() > 0) {
                model.addAttribute("account", accountupdated);
                model.addAttribute("messageSuccess", "Successful account update");
            } else {
                model.addAttribute("account", account);
                model.addAttribute("messageError", "Update failed");
            }
        }else{
            model.addAttribute("account", account);
            model.addAttribute("messageError", "This email address already exists");
        }

        model.addAttribute("roles", accountRoleService.getAccountRoles());
        model.addAttribute("activeStatus", ActiveStatus.values());
        return "admin/viewaccount";
    }

}
