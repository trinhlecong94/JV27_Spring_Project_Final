/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jv27_spring_project_final.controller;

import com.mycompany.jv27_spring_project_final.Ultil.AccountUltil;
import com.mycompany.jv27_spring_project_final.entities.AccountEntity;
import com.mycompany.jv27_spring_project_final.entities.CommentEntity;
import com.mycompany.jv27_spring_project_final.entities.FavoriteEntity;
import com.mycompany.jv27_spring_project_final.entities.OrderEntity;
import com.mycompany.jv27_spring_project_final.entities.ProductEntity;
import com.mycompany.jv27_spring_project_final.entities.PromotionEntity;
import com.mycompany.jv27_spring_project_final.service.AccountService;
import com.mycompany.jv27_spring_project_final.service.CommentService;
import com.mycompany.jv27_spring_project_final.service.FavoriteService;
import com.mycompany.jv27_spring_project_final.service.OrderService;
import com.mycompany.jv27_spring_project_final.service.ProductService;
import com.mycompany.jv27_spring_project_final.service.PromotionService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
public class FunctionController {

    @Autowired
    private ProductService productService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private FavoriteService favoriteService;

    @Autowired
    private PromotionService promotionService;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(Model model,
            @RequestParam(value = "searchText") String searchText,
            @RequestParam(value = "action") String action,
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "sort", required = false) String sort) {
        if (page == null || page <= 0) {
            page = 1;
        }
        int id;
        try {
            id = Integer.valueOf(searchText);
        } catch (NumberFormatException e) {
            id = 0;
        }
        if (action.equals("searchProduct")) {           
            Page<ProductEntity> productsPage;
            if(sort==null || sort.isEmpty()){
                productsPage = productService.getProductsActive(page, "none");
            }else if(searchText==null || searchText.isEmpty()){
                productsPage = productService.getProductsActive(page, sort);
            }else{
                productsPage = productService.getProductByAnyActive(searchText, page, sort);
            }
            List<ProductEntity> products = new ArrayList<>(productsPage.getContent());
            for (int i = 0; i < products.size(); i++) {
                ProductEntity product = products.get(i);
                List<FavoriteEntity> favs = favoriteService.getFavoritesByProductId(product.getId());
                product.setFavorites(favs);
                products.set(i, product);
            }
            model.addAttribute("page", productsPage.getTotalPages());
            model.addAttribute("products", products);
            return "home";
        } else if (action.equals("searchAccount")) {
            Page<AccountEntity> accountsPage = accountService.searchAccounts(searchText, page);
            model.addAttribute("accounts", accountsPage.getContent());
            model.addAttribute("page", accountsPage.getTotalPages());
            return "admin/account-manager";
        } else if (action.equals("searchProductSeller")) {
            boolean searchId = false;
            if (id > 0) {
                List<ProductEntity> products = new ArrayList<>();
                ProductEntity product = productService.getProductById(id);
                if (product != null) {
                    products.add(product);
                    searchId = true;
                }
                model.addAttribute("products", products);
            }
            if (!searchId) {
                Page<ProductEntity> productsPage = productService.getProductByAny(searchText, page);
                List<ProductEntity> products = new ArrayList<>(productsPage.getContent());
                model.addAttribute("products", products);
                model.addAttribute("page", productsPage.getTotalPages());
            }

            return "seller/product-manager";
        } else if (action.equals("searchOrderSeller")) {
            boolean searchId = false;
            if (id > 0) {
                List<OrderEntity> orders = new ArrayList<>();
                OrderEntity order = orderService.getOrderById(id);
                if (order != null) {
                    AccountEntity account = accountService.findAccountByOrderId(order.getId());
                    order.setAccount(account);
                    orders.add(order);
                    searchId = true;
                }
                model.addAttribute("orders", orders);
            }
            if (!searchId) {
                Page<OrderEntity> ordersPage = orderService.getOrdersByAny(searchText, page);
                List<OrderEntity> orders = new ArrayList<>(ordersPage.getContent());
                for (int i = 0; i < orders.size(); i++) {
                    OrderEntity order = orders.get(i);
                    AccountEntity account = accountService.findAccountByOrderId(order.getId());
                    order.setAccount(account);
                    orders.set(i, order);
                }
                model.addAttribute("orders", orders);
                model.addAttribute("page", ordersPage.getTotalPages());
            }
            return "seller/order-manager";
        } else if (action.equals("searchPromotion")) {
            boolean searchId = false;
            if (id > 0) {
                List<PromotionEntity> promos = new ArrayList<>();
                PromotionEntity promo = promotionService.getPromotionById(id);
                if (promo != null) {
                    promos.add(promo);
                    searchId = true;
                }
                model.addAttribute("promos", promos);
            }
            if (!searchId) {
                Page<PromotionEntity> promosPage = promotionService.getPromotionByNameOrDescription(searchText, page);
                List<PromotionEntity> promos = new ArrayList<>(promosPage.getContent());
                model.addAttribute("promos", promos);
                model.addAttribute("page", promosPage.getTotalPages());
            }
            return "seller/promo-manager";
        }
        return "redirect:/home";
    }

    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public String comment(@ModelAttribute(value = "content") String content,
            @ModelAttribute(value = "productId") int productId) {
        AccountEntity account = AccountUltil.getAccount();
        if (account != null) {
            ProductEntity product = productService.getProductById(productId);
            CommentEntity comment = new CommentEntity();
            comment.setContent(content);
            comment.setCommentDate(new Date());
            comment.setAccount(account);
            comment.setProduct(product);
            commentService.save(comment);
        }
        return "redirect:/product?id=" + productId;
    }

}
