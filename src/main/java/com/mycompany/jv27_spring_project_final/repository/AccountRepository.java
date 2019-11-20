/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jv27_spring_project_final.repository;

import com.mycompany.jv27_spring_project_final.entities.AccountEntity;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author taing
 */
@Repository
public interface AccountRepository extends PagingAndSortingRepository<AccountEntity, Integer>{
    AccountEntity findByUsernameLikeAndPasswordLike(String username, String password);
    
    @Query(value = "select a from AccountEntity a where a.username = :searchText or a.fullName like %:searchText% or a.email = :searchText or a.phone = :searchText or a.address like %:searchText%")
    Page<AccountEntity> findAccountByAny(@Param("searchText") String searchText, Pageable pageable);
    
    AccountEntity findById(Integer id);
    
    AccountEntity findByEmail(String email);
    
    AccountEntity findByUsername(String username);
    
    @Query(value = "select account.id,account.address,account.birthday,account.email,account.full_name,account.password,account.phone,account.status,account.user_name from account join orders on account.id = orders.account_id where orders.id = ?1", nativeQuery = true)
    AccountEntity findAccountByOrderId(int orderId);
}
