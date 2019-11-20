/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jv27_spring_project_final.service;

import com.mycompany.jv27_spring_project_final.entities.AccountRoleEntity;
import com.mycompany.jv27_spring_project_final.entities.enums.Role;
import com.mycompany.jv27_spring_project_final.repository.AccountRoleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author taing
 */
@Service
public class AccountRoleService {
    @Autowired 
    private AccountRoleRepository accountRoleRepository;
    
    public List<AccountRoleEntity> getAccountRoles(){
        return (List<AccountRoleEntity>) accountRoleRepository.findAll();
    }
    
    public AccountRoleEntity getAccountRolesByRole(Role role){
        return accountRoleRepository.findByRoles(role);
    }
}
