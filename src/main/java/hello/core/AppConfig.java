package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.*;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 설정정보
@Configuration
public class AppConfig {

    // 싱글톤 패턴이 깨지지않나? -> test코드로 확인해보자!
    // @Bean memberService -> new MemoryMemberRepository()
    // @Bean orderService -> new MemoryMemberRepository



    // 의존관계 역전 원칙
    // DIP(Dependency Inversion principle) : 추상화에 의존해야하지, 구체화에 의존하면 안된다.
    // 이를 위해 Appconfig에서 적용할 구현체를 선택하고, 각 구현체에서는 생성자를 이용해 주입해줌 --> 의존관계 주입
    // Appconfig에서 생성자를 이용해 주입할 구현체 결정
    @Bean
    public MemberService memberService(){
        // 생성자 주입
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    // 역할과 구현클래스를 분리해서 가시화하기위한 코드변경
    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy(){
 //       return new FixDiscountPolicy(); RateDiscoutnPolicy로 정책 변경
        return new RateDiscountPolicy();
    }
}
