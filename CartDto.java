package jp.co.internous.cepheus.model.domain.dto;

import java.sql.Timestamp;

public class CartDto {
/** tbl_cart .id */
	private int id;
	
/**  mst_product.image_full_path */
	private String imageFullPath;

/** mst_product.product_name */
	private String productName;
	
/** mst_product.price */
	private int price;
	
/** tbl_cart.product_count */
	private  int productCount;
	
	/** product_countとproduct.priceの合計 */
	private int subtotal;
	
	/** tbl_cart .created_At*/
	private Timestamp createdAt;
	/** tbl_cart .update_At */
	private Timestamp updateAt;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getImageFullPath() {
		return imageFullPath;
	}

	public void setImageFullpath(String imageFullPath) {
		this.imageFullPath = imageFullPath;
	}

	public  String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	
	public int getSubtotal() {
		return subtotal;
	}
	
	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}
	
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	
	public Timestamp getUpdateAt() {
		return updateAt;
	}
	
	public void setUpdateAt(Timestamp updateAt) {
		this.updateAt = updateAt;
	}
}




