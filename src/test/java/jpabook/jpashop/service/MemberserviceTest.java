package jpabook.jpashop.service;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberserviceTest {

    @Autowired Memberservice memberservice;
    @Autowired MemberRepository memberRepository;
    @Autowired EntityManager em;

    @Test
    public void 회원가입() throws Exception {
        Member member = new Member();
        member.setName("kim");

        Long saveID = memberservice.join(member);

        assertEquals(member, memberRepository.findOne(saveID));

    }

    @Test
    public void 중복_회원_예외 () throws Exception {

        Member member1 = new Member();
        member1.setName("kim");

        Member member2 = new Member();
        member2.setName("kim");

        memberservice.join(member1);

        //잘못된 입력이 들어왔을 때 에러를 잘 던지는지 확인하는 매서드
        assertThrows(IllegalStateException.class, () -> memberservice.join(member2));

    }
}