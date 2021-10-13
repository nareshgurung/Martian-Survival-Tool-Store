package net.revature.models;

import lombok.Data;

@Data
public class GroupContentsAsProducts {
	private String product_name;
	private int group_contents_amount;
	@Override
	public String toString() {
		return "GroupContentsAsProducts [product_name=" + product_name + ", group_contents_amount="
				+ group_contents_amount + "]";
	}
	public GroupContentsAsProducts(String product_name, int group_contents_amount) {
		super();
		this.product_name = product_name;
		this.group_contents_amount = group_contents_amount;
	}
}
