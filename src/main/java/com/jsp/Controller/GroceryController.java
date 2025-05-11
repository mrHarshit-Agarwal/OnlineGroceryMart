package com.jsp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.Dao.GroceryDao;
import com.jsp.Dto.Grocery;

@Controller
public class GroceryController {

	@Autowired
	GroceryDao dao;

	// Show form to add a grocery item
	@RequestMapping("/add")
	public ModelAndView getGroceryForm() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("grocery", new Grocery());
		mv.setViewName("add");
		return mv;
	}

	// Save grocery item to DB
	@RequestMapping("/save")
	@ResponseBody
	public String saveGrocery(@ModelAttribute Grocery grocery) {
		String msg = dao.insertGrocery(grocery);
		return msg;
	}

	// Show search form
	@RequestMapping("/search")
	public String getSearchForm() {
		return "search";
	}

	// Display grocery item by ID
	@RequestMapping("/view")
	public ModelAndView displayGroceryDetails(@RequestParam int id) {
		Grocery grocery = dao.getGroceryById(id);

		if (grocery != null) {
			ModelAndView mv = new ModelAndView();
			mv.addObject("grocery", grocery);
			mv.setViewName("display");
			return mv;
		} else {
			ModelAndView mv = new ModelAndView();
			mv.addObject("errormsg", "GROCERY ITEM ID DOESN'T EXIST...");
			mv.setViewName("error");
			return mv;
		}
	}

	// Load delete form
	@RequestMapping("/delete")
	public String getDeleteForm() {
		return "delete";
	}

	// Delete grocery item by ID
	@RequestMapping("/remove")
	public ModelAndView deleteGrocery(@RequestParam int id) {
		int res = dao.deleteGrocery(id);

		if (res == 1) {
			ModelAndView mv = new ModelAndView();
			mv.addObject("successmsg", "Grocery item with ID : " + id + " is deleted successfully");
			mv.setViewName("deletesuccess");
			return mv;
		} else {
			ModelAndView mv = new ModelAndView();
			mv.addObject("errormsg", "GROCERY ID : " + id + " NOT FOUND.");
			mv.setViewName("error");
			return mv;
		}
	}

	// Show update form
	@RequestMapping("/edit")
	public String getUpdateForm() {
		return "update";
	}

	// Update grocery item
	@RequestMapping("/update")
	public ModelAndView updateGrocery( @RequestParam int id, @RequestParam String name, @RequestParam String category,
		    @RequestParam double price, @RequestParam int stockQuantity) {

		    int res = dao.updateGrocery(id, name, category, price, stockQuantity);

		    ModelAndView mv = new ModelAndView();
		    if (res == 1) {
		        mv.addObject("successmsg", "GROCERY DETAILS UPDATED SUCCESSFULLY.");
		        mv.setViewName("updatesuccess");
		    } else {
		        mv.addObject("errormsg", "GROCERY ID : " + id + " NOT FOUND.");
		        mv.setViewName("error");
		    }
		    return mv;
		}

	// Retrieve all grocery items
	@RequestMapping("/get")
	public ModelAndView getAllGroceryList() {
		List<Grocery> list = dao.getAllGroceries();

		ModelAndView mv = new ModelAndView();
		mv.addObject("grocerylist", list);
		mv.setViewName("displayAll");
		return mv;
	}
	
	@RequestMapping("/buy")
	public String showPurchaseForm() {
	    return "purchase";
	}

	@RequestMapping("/purchase")
	public ModelAndView processPurchase(@RequestParam int id, @RequestParam int stockQuantity) {
	    Grocery grocery = dao.purchaseGrocery(id, stockQuantity);
	    ModelAndView mv = new ModelAndView();
	    
	    if (grocery != null) {
	        mv.addObject("grocery", grocery);
	        mv.addObject("quantity", stockQuantity);
	        mv.addObject("total", grocery.getPrice() * stockQuantity);
	        mv.setViewName("bill");
	    } else {
	        mv.addObject("message", "Grocery not available or insufficient stock.");
	        mv.setViewName("purchase");
	    }
	    
	    return mv;
	}



}
