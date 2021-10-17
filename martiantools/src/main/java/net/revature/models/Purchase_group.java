package net.revature.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="purchase_group")
public class Purchase_group {
	@Id
	@Column private int purchase_group_id;
	@Column private int user_id;
	@Column private Timestamp purchase_group_date;
	@Override
	public String toString() {
		return "Purchase_group [purchase_group_id=" + purchase_group_id + ", user_id=" + user_id
				+ ", purchase_group_date=" + purchase_group_date + "]";
	}
}
