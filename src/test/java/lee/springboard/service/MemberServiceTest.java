package lee.springboard.service;

import lee.springboard.domain.Member;
import lee.springboard.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/*테스트 실행시 given when then으로 나누면 훨씬 확인하기가 편함*/

class MemberServiceTest {

    //객체 선언
    MemberService memberService;
    MemoryMemberRepository memberRepository;
//
//     MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    // 실행 전 생성자를 이용한 객체 생성
    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

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

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");


        /*        try {
            memberService.join(member2);
            fail("예외가 발생해야 합니다.");
        } catch (IllegalStateException e) {
            throw new RuntimeException(e);
        }*/


        //then
    }

    @Test
    void 회원찾기() {
    }

    @Test
    void findOne() {
    }
}