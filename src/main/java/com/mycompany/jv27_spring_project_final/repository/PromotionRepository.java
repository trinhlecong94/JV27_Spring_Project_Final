/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jv27_spring_project_final.repository;

import com.mycompany.jv27_spring_project_final.entities.PromotionEntity;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author taing
 */
@Repository
public interface PromotionRepository extends PagingAndSortingRepository<PromotionEntity, Integer>{
    PromotionEntity findById(int id);
    
    @Query(value = "select promotion.id,promotion.name,promotion.description,promotion.discount,promotion.start_date,promotion.end_date,promotion.status from promotion join product_promotion_relation on promotion.id = product_promotion_relation.promotion_id where promotion.status = 'ACTIVE' and product_promotion_relation.product_id = ?1", nativeQuery = true )
    List<PromotionEntity> findPromotionByProductId(int id);
    
    @Query(value = "select promotion.id,promotion.name,promotion.description,promotion.discount,promotion.start_date,promotion.end_date,promotion.status from promotion join product_promotion_relation on promotion.id = product_promotion_relation.promotion_id where promotion.status = 'ACTIVE' and promotion.name = ?1 and product_promotion_relation.product_id = ?2", nativeQuery = true )
    PromotionEntity findPromotionByPromotionCodeAndProductId(String name, int id);
    
    @Query(value = "select promotion.id,promotion.name,promotion.description,promotion.discount,promotion.start_date,promotion.end_date,promotion.status from promotion join order_detail on promotion.id = order_detail.promotion_id where order_detail.id = ?1", nativeQuery = true )
    PromotionEntity findPromotionByOrderDetailId(int orderDetailID);
    
    PromotionEntity findByNameLike(String name);
    
    @Query(value = "select p from PromotionEntity p where p.name like %:searchText% or p.description like %:searchText%")
    Page<PromotionEntity> findNameOrDescription(@Param("searchText") String searchText, Pageable pageable);
}
