/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jv27_spring_project_final.service;

import com.mycompany.jv27_spring_project_final.entities.PromotionEntity;
import com.mycompany.jv27_spring_project_final.repository.PromotionRepository;
import java.io.Serializable;
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
public class PromotionService implements Serializable{
    @Autowired
    private PromotionRepository promotionRepository;
    
    public List<PromotionEntity> getPromotions(){
        return (List<PromotionEntity>) promotionRepository.findAll();
    }
    
    public Page<PromotionEntity> getPromotions(int page){
        Pageable pageable = new PageRequest(page-1, 9, Sort.Direction.DESC, "id");
        return (Page<PromotionEntity>) promotionRepository.findAll(pageable);
    }
    
    public List<PromotionEntity> getPromotionsByProductId(int id){
    
        return promotionRepository.findPromotionByProductId(id);
    }
    
    public PromotionEntity save(PromotionEntity promo){
        return (PromotionEntity) promotionRepository.save(promo);
    }
    
    public PromotionEntity getPromotionByPromotionNameAndProductId(String promotionName, int productId) {
        return promotionRepository.findPromotionByPromotionCodeAndProductId(promotionName, productId);
    }
    
    public PromotionEntity getPromotionByOrderDetailId(int orderDetailId) {
        return promotionRepository.findPromotionByOrderDetailId(orderDetailId);
    }
    
    public PromotionEntity getPromotionByName(String name){
        return promotionRepository.findByNameLike(name);
    }
    
    public PromotionEntity getPromotionById(int id){
        return promotionRepository.findById(id);
    }
    
    public Page<PromotionEntity> getPromotionByNameOrDescription(String searchText, int page){
        Pageable pageable = new PageRequest(page-1, 9);
        return promotionRepository.findNameOrDescription(searchText, pageable);
    }
}
