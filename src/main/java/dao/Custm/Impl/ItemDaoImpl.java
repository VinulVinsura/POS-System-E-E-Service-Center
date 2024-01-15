package dao.Custm.Impl;

import dao.Custm.ItemDao;
import dao.Hibernate;
import dto.ItemDto;
import entity.Customer;
import entity.Item;
import entity.Orders;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class ItemDaoImpl implements ItemDao {

    @Override
    public boolean save(ItemDto dto) {
        Session session = Hibernate.getSession();
        Transaction transaction = session.beginTransaction();
        Item item=new Item(dto.getItemCode(),
                dto.getDescription(),
                dto.getCatogry(),dto.getProductName(),
                dto.getStatus());
        item.setCustomer(session.find(Customer.class,dto.getCustomerID()));
        item.setOrders(session.find(Orders.class,dto.getOrderID()));
        session.save(item);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<ItemDto> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(ItemDto dto) {
        return false;
    }

    @Override
    public boolean delete(String data) {
        return false;
    }
}
