package net.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.revature.daos.ProductRepository;
import net.revature.daos.PurchaseGroupsRepository;
import net.revature.daos.PurchasedItemsRepository;
import net.revature.models.Products;
import net.revature.models.Purchase_group;
import net.revature.models.Purchased_items;
import net.revature.models.SillyModelsAreSillyButTheyWork;

@Service("cartService")
public class CartService {
	private PurchasedItemsRepository piRepo;
	private ProductRepository pReop;
	private PurchaseGroupsRepository pgRepo;
	
	@Autowired
	public CartService(PurchasedItemsRepository piRepo, ProductRepository pReop, PurchaseGroupsRepository pgRepo) {
		super();
		this.piRepo = piRepo;
		this.pReop = pReop;
		this.pgRepo = pgRepo;
	}


	public Boolean addToWeirdosCart(SillyModelsAreSillyButTheyWork sillyObj) {
		//TODO: do something with the address part. probably goes to another table that tracks outward shipments
		// sillyObj.getFrm()
		Products[] products = sillyObj.getItems();
		if(sillyObj.getUserID()<0) {
			sillyObj.setUserID(4);
		}
		Purchase_group pGroup = new Purchase_group();
		pGroup.setUser_id(sillyObj.getUserID());
		this.pgRepo.save(pGroup);
		
		//this is NOT how I would do it except that there is less than 12 hours between now and it being presented
		int top = this.pgRepo.getMostRecentID();

		
		for(Products p : products) {
			Purchased_items pi = new Purchased_items();
			pi.setAmount(1);
			pi.setProduct_id(p.getProduct_id());
			pi.setPurchase_group_id(top);
			this.piRepo.addItemsToPurchasedTable(pi);
			
			
			this.pReop.removeItemAmountFromItem(p, 1);
		}

		return null;
	}

}
