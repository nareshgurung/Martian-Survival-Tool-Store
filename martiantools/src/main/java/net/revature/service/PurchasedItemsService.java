package net.revature.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NoArgsConstructor;
import net.revature.daos.PurchasedItemsRepository;
import net.revature.models.Products;
import net.revature.models.Purchased_items;



@NoArgsConstructor
@Service("piService")
public class PurchasedItemsService {
	private PurchasedItemsRepository piReop;
	private ProductRepository pRepo;

	@Autowired
	public PurchasedItemsService(PurchasedItemsRepository piReop, ProductRepository pRepo) {
		super();
		this.piReop = piReop;
		this.pRepo = pRepo;
	}

	public List<Purchased_items> getItemsUsingGroupID(int groupID) {
		return this.piReop.getItemsUsingGroupID(groupID);
	}


	public List<Products> getItemMostBought() {
		List<Object[]> prodID = this.piReop.getItemMostBought();
		ArrayList<Products> prodList = new ArrayList<Products>();
		long max = -999;
		long mid = -999;
		long min = -999;
		int maxID = -9;
		int midID = -9;
		int minID = -9;
		for(int i=0; i<prodID.size();i++) {
			long temp;

			temp = (long)prodID.get(i)[1];
			if(temp>min) {
				if(temp>mid) {
					if(temp>max) {
						min=mid;
						mid=max;
						max=temp;
						minID = midID;
						midID = maxID;
						maxID = (int)prodID.get(i)[0];
					} else {
						min = mid;
						mid=temp;
						minID = midID;
						midID = (int)prodID.get(i)[0]; 
					}
				} else {
					min=temp;
					minID = (int)prodID.get(i)[0];
				}
			}
		}
		prodList.add(this.pRepo.getByProductID(maxID));
		prodList.add(this.pRepo.getByProductID(midID));
		prodList.add(this.pRepo.getByProductID(minID));
		return prodList;
	}

}
