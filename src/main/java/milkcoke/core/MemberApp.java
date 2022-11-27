package milkcoke.core;

import milkcoke.core.domain.member.Member;
import milkcoke.core.domain.member.Grade;
import milkcoke.core.repository.member.MemoryMemberRepository;
import milkcoke.core.service.member.MemberService;
import milkcoke.core.service.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl(new MemoryMemberRepository());
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member foundMember = memberService.findMemberById(1L);

        System.out.println("Member: " + member.getName());
        System.out.println("Found member: " + foundMember.getName());

    }
}
