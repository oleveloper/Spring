package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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

            Member findMember = em.find(Member.class, 1L);

            /* retrieve */
            System.out.println("findMember.id = " + findMember.getId());
            System.out.println("findMember.name = " + findMember.getName());

            /* delete */
//            em.remove(findMember);

            /* update */
//            findMember.setName("HelloJPA");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
