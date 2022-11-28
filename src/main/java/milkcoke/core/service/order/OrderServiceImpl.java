package milkcoke.core.service.order;

import milkcoke.core.discount.DiscountPolicy;
import milkcoke.core.order.Order;
import milkcoke.core.repository.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;

// order service 는 할인에 대한 것을 아무것도 알지 몬하는 상태다.
public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        var member = memberRepository.findById(memberId);
        var discountPrice = discountPolicy.getDiscountPrice(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
