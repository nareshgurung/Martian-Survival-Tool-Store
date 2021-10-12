package net.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

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

	@Override
	public String toString() {
		return "Comments [comment_id=" + comment_id + ", product_id=" + product_id + ", user_id=" + user_id + ", comment=" + comment + "]";
	}
}
