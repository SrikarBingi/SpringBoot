package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class DiscountImpl implements Discount {

	@Override
	public void calculateDiscount() {
		// TODO Auto-generated method stub
		System.out.println("You got 10% discount");
	}

}
