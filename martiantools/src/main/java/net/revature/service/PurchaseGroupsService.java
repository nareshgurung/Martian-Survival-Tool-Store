package net.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NoArgsConstructor;
import net.revature.daos.PurchaseGroupsRepository;
import net.revature.models.Purchase_group;


@NoArgsConstructor
@Service("pgService")
public class PurchaseGroupsService {
	private PurchaseGroupsRepository pgRepo;

	@Autowired
	public PurchaseGroupsService(PurchaseGroupsRepository pgRepo) {
		super();
		this.pgRepo = pgRepo;
	}

	public List<Purchase_group> getUsersGroups(int userID) {
		return this.pgRepo.getUsersGroups(userID);
	}

}
