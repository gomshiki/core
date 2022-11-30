package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {

        // Spring 사용을 위해 주석처리
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

//        MemberService memberService = new MemberServiceImpl();
//        OrderService orderService = new OrderServiceImpl();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        // 임의의 멤버 Id를 지정
        Long memberId = 1L;
        // member(memberId와, 이름, 등급)을 가진 인스턴스 생성
        Member member = new Member(memberId, "memberA", Grade.VIP);
        // member 인스턴스로 회원가입
        memberService.join(member);

        // 아이템 인스턴스(아이템Id, 아이템명, 가격)을 가진 order 인스턴스 생성
        Order order = orderService.createOrder(memberId, "itemA", 10000);

        // order 정보 출력( 이전에 toString 정의한 부분이 출력됨)
        System.out.println("order = "+order);
        System.out.println("order.calculatePrice = "+order.calculatePrice());

    }
}
