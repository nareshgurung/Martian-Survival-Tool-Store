package net.revature.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="group_contents")
public class GroupContents {
	
	@Column(name="group_id")
	private int group_id;
	
	@Column(name="product_id")
	private int product_id;
	public GroupContents() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GroupContents(int group_id, int product_id) {
		super();
		this.group_id = group_id;
		this.product_id = product_id;
	}
	public int getGroup_id() {
		return group_id;
	}
	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	@Override
	public int hashCode() {
		return Objects.hash(group_id, product_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GroupContents other = (GroupContents) obj;
		return group_id == other.group_id && product_id == other.product_id;
	}
	@Override
	public String toString() {
		return "GroupContents [group_id=" + group_id + ", product_id=" + product_id + "]";
	}
	
}
