package com.tedu.sp06.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import pojo.Item;
import pojo.Order;
import pojo.User;
import web.utils.JsonResult;

@RestController
public class RibbonController {
	@Autowired
	private RestTemplate rt;
	
	@SuppressWarnings("unchecked")
	@GetMapping("/item-service/{orderId}")
	public JsonResult<List<Item>> getItems(@PathVariable String orderId) {
		return rt.getForObject("http://item-service/{1}", JsonResult.class, orderId);
	}

	@SuppressWarnings("rawtypes")
	@PostMapping("/item-service/decreaseNumber")
	public JsonResult decreaseNumber(@RequestBody List<Item> items) {
		return rt.postForObject("http://item-service/decreaseNumber", items, JsonResult.class);
	}

	/////////////////////////////////////////
	
	@SuppressWarnings("unchecked")
	@GetMapping("/user-service/{userId}")
	public JsonResult<User> getUser(@PathVariable Integer userId) {
		return rt.getForObject("http://localhost:8101/{1}", JsonResult.class, userId);
	}

	@SuppressWarnings("rawtypes")
	@GetMapping("/user-service/{userId}/score") 
	public JsonResult addScore(
			@PathVariable Integer userId, Integer score) {
		return rt.getForObject("http://localhost:8101/{1}/score?score={2}", JsonResult.class, userId, score);
	}
	
	/////////////////////////////////////////
	
	@SuppressWarnings("unchecked")
	@GetMapping("/order-service/{orderId}")
	public JsonResult<Order> getOrder(@PathVariable String orderId) {
		return rt.getForObject("http://localhost:8201/{1}", JsonResult.class, orderId);
	}

	@SuppressWarnings("rawtypes")
	@GetMapping("/order-service")
	public JsonResult addOrder() {
		return rt.getForObject("http://localhost:8201/", JsonResult.class);
	}
}
