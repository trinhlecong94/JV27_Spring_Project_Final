/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jv27_spring_project_final.controller;

import com.mycompany.jv27_spring_project_final.Ultil.AccountUltil;
import com.mycompany.jv27_spring_project_final.Ultil.StringUltil;
import com.mycompany.jv27_spring_project_final.entities.AccountEntity;
import com.mycompany.jv27_spring_project_final.entities.OrderDetailEntity;
import com.mycompany.jv27_spring_project_final.entities.OrderEntity;
import com.mycompany.jv27_spring_project_final.entities.ProductEntity;
import com.mycompany.jv27_spring_project_final.entities.PromotionEntity;
import com.mycompany.jv27_spring_project_final.entities.ShippingEntity;
import com.mycompany.jv27_spring_project_final.entities.SizeEntity;
import com.mycompany.jv27_spring_project_final.entities.enums.OrderStatus;
import com.mycompany.jv27_spring_project_final.service.OrderDetailService;
import com.mycompany.jv27_spring_project_final.service.OrderService;
import com.mycompany.jv27_spring_project_final.service.ProductService;
import com.mycompany.jv27_spring_project_final.service.PromotionService;
import com.mycompany.jv27_spring_project_final.service.SizeService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author taing
 */
@Controller
public class OrderController {

    @Autowired
    private ProductService productService; 

    @Autowired
    private SizeService sizeService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private PromotionService promotionService;

    @Autowired
    private JavaMailSender mailSender;

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String cartPage(Model model) {
        return "cart";
    }

    @RequestMapping(value = "/checkout", method = RequestMethod.GET)
    public String checkoutPage(Model model, HttpSession session) {
        OrderEntity order = (OrderEntity) session.getAttribute("order");
        if (order == null) {
            return "redirect:/cart";
        }
        AccountEntity account = AccountUltil.getAccount();
        if (account != null) {
            model.addAttribute("account", account);
        }
        return "checkout";
    }

    @RequestMapping(value = "/checkout-process", method = RequestMethod.POST)
    public String checkoutProcess(Model model,
            HttpSession session,
            @ModelAttribute(value = "shipping") ShippingEntity shipping) {

        OrderEntity order = (OrderEntity) session.getAttribute("order");
        if (order == null) {
            return "redirect:/cart";
        }
        if (order.getOrderDetails().isEmpty()) {
            return "redirect:/cart";
        }
        order.setShipping(shipping);
        AccountEntity account = AccountUltil.getAccount();
        if (account != null) {
            order.setAccount(account);
        }
        order.setOrderDate(new Date());
        order.setTotalPrice(order.getTotal());
        OrderEntity ordersaved = orderService.saveOrder(order);
        if (ordersaved != null && ordersaved.getId() > 0) {
            boolean saveOk = true;
            for (OrderDetailEntity orderDetai : order.getOrderDetails()) {
                orderDetai.setOrder(ordersaved);
                OrderDetailEntity orderDetailSaved = orderDetailService.save(orderDetai);
                if (orderDetailSaved == null || orderDetailSaved.getId() < 1) {
                    saveOk = false;
                    break;
                }
            }
            if (saveOk) {
                session.removeAttribute("order");
                String host = "http://localhost:8080/JV27_Spring_Project_Final";
                String content = "<html>\n"
                        + "   <head>\n"
                        + "      <style>\n"
                        + "         *{\n"
                        + "         box-sizing: border-box;\n"
                        + "         }\n"
                        + "		 body{\n"
                        + "			margin: 0 auto;\n"
                        + "		 }\n"
                        + "         .table-footer{\n"
                        + "         font-weight: bold;\n"
                        + "         }\n"
                        + "         .order-info{\n"
                        + "         text-align: center;\n"
                        + "		 margin-bottom: 2em;\n"
                        + "         }\n"
                        + "         .order-info p{\n"
                        + "         color: #000;\n"
                        + "         font-weight: bold;\n"
                        + "         margin-bottom: 1em;\n"
                        + "         }\n"
                        + "         .table{\n"
                        + "         width: 90%;\n"
                        + "         max-width: 90%;\n"
                        + "         margin-bottom: 1rem;\n"
                        + "         background-color: transparent;\n"
                        + "         border-collapse: collapse;\n"
                        + "         display: table;\n"
                        + "         border-spacing: 2px;\n"
                        + "         border-color: grey;\n"
                        + "		 text-align: left;\n"
                        + "		 margin-left: 2em;\n"
                        + "		 margin-right: 2em;\n"
                        + "         }\n"
                        + "         .table tr {\n"
                        + "         display: table-row;\n"
                        + "         vertical-align: inherit;\n"
                        + "         border-color: inherit;\n"
                        + "         }\n"
                        + "         .table thead th {\n"
                        + "         vertical-align: bottom;\n"
                        + "         border-bottom: 2px solid #dee2e6;\n"
                        + "         }\n"
                        + "         .table td, .table th {\n"
                        + "         padding: .75rem;\n"
                        + "         vertical-align: top;\n"
                        + "         border-top: 1px solid #dee2e6;\n"
                        + "         }\n"
                        + "         tbody {\n"
                        + "         display: table-row-group;\n"
                        + "         vertical-align: middle;\n"
                        + "         border-color: inherit;\n"
                        + "         }\n"
                        + "      </style>\n"
                        + "   </head>\n"
                        + "   <body>\n"
                        + "      <div class=\"order-info\">\n"
                        + "         <p>Order Id: #" + order.getId() + "</p>\n"
                        + "         <p>Order Date: " + StringUltil.fromDateToUS(order.getOrderDate()) + "</p>\n"
                        + "         <p>Order Status: " + order.getStatus() + "</p>\n"
                        + "		 <a href=\"" + host + "/order-detail?id=" + order.getId() + "&email="+shipping.getEmail()+ "\">Click here to view order details</a>\n"
                        + "      </div>\n"
                        + "      <table class=\"table\">\n"
                        + "         <thead>\n"
                        + "            <tr>\n"
                        + "               <th>Product</th>\n"
                        + "               <th>Size</th>\n"
                        + "               <th>Price</th>\n"
                        + "               <th>Quantity</th>\n"
                        + "               <th>Total</th>\n"
                        + "            </tr>\n"
                        + "         </thead>\n"
                        + "         <tbody>";
                for (OrderDetailEntity od : order.getOrderDetails()) {
                    content += "<tr>\n"
                            + "               <td><a href=\"" + host + "/product?id=" + od.getProduct().getId() + "\">" + od.getProduct().getName() + "</a></td>\n"
                            + "               <td>" + od.getSize().getSize() + "</td>\n"
                            + "               <td>" + od.getProduct().getPrice() + "</td>\n"
                            + "               <td>" + od.getQuantity() + "</td>\n"
                            + "               <td>" + od.getTotal() + "</td>\n"
                            + "            </tr>";
                }
                content += "<tr class=\"table-footer\">\n"
                        + "               <td colspan=\"4\">Total</td>\n"
                        + "               <td>" + order.getTotal() + "</td>\n"
                        + "            </tr>\n"
                        + "         </tbody>\n"
                        + "      </table>\n"
                        + "	  \n"
                        + "   </body>\n"
                        + "</html>";
                try {
                    MimeMessage mimeMessage = mailSender.createMimeMessage();
                    MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
                    String htmlMsg = content;
                    mimeMessage.setContent(htmlMsg, "text/html");
                    helper.setTo(shipping.getEmail());
                    helper.setSubject("Little Closet Order Confirmation: #" + order.getId());
                    mailSender.send(mimeMessage);
                } catch (MailException | MessagingException m) {

                }
                model.addAttribute("id", order.getId());
                model.addAttribute("email", shipping.getEmail());
                model.addAttribute("messageSuccess", "Thank You For Your Purchase");
            } else {
                model.addAttribute("messageError", "Sorry, the order failed");
            }

        } else {
            model.addAttribute("messageError", "Sorry, the order failed");
        }

        return "checkoutStatus";
    }

    @RequestMapping("/order/{productId}/{sizeId}")
    public String orderProduct(HttpSession session, @PathVariable(value = "productId") int productId, @PathVariable(value = "sizeId") int sizeId) {
        OrderEntity order = (OrderEntity) session.getAttribute("order");
        if (order == null) {
            order = new OrderEntity();

            List<OrderDetailEntity> orderDetails = new ArrayList<>();

            ProductEntity product = productService.getProductById(productId);
            OrderDetailEntity orderDetail = new OrderDetailEntity();
            orderDetail.setProduct(product);
            orderDetail.setQuantity(1);
            SizeEntity size = sizeService.getSizeById(sizeId);
            orderDetail.setSize(size);

            orderDetails.add(orderDetail);
            order.setOrderDetails(orderDetails);
            session.setAttribute("order", order);
        } else {
            List<OrderDetailEntity> orderDetails = order.getOrderDetails();
            boolean isUpdate = false;
            for (OrderDetailEntity orderDetail : orderDetails) {
                if (orderDetail.getProduct().getId() == productId && orderDetail.getSize().getId() == sizeId) {
                    int quantity = orderDetail.getQuantity() + 1;
                    orderDetail.setQuantity(quantity);
                    isUpdate = true;
                    break;
                }
            }
            if (!isUpdate) {
                ProductEntity product = productService.getProductById(productId);
                OrderDetailEntity orderDetail = new OrderDetailEntity();
                orderDetail.setProduct(product);
                orderDetail.setQuantity(1);
                SizeEntity size = sizeService.getSizeById(sizeId);
                orderDetail.setSize(size);
                orderDetails.add(orderDetail);
            }
            order.setOrderDetails(orderDetails);
            session.setAttribute("order", order);
        }
        return "redirect:/cart";
    }

    @RequestMapping("/order/delete")
    public String deleteOrder(HttpSession session, 
            @RequestParam(value = "productId") int productId, 
            @RequestParam(value = "sizeId") int sizeId) {
        OrderEntity order = (OrderEntity) session.getAttribute("order");
        List<OrderDetailEntity> orderDetails = order.getOrderDetails();
        for (OrderDetailEntity orderDetail : orderDetails) {
            if (orderDetail.getProduct().getId() == productId && orderDetail.getSize().getId() == sizeId) {
                orderDetails.remove(orderDetail);
                break;
            }
        }
        order.setOrderDetails(orderDetails);
        session.setAttribute("order", order);
        return "redirect:/cart";
    }
    @RequestMapping("/order/cancel")
    public String guestCancelOrder(@RequestParam(value = "id") int orderId, 
            @RequestParam(value = "email") String email,
            @RequestHeader(value = "Referer") String referer) {
        OrderEntity order = orderService.getOrderByIdAndEmail(orderId, email);
        if(order == null){
            return "redirect:" + referer;
        }
        order.setStatus(OrderStatus.CANCELLED);
        orderService.saveOrder(order);
        return "redirect:" + referer;
    }

    @RequestMapping(value = "/order/update")
    public String updateOrder(HttpSession session, 
            @RequestParam(value = "productId") int productId, 
            @RequestParam(value = "sizeId") int sizeId, 
            @RequestParam(value = "quantity") int quantity) {
        OrderEntity order = (OrderEntity) session.getAttribute("order");
        List<OrderDetailEntity> orderDetails = order.getOrderDetails();
        for (OrderDetailEntity orderDetail : orderDetails) {
            if (orderDetail.getProduct().getId() == productId && orderDetail.getSize().getId() == sizeId) {
                if (quantity <= 0) {
                    quantity = 1;
                }
                orderDetail.setQuantity(quantity);
                break;
            }
        }
        order.setOrderDetails(orderDetails);
        session.setAttribute("order", order);
        return "redirect:/cart";
    }

    @RequestMapping(value = "/order/clear")
    public String clearOrder(HttpSession session) {
        OrderEntity order = (OrderEntity) session.getAttribute("order");
        if (order != null) {
            session.removeAttribute("order");
        }       
        return "redirect:/cart";
    }

    @RequestMapping(value = "/order/cancel/{id}")
    public String cancelOrder(Model model, @PathVariable(value = "id") int id) {
        AccountEntity account = AccountUltil.getAccount();
        List<OrderEntity> orders = orderService.getOrdersByAccountId(account.getId());
        for (int i = 0; i < orders.size(); i++) {
            OrderEntity order = orders.get(i);
            if (order.getId() == id) {
                order.setStatus(OrderStatus.CANCELLED);
                orderService.saveOrder(order);
                break;
            }
        }
        return "redirect:/account?action=myorder";
    }

    @RequestMapping(value = "/apply-promotion", method = RequestMethod.POST)
    public String applyPromotion(Model model, 
            HttpSession session, 
            @ModelAttribute(value = "promotion_name") String promotion_name) {
        OrderEntity order = (OrderEntity) session.getAttribute("order");
        if (order == null) {
            return "redirect:/cart";
        }
        boolean isPromotionApply = false;
        List<OrderDetailEntity> orderDetails = order.getOrderDetails();
        for (int i = 0; i < orderDetails.size(); i++) {
            OrderDetailEntity od = orderDetails.get(i);
            PromotionEntity promotion = promotionService.getPromotionByPromotionNameAndProductId(promotion_name, od.getProduct().getId());
            if (promotion != null) {
                isPromotionApply = true;
                if (od.getPromotion() == null) {
                    od.setPromotion(promotion);
                }
            }
            orderDetails.set(i, od);
        }
        order.setTotalPrice(order.getTotal());
        order.setOrderDetails(orderDetails);
        session.setAttribute("order", order);
        if (isPromotionApply) {
            model.addAttribute("messageSuccess", "Successfully added promotion");
        } else {
            model.addAttribute("messageError", "Invalid promotional code");
        }
        return "cart";
    }

    @RequestMapping(value = "/remove-promotion")
    public String removePromotion(HttpSession session, 
            @RequestParam(value = "id") int id) {
        OrderEntity order = (OrderEntity) session.getAttribute("order");
        if (order != null) {
            List<OrderDetailEntity> orderDetails = order.getOrderDetails();
            for (int i = 0; i < orderDetails.size(); i++) {
                OrderDetailEntity od = orderDetails.get(i);
                if (od.getPromotion() != null && od.getPromotion().getId() == id) {
                    od.setPromotion(null);
                    orderDetails.set(i, od);
                }
            }
            order.setOrderDetails(orderDetails);
            session.setAttribute("order", order);
        }
        return "redirect:/cart";
    }

    @RequestMapping(value = "/order-detail")
    public String viewOrderDetail(Model model, 
            @RequestParam(value = "id") int id,
            @RequestParam(value = "email") String email) {
        OrderEntity order = orderService.getOrderById(id);
        if(!order.getShipping().getEmail().equals(email)){
            return "redirect:/home";
        }
        List<OrderDetailEntity> orderDetails = order.getOrderDetails();
        for (int i = 0; i < orderDetails.size(); i++) {
            OrderDetailEntity od = orderDetails.get(i);
            PromotionEntity promo = promotionService.getPromotionByOrderDetailId(od.getId());
            if (promo != null) {
                od.setPromotion(promo);
                orderDetails.set(i, od);
            }
        }
        order.setOrderDetails(orderDetails);
        model.addAttribute("vieworder", order);
        return "order-detail";
    }

}
