/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jv27_spring_project_final.service;

import com.mycompany.jv27_spring_project_final.entities.CommentEntity;
import com.mycompany.jv27_spring_project_final.repository.CommentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author taing
 */
@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    
    public List<CommentEntity> getCommentsByProductId(int id){
        return commentRepository.findByProduct_id(id);
    }
    
    public CommentEntity save(CommentEntity comment){
        return (CommentEntity) commentRepository.save(comment);
    }
}
