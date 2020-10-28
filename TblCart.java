
package jp.co.internous.cepheus.model.domain;

import java.sql.Timestamp;

import jp.co.internous.cepheus.model.form.CartForm;

public class TblCart{
	private int id;
	
	private int userId;
	
	private int productId;
	
	private int productCount;
	
	private Timestamp createdAt;
	
	private Timestamp updateAt;
	
	// 初期設定せず後でsetterをセット？ //
	public TblCart() {}

	// CartFormから受け取り、データセット //
	public TblCart(CartForm f) {
		userId = f.getUserId();
		productId = f.getProductId();
		productCount = f.getProductCount();
	}
	
	public int getId() {
		return id;
	}

	public void setId (int id) {
		this.id = id;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProductId() {
		return productId;
	}
	
	public void setProductId(int productId ) {
		this.productId = productId;
	}
	
	public int getProductCount() {
		return productCount;
	}
	
	public void setProductCount(int productCount) {
		this.productCount = productCount;
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


