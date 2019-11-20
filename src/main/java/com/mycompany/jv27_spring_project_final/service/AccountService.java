/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jv27_spring_project_final.service;

import com.mycompany.jv27_spring_project_final.entities.AccountEntity;
import com.mycompany.jv27_spring_project_final.repository.AccountRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author taing
 */
@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    
    public AccountEntity findAccountByUsernameAndPassword(String username, String password){
        return accountRepository.findByUsernameLikeAndPasswordLike(username, password);
    }
    
    public List<AccountEntity> getAccounts(){
        return (List<AccountEntity>) accountRepository.findAll();
    }
    
    public Page<AccountEntity> getAccounts(int page){
        Pageable pageable = new PageRequest(page-1, 9);
        return (Page<AccountEntity>) accountRepository.findAll(pageable);
    }
    
    public Page<AccountEntity> searchAccounts(String searchText, int page){
        Pageable pageable = new PageRequest(page-1, 9);
        return accountRepository.findAccountByAny(searchText, pageable);
    }
    
    public AccountEntity getAccountById(int id){
        return accountRepository.findById(id);
    }
    
    public AccountEntity saveAccount(AccountEntity account){
        return (AccountEntity) accountRepository.save(account);
    }
    
    public AccountEntity findAccountByOrderId(int id){
        return accountRepository.findAccountByOrderId(id);
    }
    
    public AccountEntity getAccountByEmail(String email){
        return accountRepository.findByEmail(email);
    }
    
    public AccountEntity getAccountByUsername(String username){
        return accountRepository.findByUsername(username);
    }
}
