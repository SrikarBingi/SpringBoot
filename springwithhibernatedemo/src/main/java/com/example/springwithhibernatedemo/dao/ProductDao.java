package com.example.springwithhibernatedemo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public String saveProduct(Product product) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		session.save(product);
		t.commit();
		session.close();
		return "Product Details Saved";
	}
	
	public List<Product> getProducts(){
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		List<Product> productsList = session.createQuery("from Product").list();
		t.commit();
		session.close();
		return productsList;
	}
	
	public Product findProduct(Integer pid) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		Product pr = session.load(Product.class, pid);
		t.commit();
		session.close();
		return pr;
	}
	
	public String deleteProduct(Integer pid) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction(); 
		Product pr = session.load(Product.class, pid);
		session.delete(pr);
		t.commit();
		session.close();
		return "Product Deleted";
	}
	
}
