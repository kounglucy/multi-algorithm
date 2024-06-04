package run.test;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import step02.entity.Member;
import step02.entity.Team;


public class Step02Test {
    public static void methodCustomer(EntityManager em) {
		// insert : 순서 
//    	Team team = new Team();
//    	team.setName("Tech");
//    	em.persist(team);
//		
//    	Member rose = new Member();
//    	rose.setName("rose");
//    	rose.setAge(26);
//    	rose.setTeam(team);
//    	em.persist(rose);
//    	
    	// select = team 정보 (로제 id 값으로 team 정보 출력)
    	/* select
               member0_.id as id1_0_0_,
               member0_.age as age2_0_0_,
               member0_.name as name3_0_0_,
               member0_.team_id as team_id4_0_0_,
               team1_.id as id1_1_1_,
               team1_.name as name2_1_1_ 
           from
               Member member0_,
               Team team1_ 
           where
               member0_.team_id=team1_.id(+) 
               and member0_.id=?
    	 */
    	

    	Team findTeam = em.find(Member.class, 2L).getTeam();
    	System.out.println(findTeam);
    	
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
