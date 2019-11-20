/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jv27_spring_project_final.service;

import com.mycompany.jv27_spring_project_final.entities.OrderEntity;
import com.mycompany.jv27_spring_project_final.repository.OrderRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author taing
 */
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    
    public OrderEntity saveOrder(OrderEntity order){
        return orderRepository.save(order);
    }
    
    public List<OrderEntity> getOrders(){
        return (List<OrderEntity>) orderRepository.findAll();
    }
    
    public Page<OrderEntity> getOrders(int page){
        Pageable pageable = new PageRequest(page-1, 9, Sort.Direction.DESC, "orderDate");
        return (Page<OrderEntity>) orderRepository.findAll(pageable);
    }
    
    public Page<OrderEntity> getOrdersByAccountId(int id, int page){
        Pageable pageable = new PageRequest(page-1, 9);
        return orderRepository.findByAccount_id(id,pageable);
    }
    
    public List<OrderEntity> getOrdersByAccountId(int id){
        return orderRepository.findByAccount_id(id);
    }
    
    public OrderEntity getOrderById(int id){
        return orderRepository.findById(id);
    }
    
    public Page<OrderEntity> getOrdersByAny(String searchtext, int page){
        Pageable pageable = new PageRequest(page-1, 9);     
        Date birthday = null;
        try{
            birthday =new SimpleDateFormat("yyyy-MM-dd").parse(searchtext);  
        }catch(ParseException e){
            
        }
        if(birthday!=null){
            return orderRepository.findOrderByDate(birthday,pageable);
        }
        return orderRepository.findOrderByAny(searchtext,pageable);
    }
    
    public OrderEntity getOrderByIdAndEmail(int id, String email){
        return orderRepository.findOrderByIdAndEmail(id, email);
    }
}
