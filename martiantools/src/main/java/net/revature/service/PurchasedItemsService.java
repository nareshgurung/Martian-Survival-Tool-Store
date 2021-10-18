package net.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NoArgsConstructor;
import net.revature.daos.PurchasedItemsRepository;
import net.revature.models.Purchased_items;



@NoArgsConstructor
@Service("piService")
public class PurchasedItemsService {
	private PurchasedItemsRepository piReop;
	
	@Autowired
	public PurchasedItemsService(PurchasedItemsRepository piReop) {
		super();
		this.piReop = piReop;
	}


	public List<Purchased_items> getItemsUsingGroupID(int groupID) {
		return this.piReop.getItemsUsingGroupID(groupID);
	}
	
}
