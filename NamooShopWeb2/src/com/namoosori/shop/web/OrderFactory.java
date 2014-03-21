package com.namoosori.shop.web;

import com.namoosori.namooshop.domain.Order;
import com.namoosori.namooshop.domain.Product;
import com.namoosori.namooshop.service.facade.ProductService;
import com.namoosori.namooshop.service.factory.NamooShopServiceFactory;

public class OrderFactory {
	
	public static Order createOrder(String[] productNos) {
		//
		ProductService productService = NamooShopServiceFactory.getInstance().getProductService();

		Order order = new Order();
		if(productNos != null) {			
			for(String productNum : productNos) {
				Product product= productService.getProduct(Integer.parseInt(productNum));
				order.addProduct(product);
			}
			return order;
		}
		return null;
	}
}
