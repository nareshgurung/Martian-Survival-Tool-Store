package net.revature.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="groups")
public class Groups {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="group_id")
	private int group_id;
	
	@Column(name="group_name", nullable=false)
	private String group_name;
	
	@Column(name="user_id")
	private int user_id;
	public Groups() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Groups(int group_id, String group_name, int user_id) {
		super();
		this.group_id = group_id;
		this.group_name = group_name;
		this.user_id = user_id;
	}
	public int getGroup_id() {
		return group_id;
	}
	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	@Override
	public int hashCode() {
		return Objects.hash(group_id, group_name, user_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Groups other = (Groups) obj;
		return group_id == other.group_id && Objects.equals(group_name, other.group_name) && user_id == other.user_id;
	}
	@Override
	public String toString() {
		return "Groups [group_id=" + group_id + ", group_name=" + group_name + ", user_id=" + user_id + "]";
	}
}
