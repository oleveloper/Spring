package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        /* EntityManagerFactory는 DB 당 하나만 생성된다. */
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); /* persistence.xml > persistence-unit name */

        /* EntityManager는 Thread간 공유하지 않는다. 요청이 올 때 마다 생성하고 버린다. */
        EntityManager em = emf.createEntityManager();

        /* JPA의 모든 데이터 변경은 Transaction 안에서 실행한다. */
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            /* create */
//            Member member = new Member();
//            member.setId(1L);
//            member.setName("helloA");
//            em.persist(member);


//            Member findMember = em.find(Member.class, 1L);
            /* retrieve */
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name = " + findMember.getName());

            /* delete */
//            em.remove(findMember);

            /* update */
//            findMember.setName("HelloJPA");

            /* JPQL : 테이블이 아닌 엔티티 객체를 대상으로 질의한다. 객체 지향 SQL이라고 할 수 있다.
                      SQL를 추상화하여 특정 DB SQL에 의존하지 않으므로
                      dialect를 바꾸어도 쿼리를 바꾸지 않아도 된다. */
             List<Member> result = em.createQuery("select m from Member as m", Member.class)
                     .setFirstResult(1)
                     .setMaxResults(8)
                    .getResultList();
             for (Member member : result) {
                 System.out.println("member = " + member.getName());
             }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
