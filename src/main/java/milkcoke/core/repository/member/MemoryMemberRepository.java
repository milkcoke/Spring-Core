package milkcoke.core.repository.member;

import milkcoke.core.domain.member.Member;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;
@Repository
public class MemoryMemberRepository implements MemberRepository {
    private static ConcurrentHashMap<Long, Member> store  = new ConcurrentHashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
