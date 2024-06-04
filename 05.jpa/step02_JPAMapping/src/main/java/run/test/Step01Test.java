package run.test;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import step01.entity.Member;
import step01.entity.Team;


public class Step01Test {
    public static void methodCustomer(EntityManager em) {
		// insert : 순서 
    	Team team = new Team();
    	team.setName("Tech");
    	em.persist(team);
		
    	Member rose = new Member();
    	rose.setName("rose");
    	rose.setAge(26);
    	rose.setTeamId(team.getId());
    	em.persist(rose);
    	
    	
    	
	}
	
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step02_JPAMapping");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
	
		try {
			// insertCustomer(EntityManager em);
			methodCustomer(em);
			tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
		emf.close();
		
	}

}
