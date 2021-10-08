package net.revature.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users {
	
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	
	@Column(name ="user_role", nullable=false)
	private int user_role;
	
	@Column(name="user_email", nullable=false, unique=true)
	private String user_email;
	
	@Column(name = "user_fname", nullable=false)
	private String user_fname;
	
	@Column(name="user_midinnitial")
	private String user_midinnitial;
	
	@Column(name="user_lname")
	private String user_lname;
	
	@Column(name="user_street")
	private String user_street;
	
	@Column(name="user_zip")
	private	Integer user_zip;
	
	@Column(name="user_city")
	private String user_city;
	
	@Column(name="user_state")
	private String user_state;
	
	@Column(name="user_username", nullable=false, unique=true)
	private String user_username;
	
	@Column(name="user_password", nullable=false)
	private String user_password;
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(int user_id, int user_role, String user_email, String user_fname, String user_midinnitial,
			String user_lname, String user_street, Integer user_zip, String user_city, String user_state,
			String user_username, String user_password) {
		super();
		this.user_id = user_id;
		this.user_role = user_role;
		this.user_email = user_email;
		this.user_fname = user_fname;
		this.user_midinnitial = user_midinnitial;
		this.user_lname = user_lname;
		this.user_street = user_street;
		this.user_zip = user_zip;
		this.user_city = user_city;
		this.user_state = user_state;
		this.user_username = user_username;
		this.user_password = user_password;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getUser_role() {
		return user_role;
	}
	public void setUser_role(int user_role) {
		this.user_role = user_role;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_fname() {
		return user_fname;
	}
	public void setUser_fname(String user_fname) {
		this.user_fname = user_fname;
	}
	public String getUser_midinnitial() {
		return user_midinnitial;
	}
	public void setUser_midinnitial(String user_midinnitial) {
		this.user_midinnitial = user_midinnitial;
	}
	public String getUser_lname() {
		return user_lname;
	}
	public void setUser_lname(String user_lname) {
		this.user_lname = user_lname;
	}
	public String getUser_street() {
		return user_street;
	}
	public void setUser_street(String user_street) {
		this.user_street = user_street;
	}
	public Integer getUser_zip() {
		return user_zip;
	}
	public void setUser_zip(Integer user_zip) {
		this.user_zip = user_zip;
	}
	public String getUser_city() {
		return user_city;
	}
	public void setUser_city(String user_city) {
		this.user_city = user_city;
	}
	public String getUser_state() {
		return user_state;
	}
	public void setUser_state(String user_state) {
		this.user_state = user_state;
	}
	public String getUser_username() {
		return user_username;
	}
	public void setUser_username(String user_username) {
		this.user_username = user_username;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	@Override
	public int hashCode() {
		return Objects.hash(user_city, user_email, user_fname, user_id, user_lname, user_midinnitial, user_password,
				user_role, user_state, user_street, user_username, user_zip);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		return Objects.equals(user_city, other.user_city) && Objects.equals(user_email, other.user_email)
				&& Objects.equals(user_fname, other.user_fname) && user_id == other.user_id
				&& Objects.equals(user_lname, other.user_lname)
				&& Objects.equals(user_midinnitial, other.user_midinnitial)
				&& Objects.equals(user_password, other.user_password) && Objects.equals(user_role, other.user_role)
				&& Objects.equals(user_state, other.user_state) && Objects.equals(user_street, other.user_street)
				&& Objects.equals(user_username, other.user_username) && Objects.equals(user_zip, other.user_zip);
	}
	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", user_role=" + user_role + ", user_email=" + user_email + ", user_fname="
				+ user_fname + ", user_midinnitial=" + user_midinnitial + ", user_lname=" + user_lname
				+ ", user_street=" + user_street + ", user_zip=" + user_zip + ", user_city=" + user_city
				+ ", user_state=" + user_state + ", user_username=" + user_username + ", user_password=" + user_password
				+ "]";
	}
	
  
}
