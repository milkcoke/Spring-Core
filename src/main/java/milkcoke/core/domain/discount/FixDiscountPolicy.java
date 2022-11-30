package milkcoke.core.domain.discount;

import milkcoke.core.domain.member.Grade;
import milkcoke.core.domain.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private final int discountFixAmount = 1_000;

    @Override
    public int getDiscountPrice(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }

}