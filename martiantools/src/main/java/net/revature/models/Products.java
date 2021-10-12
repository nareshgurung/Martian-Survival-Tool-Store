package net.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="products")
public class Products {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	private int product_id;
	
	@Column(name="product_name", nullable=false)
	private String product_name;
	
	@Column(name="product_price", nullable=false)
	private double product_price;
	
	@Column(name="product_quantity")
	private int product_quantity;
	
	@Column(name="product_url")
	private String product_url;
	
	@Column(name="user_id")
	private int user_id;
	
	@Column(name="category_id")
	private int category_id;

	@Override
	public String toString() {
		return "Products [product_id=" + product_id + ", product_name=" + product_name + ", product_price="
				+ product_price + ", product_quantity=" + product_quantity + ", product_url=" + product_url
				+ ", user_id=" + user_id + ", category_id=" + category_id + "]";
	}
	

	
}
