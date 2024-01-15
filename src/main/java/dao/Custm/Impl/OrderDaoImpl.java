package dao.Custm.Impl;

import dao.Custm.OrderDao;
import dao.Hibernate;
import dto.OrderDto;
import entity.Customer;
import entity.Employee;
import entity.Orders;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Handler;

public class OrderDaoImpl implements OrderDao {

    @Override
    public boolean save(OrderDto dto) {
        Session session = Hibernate.getSession();
        Transaction transaction = session.beginTransaction();
        Orders order=new Orders(dto.getOrderId(),
                dto.getDate());
        order.setCustomer(session.find(Customer.class,dto.getCustomerId()));
        order.setEmployee(session.find(Employee.class,dto.getEmployeeId()));
        session.save(order);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<OrderDto> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(OrderDto dto) {
        return false;
    }

    @Override
    public boolean delete(String data) {
        return false;
    }
}
