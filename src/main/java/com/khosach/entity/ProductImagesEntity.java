package com.khosach.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "productimages")
public class ProductImagesEntity implements Serializable {

    private static final long serialVersionUID = 267640657298899094L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "imageid")
    private Long imageId;

    @Column(name = "productid")
    private Long productID;

    @Column(name = "imagepath")
    private String imagePath;

    @Column(name = "imagetitle")
    private String imageTitle;

    @Column(name="isactive")
    private Integer isActive;

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImageTitle() {
        return imageTitle;
    }

    public void setImageTitle(String imageTitle) {
        this.imageTitle = imageTitle;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }
}
