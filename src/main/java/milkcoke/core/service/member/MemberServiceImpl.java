package milkcoke.core.service.member;

import milkcoke.core.domain.member.Member;
import milkcoke.core.repository.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }



    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMemberById(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
