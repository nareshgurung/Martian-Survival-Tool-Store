package net.revature.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="qa")
public class Qa {
	
	@Id
	@Column(name="qa_id")
	private int qa_id;
	
	@Column(name="qa_question", nullable=false)
	private String qa_question;
	
	@Column(name="qa_answer")
	private String qa_answer;
	
	@Column(name="product_id", nullable=false)
	private int product_id;
	
	@Column(name="user_id", nullable=false)
	private int user_id;
	public Qa() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Qa(int qa_id, String qa_question, String qa_answer, int product_id, int user_id) {
		super();
		this.qa_id = qa_id;
		this.qa_question = qa_question;
		this.qa_answer = qa_answer;
		this.product_id = product_id;
		this.user_id = user_id;
	}
	public int getQa_id() {
		return qa_id;
	}
	public void setQa_id(int qa_id) {
		this.qa_id = qa_id;
	}
	public String getQa_question() {
		return qa_question;
	}
	public void setQa_question(String qa_question) {
		this.qa_question = qa_question;
	}
	public String getQa_answer() {
		return qa_answer;
	}
	public void setQa_answer(String qa_answer) {
		this.qa_answer = qa_answer;
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
	@Override
	public int hashCode() {
		return Objects.hash(product_id, qa_answer, qa_id, qa_question, user_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Qa other = (Qa) obj;
		return product_id == other.product_id && Objects.equals(qa_answer, other.qa_answer) && qa_id == other.qa_id
				&& Objects.equals(qa_question, other.qa_question) && user_id == other.user_id;
	}
	@Override
	public String toString() {
		return "Qa [qa_id=" + qa_id + ", qa_question=" + qa_question + ", qa_answer=" + qa_answer + ", product_id="
				+ product_id + ", user_id=" + user_id + "]";
	}
	
}
