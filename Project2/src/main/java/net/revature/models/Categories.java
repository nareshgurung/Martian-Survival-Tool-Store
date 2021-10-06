package net.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class Categories {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="category_id")
	private int category_id;
	
	@Column(name="category_name")
	private String category_name;
	
	public Categories() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Categories(int category_id, String category_name) {
		super();
		this.category_id = category_id;
		this.category_name = category_name;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + category_id;
		result = prime * result + ((category_name == null) ? 0 : category_name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categories other = (Categories) obj;
		if (category_id != other.category_id)
			return false;
		if (category_name == null) {
			if (other.category_name != null)
				return false;
		} else if (!category_name.equals(other.category_name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Categories [category_id=" + category_id + ", category_name=" + category_name + "]";
	}
	
	
}
