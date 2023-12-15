package org.example;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long product_id;

    @Column(name = "product_name", nullable = false)
    private String product_name;

    @Column(name = "product_size", nullable = false)
    private String product_size;
    @Column(name = "product_price", nullable = false)
    private Double product_price;


    @ManyToOne
    @JoinColumn(name = "orders_id", nullable = false)
    private Orders orders;

    public Product(){
    }

    public Product(String product_name, String product_size, Double product_price, Orders orders) {
        this.product_name = product_name;
        this.product_size = product_size;
        this.orders = orders;
        this.product_price = product_price;
    }

    @Override
    public String toString() {
        return "Товар(" + product_id + ", " + product_name + ", " + product_size + ")";
    }

    public Long getProductId() {
        return product_id;
    }

    public String getProductName() {
        return product_name;
    }

    public String getProductSize() {
        return product_size;
    }
    public Double getProductPrice() {
        return product_price;
    }

    public void setProductId(Long product_id) {
        this.product_id = product_id;
    }

    public void setProductName(String product_name) {
        this.product_name = product_name;
    }

    public void setProductSize(String product_size) {
        this.product_size = product_size;
    }
    public void setProductPrice(Double product_price) {
        this.product_price = product_price;
    }

    public Orders getOrders() {
        return orders;
    }

}
