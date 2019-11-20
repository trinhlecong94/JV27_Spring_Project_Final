/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jv27_spring_project_final.service;

import com.mycompany.jv27_spring_project_final.entities.CategoryEntity;
import com.mycompany.jv27_spring_project_final.repository.CategoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author taing
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    
    public CategoryEntity getCategoryById(int id){
        return categoryRepository.findById(id);
    }
    
    public List<CategoryEntity> getCategorys(){
        return (List<CategoryEntity>) categoryRepository.findAll();
    }
}
