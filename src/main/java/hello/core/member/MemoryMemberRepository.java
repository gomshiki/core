package hello.core.member;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository{

    // 멤버 정보를 담을 저장소 생성(key, value 형태)
    private static Map<Long, Member> store = new HashMap<>();

    // 멤버 ID와 멤버 객체 저장
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    // 저장소에서 memberID에 해당하는 객체 뽑아내기
    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }

}
