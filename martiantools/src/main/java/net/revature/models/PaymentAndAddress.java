package net.revature.models;

import lombok.Data;

@Data
public class PaymentAndAddress {
	private String email;
	private String name;
	private String address;
	private int zip;
	private String city;
	private String state;
	private int cardNumber;
	private String expDate;
	private int secCode;
	@Override
	public String toString() {
		return "PaymentAndAddress [email=" + email + ", name=" + name + ", address=" + address + ", zip=" + zip
				+ ", city=" + city + ", state=" + state + ", cardNumber=" + cardNumber + ", expDate=" + expDate
				+ ", secCode=" + secCode + "]";
	}

}
