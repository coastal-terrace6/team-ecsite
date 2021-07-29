package jp.co.internous.rainbow.model.domain;

import java.sql.Timestamp;

import jp.co.internous.rainbow.model.form.CartForm;

/**
 * カートDBテーブルとマッピングするjavaクラス
 * getterやsetter等を定義
 */
public class TblCart {
	/*
	 * 各種変数を定義
	 * テーブル定義書のp7を参照に作成
	 * ID,ユーザーID,商品ID,個数,登録日時,更新日時を定義
	 */
	private int id;
	private int userId;
	private int productId;
	private int productCount;
	private Timestamp createdAt;
	private Timestamp updatedAt;

	/*
	 * コンストラクタの用意
	 */
	public TblCart() {}

	public TblCart(CartForm f) {
		userId = f.getUserId();
		productId = f.getProductId();
		productCount = f.getProductCount();
	}

	/*
	 * IDのgetter/setter
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	/*
	 * ユーザーIDのgetter/setter
	 */
	public int getUserId() {
		return userId;
	}
	public void set(int userId) {
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

	/*
	 * 登録日時のgetter/setter
	 */
	public Timestamp getCreatedAt() {
		return createdAt;
	}	
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	/*
	 * 更新日時のgetter/setter
	 */
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
}