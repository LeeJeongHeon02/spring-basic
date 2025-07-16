package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
// @Configuration어노테이션을 붙이면 바이트코드를 조작하는 CGLIB기술을 이용해 싱글톤을 보장하지만,
// 만약 @Bean만 적용한다면?
public class AppConfig {

    /* 이미 스프링 컨테이너에 등록이 되어 있으면, 등록된 것을 반환해주고
    *  등록이 안되어있다면 내가 민들었던 로직을 호출해서 스프링 컨테이너에 등록한다.
    * */

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");

        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");

        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");

        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }

}
