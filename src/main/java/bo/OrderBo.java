package bo;

import dto.OrderDto;

public interface OrderBo {
    boolean saveOrder(OrderDto dto);
}
