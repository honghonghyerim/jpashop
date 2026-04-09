package jpabook.jpashop.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import jpabook.jpashop.domain.Member;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    //단건 조회 파라미터 id 에 따라 그에맞는 데이터가 조회됨
    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    //멤버엔티티 전체 조회
    public List<Member> findAll() {
        //Member.class 이건 반환타입
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

    // 파라미터 name 조건인 데이터 찾기
    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
