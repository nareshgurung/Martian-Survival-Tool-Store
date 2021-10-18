package net.revature.models;

import java.util.Arrays;

import lombok.Data;

@Data
public class SillyModelsAreSillyButTheyWork {
	private int userID;
	private PaymentAndAddress frm;
	private Products[] items;
	@Override
	public String toString() {
		return "SillyModelsAreSillyButTheyWork [userID=" + userID + ", frm=" + frm + ", items=" + Arrays.toString(items)
				+ "]";
	}
}
