package jp.co.internous.rainbow.model.form;

import java.io.Serializable;

/**
 * 各種変数を定義
 * 画面上に表示するデータをここに記述します。
 * ユーザーID,商品ID,個数,を定義
 */
public class CartForm implements Serializable{
	private static final long serialVersionUID = 1L;

	private int userId;
	private int productId;
	private int productCount;

	/*
	 * ユーザーIDのgetter/setter
	 */	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/*
	 * 商品IDのgetter/setter
	 */
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}

	/*
	 * 個数のgetter/setter
	 */
	public int getProductCount() {
		return productCount;
	}	
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
}