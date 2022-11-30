package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
    // spring 사용을 위해 주석처리
    //         AppConfig appConfig = new AppConfig();
    //        MemberService memberService = appConfig.memberService();

  //      MemberService memberService = new MemberServiceImpl();

        // 스프링 컨테이너 : 모든 객체(@bean)과 같은 것을 관리해줌
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); // AppConfig의 환경설정을 가지고 스프링 bean에 넣어 관리
        // getBean(찾을 객체 이름, 반환 타입)
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.printf("new Member = "+ member.getName());
        System.out.printf("findMember = "+ findMember.getName());
    }
}
