package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class SpringbootstsdemoApplication {

	public static void main(String[] args) {
		ApplicationContext ioc = SpringApplication.run(SpringbootstsdemoApplication.class, args);
		
		Discount d = new DiscountImpl();
//		d.calculateDiscount();
		
		Product p = ioc.getBean(Product.class);
		p.setPid(1);
		p.setPname("Book");
//		System.out.println("Pid :"+p.getPid()+" Pnmae :"+p.getPname());
//		System.out.println(p);
		
		Order o = ioc.getBean(Order.class);
		o.setOid(7);
		o.setStatus("Delivered");
//		o.setProd(p);
//		System.out.println(o);
		
//		o.setDiscount(d);
		o.getDiscount().calculateDiscount();
	}

}
