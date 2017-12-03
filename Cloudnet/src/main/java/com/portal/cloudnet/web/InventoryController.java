
package com.portal.cloudnet.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.portal.cloudnet.domain.Item;
import com.portal.cloudnet.service.InventoryService;
import com.portal.cloudnet.service.UserService;


@Controller
@RequestMapping("/inventory")
public class InventoryController extends BaseController {
	@Autowired
	private InventoryService inventoryService;

	@RequestMapping(value = "/getAllItems", method = RequestMethod.GET)
	public ModelAndView listAllBoards() {
		ModelAndView mav =new ModelAndView();
		List<Item> items = inventoryService.getAllItems();
		mav.addObject("items", items);
		mav.setViewName("/inventory/getAllItems");
		return mav;
	}

	@RequestMapping(value = "/addItem", method = RequestMethod.POST)
	public String addItem(Item item) {
		inventoryService.addItem(item);
		return "forward:/index.jsp";
	}
	
	@RequestMapping(value = "/updateItem", method = RequestMethod.POST)
	public String updateItem(Item item) {
		inventoryService.updateItem(item);
		return "forward:/updateItem.jsp";
	}
	
	@RequestMapping(value = "/removeItem", method = RequestMethod.POST)
	public String removeItem(Item item) {
		inventoryService.removeItem(item.getItemId());;
		return "forward:/index.jsp";
	}


}
