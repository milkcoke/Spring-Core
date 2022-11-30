package milkcoke.core.service.order;

import milkcoke.core.domain.discount.DiscountPolicy;
import milkcoke.core.domain.order.Order;
import milkcoke.core.repository.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;

// order service 는 할인에 대한 것을 아무것도 알지 몬하는 상태다.
public class OrderServiceImpl implements OrderService{
    // 구현체가 아닌 Interface (역할) 에만 의존해야한다. => DIP 원칙 준수
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    // 구현객체를 대신 생성하여 '주입'해줘야한다.
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
