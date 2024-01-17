package bo.Impl;

import bo.OrderBo;
import dao.Custm.Impl.OrderDaoImpl;
import dao.Custm.OrderDao;
import dto.OrderDto;
import entity.Orders;

public class OrderBoImpl implements OrderBo {
    private OrderDao orderDao=new OrderDaoImpl();
    @Override
    public boolean saveOrder(OrderDto dto) {
       return orderDao.save(dto);


    }

    @Override
    public String generateOrderID() {
        if (orderDao.getLastOrder()!=null){
            String orderId = orderDao.getLastOrder().getOrderId();
            int num= Integer.parseInt(orderId.split("R")[1]);
            num++;
            return String.format("OR%03d",num);
        }else {
            return "OR001";
        }

    }
}
