package hello.core.order;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// spring 없이 순수 자바코드로만 테스트 구현하기
// 생성자 주입 사용 시 장점 : 불변, 누락 방지, 필드에 final 키워드 사용가능 - 생성자에서 값이 설정되지 않는 오류를 컴파일 시 잡을 수 있음
// 수정자 주입을 포함한 나머지 주입 방식은 모두 생성자 이후에 호출되므로, 필드에 'final' 키워드를 사용할 수 없음.
class OrderServiceImplTest {
    @Test
    void createOrder(){
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
        Order order = orderService.createOrder(1L,"itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}