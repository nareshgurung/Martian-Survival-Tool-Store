package net.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
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
@Data
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

	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", user_role=" + user_role + ", user_email=" + user_email + ", user_fname="
				+ user_fname + ", user_midinnitial=" + user_midinnitial + ", user_lname=" + user_lname
				+ ", user_street=" + user_street + ", user_zip=" + user_zip + ", user_city=" + user_city
				+ ", user_state=" + user_state + ", user_username=" + user_username + ", user_password=" + user_password
				+ "]";
	}
	

	
  
}
