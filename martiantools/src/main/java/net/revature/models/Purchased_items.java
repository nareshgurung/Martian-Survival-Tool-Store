package net.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="purchased_items")
public class Purchased_items {
	@Id
	@Column	private int purchased_items_id;
	@Column private int purchase_group_id;
	@Column private int product_id;
	@Column private int amount;
	@Override
	public String toString() {
		return "Purchased_items [purchased_items_id=" + purchased_items_id + ", purchase_group_id=" + purchase_group_id
				+ ", product_id=" + product_id + ", amount=" + amount + "]";
	}

}
