package net.revature.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Products {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int product_id;
	
	@Column(name="product_name")
	private String product_name;
	
	@Column(name="product_price")
	private double product_price;
	
	@Column(name="product_quantity")
	private int product_quantity;
	
	@Column(name="product_url")
	private String product_url;
	
	@Column(name="user_id")
	private int user_id;
	
	@Column(name="category_id")
	private int category_id;
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Products(int product_id, String product_name, double product_price, int product_quantity, String product_url,
			int user_id, int category_id) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_quantity = product_quantity;
		this.product_url = product_url;
		this.user_id = user_id;
		this.category_id = category_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public double getProduct_price() {
		return product_price;
	}
	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}
	public int getProduct_quantity() {
		return product_quantity;
	}
	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}
	public String getProduct_url() {
		return product_url;
	}
	public void setProduct_url(String product_url) {
		this.product_url = product_url;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	@Override
	public int hashCode() {
		return Objects.hash(category_id, product_id, product_name, product_price, product_quantity, product_url,
				user_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Products other = (Products) obj;
		return category_id == other.category_id && product_id == other.product_id
				&& Objects.equals(product_name, other.product_name)
				&& Double.doubleToLongBits(product_price) == Double.doubleToLongBits(other.product_price)
				&& product_quantity == other.product_quantity && Objects.equals(product_url, other.product_url)
				&& user_id == other.user_id;
	}
	@Override
	public String toString() {
		return "Products [product_id=" + product_id + ", product_name=" + product_name + ", product_price="
				+ product_price + ", product_quantity=" + product_quantity + ", product_url=" + product_url
				+ ", user_id=" + user_id + ", category_id=" + category_id + "]";
	}
	
}
