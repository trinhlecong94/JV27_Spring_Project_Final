/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jv27_spring_project_final.repository;

import com.mycompany.jv27_spring_project_final.entities.ProductEntity;
import com.mycompany.jv27_spring_project_final.entities.enums.ActiveStatus;
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
public interface ProductRepository extends PagingAndSortingRepository<ProductEntity, Integer> {

    ProductEntity findById(int id);

    ProductEntity findByCodeLike(String code);

    @Query(value = "select p from ProductEntity p where p.category.id = :categoryID and p.status = :status")
    Page<ProductEntity> findProductByCategoryID(@Param("categoryID") int categoryID, @Param("status") ActiveStatus status, Pageable pageable);

    @Query(value = "select p from ProductEntity p where p.name like %:searchText% or p.description like %:searchText% or p.code = :searchText or p.brand like %:searchText%")
    Page<ProductEntity> findProductByAny(@Param("searchText") String searchText, Pageable pageable);

    @Query(value = "select p from ProductEntity p where (p.name like %:searchText% or p.description like %:searchText% or p.code = :searchText or p.brand like %:searchText%) and status = :status")
    Page<ProductEntity> findProductByAnyActive(@Param("searchText") String searchText, @Param("status") ActiveStatus status, Pageable pageable);

    @Query(value = "select p from ProductEntity p where p.status = :status")
    List<ProductEntity> findAllActiveProduct(@Param("status") ActiveStatus status);

    @Query(value = "select p from ProductEntity p where p.status = :status")
    Page<ProductEntity> findAllActiveProductPageable(@Param("status") ActiveStatus status, Pageable pageable);

    @Query(value = "select * from product join product_promotion_relation on product.id = product_promotion_relation.product_id where product_promotion_relation.promotion_id = ?1", nativeQuery = true)
    List<ProductEntity> findAllProductByPromotionId(int id);
}
