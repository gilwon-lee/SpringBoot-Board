package lee.springboard;

import lee.springboard.repository.MemberRepository;
import lee.springboard.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Configuration : Bean을 등록하기 위한 클래스 설정
// Bean을 적용하기 위해서는 적용하는 클래스에
// @Controller,@Service와 같은 @Component를 설정하여 스프링이 관리 할 수 있는 객체로 만들어야한다.
// main 매서드의 패키지는 자동적으로 Component-scan이 가능

@Configuration
public class SpringConfig{

    private final MemberRepository memberRepository;

    //생성자가 한개이면 @Autowired 생략 가능
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }


/*    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }*/

/*    @Bean
    public MemberRepository memberRepository(){
        //return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        //return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    };*/

}
