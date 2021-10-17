package net.revature.models;

import lombok.Data;

@Data
public class GroupContentsAsProducts {
	private String product_name;
	private int product_id;
	private int group_contents_amount;
	@Override
	public String toString() {
		return "GroupContentsAsProducts [product_name=" + product_name + ", product_id=" + product_id
				+ ", group_contents_amount=" + group_contents_amount + "]";
	}
	public GroupContentsAsProducts(String product_name, int product_id, int group_contents_amount) {
		super();
		this.product_name = product_name;
		this.product_id = product_id;
		this.group_contents_amount = group_contents_amount;
	}
}
