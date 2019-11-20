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
import com.mycompany.jv27_spring_project_final.entities.ProductEntity;
import com.mycompany.jv27_spring_project_final.entities.SizeEntity;
import com.mycompany.jv27_spring_project_final.service.CategoryService;
import com.mycompany.jv27_spring_project_final.service.CommentService;
import com.mycompany.jv27_spring_project_final.service.FavoriteService;
import com.mycompany.jv27_spring_project_final.service.ProductService;
import com.mycompany.jv27_spring_project_final.service.PromotionService;
import com.mycompany.jv27_spring_project_final.service.SizeService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author taing
 */
@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

    @Autowired
    private SizeService sizeService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private FavoriteService favoriteService;

    @Autowired
    private PromotionService promotionService;
    
     @Autowired
     private CategoryService categoryService;

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String homePage(Model model,
            @RequestParam(value = "page", required = false) Integer page) {        
        if (page == null || page <= 0) {
            page = 1;
        }
        Page<ProductEntity> productsPage = productService.getProductsActive(page);
        List<ProductEntity> productsList = productsPage.getContent();
        List<ProductEntity> products = new ArrayList<>();
        for (int i = 0; i < productsList.size(); i++) {
            ProductEntity product = productsList.get(i);
            List<FavoriteEntity> favs = favoriteService.getFavoritesByProductId(product.getId());
            product.setFavorites(favs);
            products.add(product);
        }
        model.addAttribute("page", productsPage.getTotalPages());
        model.addAttribute("products", products);
        return "home";
    }

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public String categoryPageLimit(Model model, 
            @RequestParam("id") int id, 
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "sort", required = false) String sort) {
        if (page == null || page <= 0) {
            page = 1;
        }
        Page<ProductEntity> productsPage = null;
        if(sort==null || sort.isEmpty()){
            productsPage = productService.getProductByCategoryId(id,page,"none");
        }else{
            productsPage = productService.getProductByCategoryId(id,page,sort);
        }
        
        List<ProductEntity> productsList = productsPage.getContent();
        List<ProductEntity> products = new ArrayList<>();
        for (int i = 0; i < productsList.size(); i++) {
            ProductEntity product = productsList.get(i);
            List<FavoriteEntity> favs = favoriteService.getFavoritesByProductId(product.getId());
            product.setFavorites(favs);
            products.add(product);
        }
        model.addAttribute("category", categoryService.getCategoryById(id));
        model.addAttribute("page", productsPage.getTotalPages());
        model.addAttribute("products", products);
        return "category";
    }

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String productPage(Model model, @RequestParam("id") int id) {
        ProductEntity product = productService.getProductById(id);
        List<SizeEntity> sizes = sizeService.getSizeByProductId(id);
        model.addAttribute("product", product);
        model.addAttribute("sizes", sizes);
        List<CommentEntity> comments = commentService.getCommentsByProductId(id);
        model.addAttribute("comments", comments);
        model.addAttribute("favorites", favoriteService.countFavoriteByProductId(id));
        AccountEntity account = AccountUltil.getAccount();
        if (account != null) {
            FavoriteEntity fav = favoriteService.getFavotiteByAccountIDAndProductID(account.getId(), id);
            if (fav != null) {
                model.addAttribute("favorited", true);
            } else {
                model.addAttribute("favorited", false);
            }
        } else {
            model.addAttribute("favorited", false);
        }
        model.addAttribute("promotions", promotionService.getPromotionsByProductId(id));
        return "product";
    }

}
