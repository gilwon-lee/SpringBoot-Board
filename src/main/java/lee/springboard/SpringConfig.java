package lee.springboard;

import lee.springboard.repository.MemberRepository;
import lee.springboard.repository.MemoryMemberRepository;
import lee.springboard.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig{

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    };

}
