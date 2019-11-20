/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jv27_spring_project_final.service;

import com.mycompany.jv27_spring_project_final.entities.FavoriteEntity;
import com.mycompany.jv27_spring_project_final.repository.FavoriteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author taing
 */
@Service
public class FavoriteService {
    @Autowired
    private FavoriteRepository favoriteRepository;
    
    public int countFavoriteByProductId(int id){
        return favoriteRepository.countFavoriteByProductId(id);
    }
    
    public List<FavoriteEntity> getFavoritesByProductId(int id){
        return favoriteRepository.findByProduct_id(id);
    }
    
    public FavoriteEntity getFavotiteByAccountIDAndProductID(int accountid, int productid){
        return favoriteRepository.findByAccount_idAndProduct_id(accountid, productid);
    }
    public void delete(FavoriteEntity fav){
        favoriteRepository.delete(fav);
    }
    
    public FavoriteEntity save(FavoriteEntity fav){
        return favoriteRepository.save(fav);
    }
}
