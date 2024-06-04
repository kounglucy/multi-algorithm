package run.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import step01.entity.Member;

public class Step01Test {

	public static void main(String[] args) {
		// EMF 
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step01_JPABasic");
		
		// EM
		EntityManager em =emf.createEntityManager();
		
		// TX : begin() ~ 작업 수행 ~ commit()
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		// insert 
//		Member member1 = new Member("dev-1001", "DEV");
//		em.persist(member1);
		
		
//		Member member2 = new Member("dev-1002", "DEVOPS");
//		em.persist(member2);
		
		// select : select * from member where id = ? 
//		Member findMember = em.find(Member.class, "dev-1001");
//		System.out.println(findMember);
		
		// selectAll : select * from member; JPQL
//		List<Member> members= em.createQuery("select m from Member m", Member.class).getResultList();
//		System.out.println(members);
		
		// update : dev-1002의 이름을 IT로 변경 
		//          update member set name = 'IT' where id = 'dev-1002';
//		Member findMember2 = em.find(Member.class, "dev-1002");
//		findMember2.setName("IT");
		
		// delete : delete from member where id = 'dev-1002';
		Member findMember2 = em.find(Member.class, "dev-1002");
		em.remove(findMember2);
		
		
		tx.commit();

	}

}
