/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jv27_spring_project_final.repository;

import com.mycompany.jv27_spring_project_final.entities.FavoriteEntity;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author taing
 */
@Repository
public interface FavoriteRepository extends CrudRepository<FavoriteEntity, Integer>{
    @Query(value = "select count(*) from favorite where product_id = ?1", nativeQuery = true)
    int countFavoriteByProductId(int productId);
    
    FavoriteEntity findByAccount_idAndProduct_id(int account_id, int product_id);   
    
    List<FavoriteEntity> findByProduct_id(int product_id);
    
}
