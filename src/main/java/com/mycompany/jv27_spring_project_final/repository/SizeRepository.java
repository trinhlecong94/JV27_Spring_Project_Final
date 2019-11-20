/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jv27_spring_project_final.repository;

import com.mycompany.jv27_spring_project_final.entities.SizeEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author taing
 */
@Repository
public interface SizeRepository extends CrudRepository<SizeEntity, Integer>{
   @Query(value = "select size.id,size.size from size join product_size_relation on size.id = product_size_relation.size_id where product_size_relation.product_id = ?1 order by size.id asc", nativeQuery = true)
   List<SizeEntity> findSizeByProductId(int id);
   
   SizeEntity findById(int id);
}
