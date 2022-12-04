package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    // 의존관계 역전 원칙
    // DIP(Dependency Inversion principle) : 추상화에 의존해야하지, 구체화에 의존하면 안된다.
    // 이를 위해 Appconfig에서 적용할 구현체를 선택하고, 각 구현체에서는 생성자를 이용해 주입해줌
    // Appconfig에서 생성자를 이용해 주입할 구현체 결정

    // AppConfig사용으로 생성자 생성
//   private final MemberRepository memberRepository = new MemoryMemberRepository();


    private final MemberRepository memberRepository;

    // 만약 생성자가 해당 클래스에서 1개면 Autowired 생략 가능
    @Autowired // 자동 의존관계 주입 ac.getBean(MemberRepository.class)처럼
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberID) {
        return memberRepository.findById(memberID);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
