package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 1. SRP : 구현 객체를 생성하고 연결하는 책임은 AppConfig가 가진다. 클라이언트는 실행하는 책임만 담당
 * 2. DIP : 객체 인스턴스를 클라이언트 코드 대신  생성해 클라이언트 코드에 의존관계를 주입했다.
 * 3. OCP : Appconfig가 의존관계를 변경해 클라이언트 코드에 주입하므로 클라이언트는 코드를 변경하지 않는다.(SW 요소 확장 & 변경 X)
 * */
@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
