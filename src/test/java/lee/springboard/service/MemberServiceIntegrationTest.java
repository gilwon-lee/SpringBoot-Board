package lee.springboard.service;

import lee.springboard.domain.Member;
import lee.springboard.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

//스프링 부트 테스트 ->스프링 컨테이너와 함께 테스트
@SpringBootTest
//테스트가 끝난 후 롤백을 해줌 
//before case가 필요 없음
@Transactional
class MemberServiceIntegrationTest {

    //객체 선언
    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;
//
//     MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("hello");
        //when
        Long savedId = memberService.join(member);
        //then
        Optional<Member> findMember = memberService.findOne(savedId);
        //assertions.assertEquals(예상값,실제값)
        //Assertions.assertThat(예상값).isEqualTo(실제값)
        assertThat(member.getName()).isEqualTo(findMember.get().getName());
    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        IllegalStateException e =assertThrows(IllegalStateException.class,
                ()-> memberService.join(member2));

        //then
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }
}