package milkcoke.core.domain.discount;

import milkcoke.core.domain.member.Grade;
import milkcoke.core.domain.member.Member;
import org.springframework.stereotype.Component;

@Component
public class RateDiscountPolicy implements DiscountPolicy {

    private final int discountPercent = 10;

    @Override
    public int getDiscountPrice(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return (int)(price * discountPercent * 0.01);
        }
        return 0;
    }
}
