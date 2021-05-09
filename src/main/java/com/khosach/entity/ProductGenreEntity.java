package com.khosach.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "productgenre")
public class ProductGenreEntity implements Serializable {

    private static final long serialVersionUID = 7222091691600198813L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productgenreid")
    private Long productGenreId;

    @Column(name="productgenre")
    private String productGenre;

    @Column(name="isactive")
    private Integer isActive;

    public Long getProductGenreId() {
        return productGenreId;
    }

    public void setProductGenreId(Long productGenreId) {
        this.productGenreId = productGenreId;
    }

    public String getProductGenre() {
        return productGenre;
    }

    public void setProductGenre(String productGenre) {
        this.productGenre = productGenre;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }
}
