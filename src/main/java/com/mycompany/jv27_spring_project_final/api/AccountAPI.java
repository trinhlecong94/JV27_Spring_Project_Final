/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jv27_spring_project_final.api;

import com.mycompany.jv27_spring_project_final.Ultil.AccountUltil;
import com.mycompany.jv27_spring_project_final.Ultil.StringUltil;
import com.mycompany.jv27_spring_project_final.entities.AccountEntity;
import com.mycompany.jv27_spring_project_final.entities.FavoriteEntity;
import com.mycompany.jv27_spring_project_final.entities.ImagesEntity;
import com.mycompany.jv27_spring_project_final.entities.ProductEntity;
import com.mycompany.jv27_spring_project_final.service.FavoriteService;
import com.mycompany.jv27_spring_project_final.service.ImagesService;
import com.mycompany.jv27_spring_project_final.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author taing
 */
@RestController
@RequestMapping("/api")
public class AccountAPI {

    @Autowired
    private FavoriteService favoriteService;
    
    @Autowired
    private ProductService productService;
    
    @Autowired
    private ImagesService imagesService;

    @RequestMapping(value = "/favorite/{productId}", method = RequestMethod.GET)
    public Object getBook(@PathVariable(value = "productId") int productId) {
        AccountEntity account = AccountUltil.getAccount();
        if (account != null) {
            FavoriteEntity fav = favoriteService.getFavotiteByAccountIDAndProductID(account.getId(), productId);
            if (fav == null) {                             
                fav = new FavoriteEntity();
                fav.setAccount(account);
                ProductEntity product = productService.getProductById(productId);
                fav.setProduct(product);
                FavoriteEntity favsaved =  favoriteService.save(fav);
                if(favsaved!=null && favsaved.getId()>0){
                    return "favorited";
                }                
            }else{
                fav.setAccount(account);
                ProductEntity product = productService.getProductById(productId);
                fav.setProduct(product);
                favoriteService.delete(fav);
                return "unfavorited";
            }
        }
        return "login";
    }
    @RequestMapping(value = "/add-product-img", method = RequestMethod.GET)
    public Object addImg(@RequestParam(value = "id") int productId,
            @RequestParam(value = "url") String url){
        if(!StringUltil.isValid(url)){return "error_img";}
        ProductEntity product = productService.getProductById(productId);
        ImagesEntity img = new ImagesEntity();
        img.setProduct(product);
        img.setUrl(url);
        ImagesEntity imgSaved = imagesService.addImage(img);
        if(imgSaved!=null && imgSaved.getId()>0){
            return "true|" + imgSaved.getId();
        }
        return "error_add";
    }
    @RequestMapping(value = "/delete-product-img/{id}", method = RequestMethod.GET)
    public Object deleteImg(@PathVariable(value = "id") Integer id){
        if(id==null||id<=0){
            return "error_id";
        }
        if(imagesService.deleteImageById(id)){
            return "true";
        }
        return "error_delete";
    }
}
