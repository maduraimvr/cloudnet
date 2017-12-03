package com.portal.cloudnet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.cloudnet.dao.InventoryDao;
import com.portal.cloudnet.domain.Item;

@Service
public class InventoryService {
	@Autowired
	private InventoryDao inventoryDao;

	public void addItem(Item board) {
		inventoryDao.save(board);
	}
	

	public void removeItem(int itemId){
		Item item = inventoryDao.get(itemId);
		inventoryDao.remove(item);
	}
	
	
    public List<Item> getAllItems(){
        return inventoryDao.loadAll();
    }	
	

	public void updateItem(Item board){
		inventoryDao.update(board);
	}
	
}
