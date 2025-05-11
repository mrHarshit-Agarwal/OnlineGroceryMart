package com.jsp.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.Dto.Grocery;

@Repository
public class GroceryDao {

	@Autowired
	EntityManager manager;

	@Autowired
	EntityTransaction transaction;

	// to insert objects into DB

	public String insertGrocery(Grocery grocery) {
		transaction.begin();
		manager.persist(grocery);
		transaction.commit();
		return "Grocery inventry details are stored successfully...";

	}

	// to search object based on ID
	public Grocery getGroceryById(int id) {
		Grocery emp = manager.find(Grocery.class, id);
		return emp;
	}

	// to delete an object from DB based on ID
	public int deleteGrocery(int id) {
		Grocery emp = manager.find(Grocery.class, id);
		if (emp != null) {
			transaction.begin();
			manager.remove(emp);
			transaction.commit();
			return 1;
		} else {
			return 0;
		}
	}

	// to update
	public int updateGrocery(int id, String name, String category, double price, int stockQuantity) {
		Grocery grocery = manager.find(Grocery.class, id);
		if (grocery != null) {
			grocery.setName(name);
			grocery.setPrice(price);
			grocery.setCategory(category);
			grocery.setStockQuantity(stockQuantity);
			transaction.begin();
			manager.merge(grocery);
			transaction.commit();
			return 1;
		}
		return 0;
	}

	// to fatch details
	public List<Grocery> getAllGroceries() {
		Query q = manager.createQuery("SELECT g FROM Grocery g");
		List<Grocery> list = q.getResultList();
		return list;
	}

	public Grocery purchaseGrocery(int id, int stockQuantity) {
		List<Grocery> list = getAllGroceries();
		for (Grocery g : list) {
			if (g.getId() == id) {
				if (g.getStockQuantity() >= stockQuantity) {
					double totalPrice = stockQuantity * g.getPrice();
					g.setStockQuantity(g.getStockQuantity() - stockQuantity);
					System.out.println("Purchase Successful");
					System.out.println("Total Bill: Rs." + totalPrice);
					return g;
				} else {
					System.out.println("Insufficient stock. Available: " + g.getStockQuantity());
					return null;
				}
			}
		}
		System.out.println("Grocery item not available.");
		return null;
	}

}
