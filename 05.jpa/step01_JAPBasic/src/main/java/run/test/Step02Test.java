package run.test;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import customer.enumtype.GradeType;
import step02.entity.Customer;

public class Step02Test {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step01_JPABasic");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
	  try {
		   // insertCustomer(EntityManager em);
		   insertCustomer(em);
		   tx.commit();
	   } catch(Exception e) {
		   e.printStackTrace();
		   tx.rollback();
	   } finally { 
		   em.close();
	   }
	   emf.close();
			
    }
	
	public static void insertCustomer(EntityManager em) {
		
//		Customer newCustomer = new Customer(
//				                            "cus-1001",
//				                            "DEV", 
//				                            new Date(),
//				                            GradeType.GOLD);
		
		
		Customer newCustomer =  Customer.builder()
				                   .id("cus-1001")
				                   .registrationDate(new Date())
				                   .build();
         
		System.out.println(newCustomer);
				
//		    newCustomer.setId("cus-1001");
//		    newCustomer.setName("DEV");
//		    newCustomer.setRegistrationDate(new Date());
//		    newCustomer.setGrade(GradeType.GOLD);
		
		 em.persist(newCustomer);
	}

}
