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
            /* create
             * 비영속 상태 */
//            Member member = new Member();
//            member.setId(1L);
//            member.setName("helloA");

            /* 객체를 저장한 상태(영속).
             * entity manager 내부 영속성 컨텍스트에서 member 객체의 관리가 시작 */
//            em.persist(member);

//            Member findMember = em.find(Member.class, 1L);
            /* retrieve */
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name = " + findMember.getName());

            /* 준영속
             * detach : member entity를 영속성 컨텍스트에서 분리. 준영속 상태 */
//            em.detach(member);

            /* delete
             * remove : 객체를 삭제한 상태 */
//            em.remove(findMember);

            /* update */
//            findMember.setName("HelloJPA");

            /* JPQL : 테이블이 아닌 엔티티 객체를 대상으로 질의한다. 객체 지향 SQL이라고 할 수 있다.
                      SQL를 추상화하여 특정 DB SQL에 의존하지 않으므로
                      dialect를 바꾸어도 쿼리를 바꾸지 않아도 된다. */
//             List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                     .setFirstResult(1)
//                     .setMaxResults(8)
//                    .getResultList();
//             for (Member member : result) {
//                 System.out.println("member = " + member.getName());
//             }

            /* insert : Entity 등록, 쓰기 지연 */
//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");
//
//            em.persist(member1);
//            em.persist(member2);

            /* update : Dirty Checking, 변경 감지 */
//            Member member = em.find(Member.class, 150L);
//            member.setUsername("A");

            Member member1 = new Member();
            member1.setUsername("A");

            Member member2 = new Member();
            member2.setUsername("B");

            Member member3 = new Member();
            member3.setUsername("C");

            System.out.println("==================");
            /* 영속성 컨텍스트에 삽입하기 위해서는 PK가 있어야 하므로,
               strategy가 IDENTITY인 insert의 경우 이 시점에 insert된다
               SEQUENCE인 경우 JPA 매커니즘에 의해 'call next value for ~'가 호출된다. 따라서 insert 쿼리가 호출되지 않고 commit시에 호출된다. */
            em.persist(member1); //1, 51
            em.persist(member2); //MEM
            em.persist(member3); //MEM

            System.out.println("member1 = " + member1.getId());
            System.out.println("member2 = " + member2.getId());
            System.out.println("member3 = " + member3.getId());
            System.out.println("==================");

            /* 준영속 상태로 만드는 방법 */
            /* detach
             * 영속성 컨텍스트에서 관리하지 않으므로 update 되지 않는다. */
//            em.detach(member);

            /* entity manager 안에 있는 영속성 컨텍스트를 모두 지운다.(초기화)
             * 1차 컨텍스트를 모두 삭제해버린다. */
//            em.clear();
//            Member member2 = em.find(Member.class, 150L); //다시 영속성 컨텍스트에 올린다

            /* 영속성 컨텍스트를 종료한다. */
//            em.close();

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
