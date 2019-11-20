/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jv27_spring_project_final.controller;

import com.mycompany.jv27_spring_project_final.entities.AccountEntity;
import com.mycompany.jv27_spring_project_final.entities.OrderDetailEntity;
import com.mycompany.jv27_spring_project_final.entities.OrderEntity;
import com.mycompany.jv27_spring_project_final.entities.PromotionEntity;
import com.mycompany.jv27_spring_project_final.service.AccountService;
import com.mycompany.jv27_spring_project_final.service.OrderService;
import com.mycompany.jv27_spring_project_final.service.PromotionService;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author taing
 */
@Controller
public class ExportController {
    @Autowired
    private OrderService orderService;
    
    @Autowired
    private AccountService accountService;
    
    @Autowired
    private PromotionService promotionService;
    
    @RequestMapping(value = "/downloadOrderExcel")
    public String downloadOrderExcel(Model model, HttpServletResponse response) throws IOException{
        List<OrderEntity> orders = orderService.getOrders();
            for (int i = 0; i < orders.size(); i++) {
                OrderEntity order = orders.get(i);
                AccountEntity account = accountService.findAccountByOrderId(order.getId());
                order.setAccount(account);
                List<OrderDetailEntity> orderDetails = order.getOrderDetails();
                for (int j = 0; j < orderDetails.size(); j++){
                    OrderDetailEntity od = orderDetails.get(j);
                    PromotionEntity promotion = promotionService.getPromotionByOrderDetailId(od.getId());
                    od.setPromotion(promotion);
                    orderDetails.set(j, od);
                }
                order.setOrderDetails(orderDetails);
                orders.set(i, order);
            }
        model.addAttribute("orders", orders);
        return "excelView";
    }
}
