package jp.co.internous.rainbow.model.domain.dto;

import java.sql.Timestamp;

/**
 * 画面に表示する製品データを格納する為のクラス
 * カート情報テーブルのみでは価格と画像、商品名が習得不可能です
 * その為JOINしたデータベーステーブルから取ってきたデータを格納するスペースを作成
 */
public class CartDto {
	/*
	 * 画面に表示するデータの変数をここで定義しています。
	 * 機能設計書のp10を参考にデータを用意
	 */
	private int id;
	private String imageFullPath;
	private String productName;
	private int price;
	private int productCount;
	private int subtotal;
	private Timestamp createdAt;
	private Timestamp updatedAt;

	/*
	 * ID
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	/*
	 * 商品画像
	 */
	public String getImageFullPath() {
		return imageFullPath;
	}
	public void setImageFullPath(String imageFullPath) {
		this.imageFullPath = imageFullPath;
	}

	/*
	 * 商品名
	 */
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/*
	 * 値段
	 */
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	/*
	 * 個数
	 */
	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	/*
	 * 合計金額
	 */
	public int getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}

	/*
	 * 登録日時
	 */
	public Timestamp getCreatedAtl() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	/*
	 * 更新日時
	 */
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
}
