package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    //AppConfig 사용으로 생성자 생성
    private  final MemberRepository memberRepository;
    private  final DiscountPolicy discountPolicy;

    @Autowired // 의존관계 주입
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

// DIP 위반을 수정하기위해 주석처리
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDicountPolicy();

    // AppConfig 사용으로 주석처리
    // 회원정보를 가져올 레퍼지토리 인스턴스 생성
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
// 할인 정책 인스턴스 생성
//    private DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        // 회원정보, 아이템정보, 정상가격, 할인가격을 Order인스턴스에 담아 리턴함
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
