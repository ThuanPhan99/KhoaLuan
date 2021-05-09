package com.khosach.entity;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "productauthor")
public class ProductAuthorEntity implements Serializable {

    private static final long serialVersionUID = -1512900663165265807L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productauthorid")
    private Long productAuthorId;

    @NotFound(action = NotFoundAction.IGNORE)
    @ManyToOne
    @JoinColumn(name = "authorid")
    private AuthorsEntity authorsEntity;

    @ManyToOne
    @JoinColumn(name = "productid")
    private ProductEntity products;

    public AuthorsEntity getAuthorsEntity() {
        return authorsEntity;
    }

    public void setAuthorsEntity(AuthorsEntity authorsEntity) {
        this.authorsEntity = authorsEntity;
    }

    public ProductEntity getProducts() {
        return products;
    }

    public void setProducts(ProductEntity products) {
        this.products = products;
    }

    public Long getProductAuthorId() {
        return productAuthorId;
    }

    public void setProductAuthorId(Long productAuthorId) {
        this.productAuthorId = productAuthorId;
    }

}
