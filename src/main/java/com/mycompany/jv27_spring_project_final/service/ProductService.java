/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jv27_spring_project_final.service;

import com.mycompany.jv27_spring_project_final.entities.ProductEntity;
import com.mycompany.jv27_spring_project_final.entities.enums.ActiveStatus;
import com.mycompany.jv27_spring_project_final.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author taing
 */
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    
    public Page<ProductEntity> getPorducts(int page){
        Pageable pageable = new PageRequest(page-1, 9);
        return (Page<ProductEntity>) productRepository.findAll(pageable);
    }
    
    public List<ProductEntity> getPorducts(){
        return (List<ProductEntity>) productRepository.findAll();
    }
       
    
    public List<ProductEntity> getProductsActive(){
        return productRepository.findAllActiveProduct(ActiveStatus.ACTIVE);
    }
    
    public Page<ProductEntity> getProductsActive(int page){
        Pageable pageable = new PageRequest(page-1, 9, Sort.Direction.DESC, "date");
        return productRepository.findAllActiveProductPageable(ActiveStatus.ACTIVE,pageable);
    }
    
    public Page<ProductEntity> getProductsActive(int page, String sort){
        Pageable pageable;
        if(sort.equals("Latest")){
            pageable = new PageRequest(page-1, 9, Sort.Direction.DESC, "date");
        }else if(sort.equals("Oldest")){
            pageable = new PageRequest(page-1, 9, Sort.Direction.ASC, "date");
        }else if(sort.equals("HightoLow")){
            pageable = new PageRequest(page-1, 9, Sort.Direction.DESC, "price");
        }else if(sort.equals("LowtoHigh")){
            pageable = new PageRequest(page-1, 9, Sort.Direction.ASC, "price");
        }else{
            pageable = new PageRequest(page-1, 9, Sort.Direction.DESC, "date");
        }        
        return productRepository.findAllActiveProductPageable(ActiveStatus.ACTIVE,pageable);
    }
    
    public ProductEntity saveProduct(ProductEntity product){
        return productRepository.save(product);
    }   
   
    
    public ProductEntity getProductById(int id){
        return productRepository.findById(id);
    }
    
    public Page<ProductEntity> getProductByCategoryId(int categoryId, int page, String sort){
        Pageable pageable;
        if(sort.equals("Latest")){
            pageable = new PageRequest(page-1, 6, Sort.Direction.DESC, "date");
        }else if(sort.equals("Oldest")){
            pageable = new PageRequest(page-1, 6, Sort.Direction.ASC, "date");
        }else if(sort.equals("HightoLow")){
            pageable = new PageRequest(page-1, 6, Sort.Direction.DESC, "price");
        }else if(sort.equals("LowtoHigh")){
            pageable = new PageRequest(page-1, 6, Sort.Direction.ASC, "price");
        }else{
            pageable = new PageRequest(page-1, 6, Sort.Direction.DESC, "date");
        }        
        return productRepository.findProductByCategoryID(categoryId,ActiveStatus.ACTIVE,pageable);
    }
    
    public Page<ProductEntity> getProductByAny(String searchText, int page){  
        Pageable pageable = new PageRequest(page-1, 9);
        return productRepository.findProductByAny(searchText, pageable);
    }
    
    public Page<ProductEntity> getProductByAnyActive(String searchText, int page, String sort){
        Pageable pageable;
        if(sort.equals("Latest")){
            pageable = new PageRequest(page-1, 9, Sort.Direction.DESC, "date");
        }else if(sort.equals("Oldest")){
            pageable = new PageRequest(page-1, 9, Sort.Direction.ASC, "date");
        }else if(sort.equals("HightoLow")){
            pageable = new PageRequest(page-1, 9, Sort.Direction.DESC, "price");
        }else if(sort.equals("LowtoHigh")){
            pageable = new PageRequest(page-1, 9, Sort.Direction.ASC, "price");
        }else{
            pageable = new PageRequest(page-1, 9, Sort.Direction.DESC, "date");
        }        
        return productRepository.findProductByAnyActive(searchText,ActiveStatus.ACTIVE,pageable);
    }
    
    public List<ProductEntity> getProductsByPromotionId(int id){
        return productRepository.findAllProductByPromotionId(id);
    }
    
    public ProductEntity getProductByCode(String code){
        return productRepository.findByCodeLike(code);
    }
       
}
