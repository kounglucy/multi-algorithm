package run.test;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import step03.entity.Member;
import step03.entity.Team;


public class Step03Test {
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
//    	Member jennie = new Member();
//    	jennie.setName("jennie");
//    	jennie.setAge(26);
//    	jennie.setTeam(team);
//    	em.persist(jennie);
    	
    	// selectAll : 팀 id를 가지고 member 테이블에서 해당 객체들 출력
    	// JPQL : "select * from Member m where m team_id = 1"
//    	List<Member> members = em.createQuery("select m from Member m where m.team = 1").getResultList();
//        System.out.println(members);
    	
        // 위에서는 member 테이블에서 해동 소속팀의 멤버 정보 출력 
        // 그렇다면 team 테이블을 기준으로 해당 소속팀의 멤버 정보를 출력 가능? 
//        Team findTeam = em.find(Team.class, 1L);
//        System.out.println(findTeam.getMembers());
        
        // -> 출력가능 단, 양방향 참조를 반드시 할 것
        // *주의 : 양방향 참조시 순환 메소드 에러 발생 가능, 양방향 참조를 하는 Entity(Team)의 toString 재정의 
        
        // ** DB에 여러명의 Member들을 추가하고 싶다 (단, 양방향 참조가 전제)
    	//    -> team.setMembers (List<Member> members);
//    	Team findTeam = em.find(Team.class, 1L);
//    	
//    	Member lisa = new Member();
//    	lisa.setName("lisa");
//    	lisa.setAge(26);
//    	lisa.setTeam(findTeam);
//    	em.persist(lisa);
//    	
//    	Member chu = new Member();
//    	chu.setName("chu");
//    	chu.setAge(26);
//    	chu.setTeam(findTeam);
//    	em.persist(chu);
//    	
//    	
//    	List<Member> newMembers = new ArrayList<Member>();
//    	newMembers.add(lisa);
//    	newMembers.add(chu);
//    	
//    	findTeam.setMembers(newMembers);
//    	em.persist(findTeam);
    	
    	// 양방향 참조시 기준이 되지 않는 필드(List<Member> members)는 
    	// 영속성에 영향을 주지 않는다
    	
		// Fetch
		// sql : select age from member where id = 2;
		/*
		    select
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
//		Member findrose = em.find(Member.class, 2L);
//		System.out.println(findrose.getAge());
		
		// Lazy 설정시 결과
		/*
		    select
		        member0_.id as id1_0_0_,
		        member0_.age as age2_0_0_,
		        member0_.name as name3_0_0_,
		        member0_.team_id as team_id4_0_0_ 
		    from
		        Member member0_ 
		    where
		        member0_.id=?
		 */
//		System.out.println(findrose.getTeam());
    	
    	// Select
    	// 1. TypedQuery : JPA에서 Query를 객체화 시킨것으로 변환 타입이 명확할 경우에 사용 
    	
//    	String query11 = "select m from Member m";
//    	TypedQuery<Member> query1 = em.createQuery(query11, Member.class);
    	
    	// * 파라미터 사용 경우 
    	// 1) 이름 파라미터 
//    	String query12 = "select m from Member m where m.id = :memberId";
//    	TypedQuery<Member> query2 = em.createQuery(query12, Member.class);
//    	Member member2 = query2
//    			                    .setParameter("memberId", 2L)
//    			                    .getSingleResult();
//    	
    	// 2) 위치 파라미터
//    	String query13 = "select m from Member m where m.id = ?1";
//    	TypedQuery<Member> query3 = em.createQuery(query13, Member.class);
//    	Member members3 = query3
//    			                    .setParameter(1, 2L)
//    			                    .getSingleResult();
//    	
//    	System.out.println(members3);
    	
    	// 2. Query : JPA 에서 Query를 객체화 시킨것으로 변환 타입이 불명확할 경우에 사용 
    	String query14 = "select m from Member m";
    	Query query4 = em.createQuery(query14);
    	List members4 = query4.getResultList();
    	
    	// members4 내부 member 각각의 age값을 출력? 
//    	System.out.println(members4);
    	for(Object member : members4) {
    		System.out.println(((Member) member).getAge());
    	}

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
