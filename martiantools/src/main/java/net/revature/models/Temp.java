package net.revature.models;

import lombok.Data;

@Data
public class Temp {
private int product_id;
private int amount;
@Override
public String toString() {
	return "Temp [product_id=" + product_id + ", amount=" + amount + "]";
}

}
