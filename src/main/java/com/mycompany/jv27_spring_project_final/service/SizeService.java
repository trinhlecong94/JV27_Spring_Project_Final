/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jv27_spring_project_final.service;

import com.mycompany.jv27_spring_project_final.entities.SizeEntity;
import com.mycompany.jv27_spring_project_final.repository.SizeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author taing
 */
@Service
public class SizeService {
    @Autowired
    private SizeRepository sizeRepository;
    
    public List<SizeEntity> getSizes(){
        return (List<SizeEntity>) sizeRepository.findAll();
    }   
    
    public List<SizeEntity> getSizeByProductId(int id){
        return sizeRepository.findSizeByProductId(id);
    }
    
    public SizeEntity getSizeById(int id){
        return sizeRepository.findById(id);
    }
}
