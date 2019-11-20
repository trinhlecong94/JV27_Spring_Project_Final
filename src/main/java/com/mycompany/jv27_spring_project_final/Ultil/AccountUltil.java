/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jv27_spring_project_final.Ultil;

import com.mycompany.jv27_spring_project_final.entities.AccountEntity;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author taing
 */
public class AccountUltil {
    public static AccountEntity getAccount(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof AccountEntity) {
            AccountEntity accountEntity = (AccountEntity) principal;
            return accountEntity;
        }   
        return null;
    }
}
