package dao.Custm.Impl;

import dao.Custm.ItemDao;
import dao.Hibernate;
import dto.ItemDto;
import entity.Customer;
import entity.Item;
import entity.Orders;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
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
        List<ItemDto> dtoList=new ArrayList<>();
        Session session = Hibernate.getSession();
        Query query = session.createQuery("FROM Item ");
        List<Item> list = query.list();
        for (Item item:list) {
            dtoList.add(new ItemDto(item.getItem_Code(),
                    item.getCatogary(),
                    item.getDescription(),
                    item.getProduct_Name(),
                    item.getStatus(),
                    item.getCustomer().getCustomer_ID(),
                    item.getOrders().getOrderId()));
        }
        return dtoList;
    }

    @Override
    public boolean update(ItemDto dto) {
        return false;
    }

    @Override
    public boolean delete(String data) {
        return false;
    }

    @Override
    public Item getLastItem() {
        Session session = Hibernate.getSession();
        Query query = session.createQuery("FROM Item I ORDER BY I.item_Code DESC");
        List<Item> list = query.list();
        for (Item item:list) {
            return new Item(item.getItem_Code(),
                    item.getDescription(),
                    item.getCatogary(),
                    item.getProduct_Name(),
                    item.getStatus());
        }
        return null;
    }
}
