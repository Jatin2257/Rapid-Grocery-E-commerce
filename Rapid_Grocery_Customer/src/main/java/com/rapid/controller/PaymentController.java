package com.rapid.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.JsonObject;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@Controller
public class PaymentController {

//	String online = "online";
//	String offline = "offline";

	@RequestMapping("/payment")
	public String online(HttpServletRequest request,Model model) throws RazorpayException {

		String paymentType = request.getParameter("payment");
		int totalAmount = Integer.parseInt(request.getParameter("total"));
		System.out.println("totalAmoutn====" + totalAmount);

		if ("online".equals(paymentType)) {

			RazorpayClient client = new RazorpayClient("rzp_test_AsGtB9UtEEzgrG", "SHKL5vlCqUQ4hZ7QVtWWT4P0");
			JSONObject object = new JSONObject();
			object.put("amount", totalAmount*100);
			object.put("currency", "INR");
			object.put("receipt", "txn_232425");

			// create a new order

			Order order = client.Orders.create(object);
			System.out.println(order);
			model.addAttribute("order", order.get("id"));
			model.addAttribute("amount", totalAmount);

			return "payment";
		} else {
			return "redirect:/order_list";
		}
	}

}
