package net.revature.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="comments")
public class Comments {
	
	@Id
	@Column(name="comment_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int comment_id;
	
	@Column(name="product_id", nullable=false)
	private int product_id;
	
	@Column(name="user_id", nullable=false)
	private int user_id;
	
	@Column(name="comment")
	private String comment;
	
	public Comments() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Comments(int comment_id, int product_id, int user_id, String comment) {
		super();
		this.comment_id = comment_id;
		this.product_id = product_id;
		this.user_id = user_id;
		this.comment = comment;
	}
	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public int hashCode() {
		return Objects.hash(comment, comment_id, product_id, user_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comments other = (Comments) obj;
		return Objects.equals(comment, other.comment) && comment_id == other.comment_id
				&& product_id == other.product_id && user_id == other.user_id;
	}
	@Override
	public String toString() {
		return "Comments [comment_id=" + comment_id + ", product_id=" + product_id + ", user_id=" + user_id
				+ ", comment=" + comment + "]";
	}
	
	
}
