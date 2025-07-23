package com.example.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class PrimeDiscount implements Discount{

	@Override
	public void calculateDiscount() {
		// TODO Auto-generated method stub
		System.out.println("You got 20% discount");
		
	}

}
