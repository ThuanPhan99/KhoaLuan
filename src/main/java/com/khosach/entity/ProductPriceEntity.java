package com.khosach.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "productprice")
public class ProductPriceEntity implements Serializable {

    private static final long serialVersionUID = -6390556776842383372L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productpriceid")
    private Long productPriceId;

    @Column(name = "price")
    private Long price;

    @Column(name = "saleoff")
    private Long saleOff;

    @Column(name = "description")
    private String description;

    @OneToOne
    @JoinColumn(name = "productid")
    private ProductEntity product;

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public Long getProductPriceId() {
        return productPriceId;
    }

    public void setProductPriceId(Long productPriceId) {
        this.productPriceId = productPriceId;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getSaleOff() {
        return saleOff;
    }

    public void setSaleOff(Long saleOff) {
        this.saleOff = saleOff;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
