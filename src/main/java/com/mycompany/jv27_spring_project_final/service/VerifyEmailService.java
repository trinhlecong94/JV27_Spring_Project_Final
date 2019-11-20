/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jv27_spring_project_final.service;

import com.mycompany.jv27_spring_project_final.entities.VerifyEmailEntity;
import com.mycompany.jv27_spring_project_final.repository.VerifyEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author taing
 */
@Service
public class VerifyEmailService {
    @Autowired
    private VerifyEmailRepository verifyEmailRepository;
    
    public VerifyEmailEntity save(VerifyEmailEntity v){
        return (VerifyEmailEntity) verifyEmailRepository.save(v);
    }
    
    public void delete(VerifyEmailEntity v){
        verifyEmailRepository.delete(v);
    }
    
    public VerifyEmailEntity getVerify(String email, String code){
        return verifyEmailRepository.findByEmailLikeAndCodeLike(email, code);
    }
}
