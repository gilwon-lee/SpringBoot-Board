package lee.springboard.controller;

import lee.springboard.domain.Member;
import lee.springboard.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

//@Autowired : 스프링이 연관된 객체를 스프링 컨테이너에서 찾아서 넣어준다.
//


@Controller
public class MemberController {


    private final MemberService memberService;

    // DI(@Autowired)는 필드 주입, setter 주입, 생성자 주입이 있다.
    // 일반적으로 생성자 주입을 하는 것이 좋음
    // 필드 주입은 같은 클래스를 서로 참조하는 경우가 발생함
    // setter 주입은 값 변경이 가능
    // 클래스 선언에 final을 붙이고 생성자에 DI를 주입하는 것이 동적으로 바뀌는 일이 없음
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createFor(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
