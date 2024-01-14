package dao.Custm.Impl;

import dao.Custm.OrderDao;
import entity.Orders;

import java.sql.SQLException;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    @Override
    public boolean save(Orders entity) {
        return false;
    }

    @Override
    public List<Orders> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(Orders entity) {
        return false;
    }

    @Override
    public boolean delete(String data) {
        return false;
    }
}
