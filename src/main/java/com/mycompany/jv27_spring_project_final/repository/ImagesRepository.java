/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jv27_spring_project_final.repository;

import com.mycompany.jv27_spring_project_final.entities.ImagesEntity;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author taing
 */
@Repository
public interface ImagesRepository extends CrudRepository<ImagesEntity, Integer>{
    List<ImagesEntity> findByProduct_idOrderByIdAsc(int id);
    ImagesEntity findById(int id);
}
