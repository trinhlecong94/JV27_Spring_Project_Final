/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jv27_spring_project_final.entities;

import com.mycompany.jv27_spring_project_final.Ultil.NumberUltil;
import com.mycompany.jv27_spring_project_final.Ultil.StringUltil;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author taing
 */
@Entity
@Table(name = "order_detail")
public class OrderDetailEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "size_id",nullable = false)
    private SizeEntity size;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id",nullable = false)
    private ProductEntity product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id",nullable = false)
    private OrderEntity order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "promotion_id")
    private PromotionEntity promotion;

    public OrderDetailEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public SizeEntity getSize() {
        return size;
    }

    public void setSize(SizeEntity size) {
        this.size = size;
    }

    public PromotionEntity getPromotion() {
        return promotion;
    }

    public void setPromotion(PromotionEntity promotion) {
        this.promotion = promotion;
    }

    public double getTotal() {
        if (promotion != null && promotion.getDiscount() > 0) {
            return NumberUltil.roundDoubleMoney(this.product.getPrice() * this.quantity * (100 - this.promotion.getDiscount()) / 100, 2);
        }
        return NumberUltil.roundDoubleMoney(this.product.getPrice() * this.quantity, 2);
    }

    public double getTotalDiscount() {
        if (promotion != null && promotion.getDiscount() > 0) {
            return NumberUltil.roundDoubleMoney(this.product.getPrice() * this.quantity * this.promotion.getDiscount() / 100, 2);
        }
        return 0;
    }
}
