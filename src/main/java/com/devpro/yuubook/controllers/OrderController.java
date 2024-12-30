package com.devpro.yuubook.controllers;

import com.devpro.yuubook.models.dto.Cart;
import com.devpro.yuubook.models.dto.CartItem;
import com.devpro.yuubook.models.dto.CustomerAddress;
import com.devpro.yuubook.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OrderController extends BaseController{
	@Autowired
	private OrderService orderService;

	@GetMapping("/order-confirm")
	public String orderConfirm(ModelMap model, HttpServletRequest request) {
		HttpSession httpSession = request.getSession();
		Cart cart = (Cart) httpSession.getAttribute("GIO_HANG");
		CustomerAddress customerAddress = (CustomerAddress) httpSession.getAttribute("DIA_CHI_KHACH_HANG");
		if (cart != null && !cart.getCartItems().isEmpty() && customerAddress != null) {
			List<CartItem> cartItems = cart.getCartItems();
			orderService.saveOrder(cartItems, customerAddress);
			httpSession.removeAttribute("GIO_HANG");
			httpSession.removeAttribute("DIA_CHI_KHACH_HANG");
			model.addAttribute("isSuccess", true);
		} else {
			model.addAttribute("isSuccess", false);
		}
		return "order-confirm";
	}
}
