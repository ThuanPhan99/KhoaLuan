package com.khosach.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "productadd")
public class ProductAddEntity implements Serializable {

    private static final long serialVersionUID = -1285271072336387378L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productaddid")
    private Long productAddId;

    @Column(name = "dateadd")
    private Date dateAdd;

    @Column(name = "price")
    private Long price;

    @Column(name = "quantity")
    private Long quantity;

    @OneToOne
    @JoinColumn(name = "productid")
    private ProductEntity product;

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public Long getProductAddId() {
        return productAddId;
    }

    public void setProductAddId(Long productAddId) {
        this.productAddId = productAddId;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
