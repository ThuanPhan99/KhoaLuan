/*
 * @author THUAN-PHAN
 * @date May 15, 2020
 * @version 1.0
 */

package com.khosach.dto;

import com.khosach.entity.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class ProductDTO {
	private Long productID;
	private String productName;
	private Long quantity;
	private Long price;
	private Long priceAdd;
	private Long salePrice;
	private String author;
	private String publisher;
	private Integer yearOfPublication;
	private String thumbnail;
	private String description;
	private Date dateAdded;
	private Integer numberOfPages;
	private Integer status;
	private Integer delete;
	private Long groupProductID;
	private String groupProductName;
	private String base64;
	private Long authorId;
	private Long publisherId;
	private String genreDes;
	private Long genreId;
	private Long numOfProductSell;

	public Long getNumOfProductSell() {
		return numOfProductSell;
	}

	public void setNumOfProductSell(Long numOfProductSell) {
		this.numOfProductSell = numOfProductSell;
	}

	public String getGenreDes() {
		return genreDes;
	}

	public void setGenreDes(String genreDes) {
		this.genreDes = genreDes;
	}

	public Long getGenreId() {
		return genreId;
	}

	public void setGenreId(Long genreId) {
		this.genreId = genreId;
	}

	public String getBase64() {
		return base64;
	}

	public void setBase64(String base64) {
		this.base64 = base64;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public Long getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(Long publisherId) {
		this.publisherId = publisherId;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public Long getGroupProductID() {
		return groupProductID;
	}

	public void setGroupProductID(Long groupProductID) {
		this.groupProductID = groupProductID;
	}

	public String getGroupProductName() {
		return groupProductName;
	}

	public void setGroupProductName(String groupProductName) {
		this.groupProductName = groupProductName;
	}

	public Long getProductID() {
		return productID;
	}

	public void setProductID(Long productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Long salePrice) {
		this.salePrice = salePrice;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Integer getYearOfPublication() {
		return yearOfPublication;
	}

	public void setYearOfPublication(Integer yearOfPublication) {
		this.yearOfPublication = yearOfPublication;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(Integer numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getDelete() {
		return delete;
	}

	public Long getPriceAdd() {
		return priceAdd;
	}

	public void setPriceAdd(Long priceAdd) {
		this.priceAdd = priceAdd;
	}

	public void setDelete(Integer delete) {
		this.delete = delete;
	}

	public static ProductDTO toProductDTO(ProductEntity productEntity) {
		if ( productEntity == null ) {
			return null;
		}

		ProductDTO productDTO = new ProductDTO();

		productDTO.setGroupProductName(Objects.nonNull(productEntity.getGroupProductEntity()) ? productEntity.getGroupProductEntity().getGroupProductName() : StringUtils.EMPTY);
		if(Objects.nonNull(productEntity.getProductPrice())){
			productDTO.setSalePrice(productEntity.getProductPrice().getSaleOff());
			productDTO.setPrice(productEntity.getProductPrice().getPrice());
		} else {
			productDTO.setSalePrice(0L);
			productDTO.setPrice(0L);
		}

		productDTO.setGroupProductID(Objects.nonNull(productEntity.getGroupProductEntity())? productEntity.getGroupProductEntity().getGroupProductID() : 0l);
		productDTO.setPublisher(Objects.nonNull(productEntity.getPublishersEntity()) ? productEntity.getPublishersEntity().getName() : StringUtils.EMPTY);
        productDTO.setPublisherId(Objects.nonNull(productEntity.getPublishersEntity()) ? productEntity.getPublishersEntity().getPublisherId() : 0L);
        productDTO.setDelete( productEntity.getIsDelete() );
		productDTO.setDateAdded( Objects.nonNull(productEntity.getProductAddEntity()) ? productEntity.getProductAddEntity().getDateAdd() : null );
		productDTO.setProductID( productEntity.getProductID() );
		productDTO.setProductName( productEntity.getProductName() );
		productDTO.setQuantity( productEntity.getQuantity());
		productDTO.setNumOfProductSell(productEntity.getNumOfOrder());

		productDTO.setGenreDes(Objects.nonNull(productEntity.getProductGenreEntity()) ? productEntity.getProductGenreEntity().getProductGenre() : StringUtils.EMPTY);
		productDTO.setGenreId(Objects.nonNull(productEntity.getProductGenreEntity()) ? productEntity.getProductGenreEntity().getProductGenreId() : 0L);

		if(!CollectionUtils.isEmpty(productEntity.getProductAuthorEntities())){
			String authors = StringUtils.EMPTY;
			for (int i = 0; i < productEntity.getProductAuthorEntities().size() ; i++) {
				ProductAuthorEntity productPriceEntity = productEntity.getProductAuthorEntities().get(i);
				if(i != 0){
					authors = authors.concat(", ");
				}
				if(StringUtils.isNotEmpty(productPriceEntity.getAuthorsEntity().getFirstName())){
					authors = authors.concat(productPriceEntity.getAuthorsEntity().getFirstName());
				}
				if(StringUtils.isNotEmpty(productPriceEntity.getAuthorsEntity().getLastName())){
					authors = authors.concat(" ").concat(productPriceEntity.getAuthorsEntity().getLastName());
				}
			}
            productDTO.setAuthorId(productEntity.getProductAuthorEntities().get(0).getAuthorsEntity().getAuthorId());
            productDTO.setAuthor(authors);

		} else {
			productDTO.setAuthor(StringUtils.EMPTY);
		}
		productDTO.setYearOfPublication( productEntity.getYearOfPublication() );
		productDTO.setThumbnail( productEntity.getThumbnail() );
		productDTO.setDescription( productEntity.getDescription() );
		productDTO.setNumberOfPages( productEntity.getNumberOfPages() );
		productDTO.setStatus( productEntity.getStatus() );

		return productDTO;
	}

	public static List<ProductDTO> toListProductDTO(List<ProductEntity> listProductEntity) {
		if ( listProductEntity == null ) {
			return null;
		}

		List<ProductDTO> list = new ArrayList<ProductDTO>( listProductEntity.size() );
		for ( ProductEntity productEntity : listProductEntity ) {
			list.add( toProductDTO( productEntity ) );
		}

		return list;
	}

	public static ProductEntity toProductEntity(ProductDTO productDTO) {
		if ( productDTO == null ) {
			return null;
		}

		ProductEntity productEntity = new ProductEntity();

		productEntity.setGroupProductEntity( productDTOToGroupProductEntity( productDTO ) );
		productEntity.setIsDelete( productDTO.getDelete() );
		productEntity.setProductID( productDTO.getProductID() );
		productEntity.setProductName( productDTO.getProductName() );
		productEntity.setYearOfPublication( productDTO.getYearOfPublication() );
		productEntity.setThumbnail( productDTO.getThumbnail() );
		productEntity.setDescription( productDTO.getDescription() );
		productEntity.setNumberOfPages( productDTO.getNumberOfPages() );
		productEntity.setStatus( productDTO.getStatus() );

		return productEntity;
	}

	public List<ProductEntity> toListProductEntity(List<ProductDTO> listProductDTO) {
		if ( listProductDTO == null ) {
			return null;
		}

		List<ProductEntity> list = new ArrayList<ProductEntity>( listProductDTO.size() );
		for ( ProductDTO productDTO : listProductDTO ) {
			list.add( toProductEntity( productDTO ) );
		}

		return list;
	}

	private static String productEntityGroupProductEntityGroupProductName(ProductEntity productEntity) {
		if ( productEntity == null ) {
			return null;
		}
		GroupProductEntity groupProductEntity = productEntity.getGroupProductEntity();
		if ( groupProductEntity == null ) {
			return null;
		}
		String groupProductName = groupProductEntity.getGroupProductName();
		if ( groupProductName == null ) {
			return null;
		}
		return groupProductName;
	}

	private static Long productEntityProductPriceSaleOff(ProductEntity productEntity) {
		if ( productEntity == null ) {
			return null;
		}
		ProductPriceEntity productPrice = productEntity.getProductPrice();
		if ( productPrice == null ) {
			return null;
		}
		Long saleOff = productPrice.getSaleOff();
		if ( saleOff == null ) {
			return null;
		}
		return saleOff;
	}

	private static Long productEntityProductPricePrice(ProductEntity productEntity) {
		if ( productEntity == null ) {
			return null;
		}
		ProductPriceEntity productPrice = productEntity.getProductPrice();
		if ( productPrice == null ) {
			return null;
		}
		Long price = productPrice.getPrice();
		if ( price == null ) {
			return null;
		}
		return price;
	}

	private static Long productEntityGroupProductEntityGroupProductID(ProductEntity productEntity) {
		if ( productEntity == null ) {
			return null;
		}
		GroupProductEntity groupProductEntity = productEntity.getGroupProductEntity();
		if ( groupProductEntity == null ) {
			return null;
		}
		Long groupProductID = groupProductEntity.getGroupProductID();
		if ( groupProductID == null ) {
			return null;
		}
		return groupProductID;
	}

	private static String productEntityPublishersEntityName(ProductEntity productEntity) {
		if ( productEntity == null ) {
			return null;
		}
		PublishersEntity publishersEntity = productEntity.getPublishersEntity();
		if ( publishersEntity == null ) {
			return null;
		}
		String name = publishersEntity.getName();
		if ( name == null ) {
			return null;
		}
		return name;
	}

	protected static GroupProductEntity productDTOToGroupProductEntity(ProductDTO productDTO) {
		if ( productDTO == null ) {
			return null;
		}

		GroupProductEntity groupProductEntity = new GroupProductEntity();

		groupProductEntity.setGroupProductName( productDTO.getGroupProductName() );
		groupProductEntity.setGroupProductID( productDTO.getGroupProductID() );

		return groupProductEntity;
	}
}
