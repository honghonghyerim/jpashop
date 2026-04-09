package jpabook.jpashop.controller;


import jakarta.validation.Valid;
import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.service.Memberservice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final Memberservice memberservice;

    @GetMapping(value = "/members/new") //브라우저 주소창에 localhost:8080/members/new를 입력하고 접속(GET 방식)했을 때 이 메서드를 실행하라는 뜻
    public String createForm(Model model) { //스프링이 제공하는 데이터 바구니, 컨트롤러에서 만든 데이터를 화면으로 전달할떼 여기에 담아 보냄
        model.addAttribute("memberForm", new MemberForm()); //MemberForm 객체(값)를 하나 생성해서 "memberForm" 이라는 변수를만들어 model 에넣음
        return "members/createMemberForm"; //저경로 파일을 찾아 브러우저에 띄움
    }

    @PostMapping("/members/new")
    public String create(@Valid MemberForm form, BindingResult result) {

        if(result.hasErrors()) {
            return "members/creatememberform";
        }

        Address address = new Address(form.getCity(), form.getStreet(), form.getZipcode());
        Member member = new Member();
        member.setName(form.getName());
        member.setAddress(address);

        memberservice.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list (Model model) {
        List<Member> members = memberservice.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";

    }

}
