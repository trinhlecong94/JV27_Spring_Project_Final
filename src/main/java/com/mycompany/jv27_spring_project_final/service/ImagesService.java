/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jv27_spring_project_final.service;

import com.mycompany.jv27_spring_project_final.entities.ImagesEntity;
import com.mycompany.jv27_spring_project_final.repository.ImagesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author taing
 */
@Service
public class ImagesService {
    @Autowired
    private ImagesRepository imagesRepository;
    
    public void saveImages(List<ImagesEntity> images){
        for(int i=0;i<images.size();i++){
            imagesRepository.save(images.get(i));
        }      
    }
    
    public ImagesEntity addImage(ImagesEntity img){
        return (ImagesEntity) imagesRepository.save(img);
    }
    
    public boolean deleteImageById(int id){
        ImagesEntity img = imagesRepository.findById(id);
        if(img==null){
            return false;
        }
        imagesRepository.delete(img);
        return true;
    }
    
    public List<ImagesEntity> getProductImagesByProductId(int productID){
        return imagesRepository.findByProduct_idOrderByIdAsc(productID);
    }    
    
}
