package com.jwt.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UserDetails user1=new UserDetails();
		user1.setUserId(1);
		user1.setUserName("I'am first user !");
		
		SessionFactory   sessionFactory =new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		//session.save(user1);
		
		
		user1=null;
		 
		  user1=(UserDetails)session.get(UserDetails.class, 1);
		  user1.setUserName("Updated name !");
		
		   session.delete(user1);
		   
		  // System.out.println(" Updated User name  Fetched : "+"  "+ user1.getUserName());
		session.getTransaction().commit();
		
				

	}

}
