package milkcoke.core.service.order;

import milkcoke.core.order.Order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);

}
