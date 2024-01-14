package dao.Custm.Impl;

import dao.Custm.CustomerDao;
import entity.Customer;

import java.sql.SQLException;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public boolean save(Customer entity) {
        return false;
    }

    @Override
    public List<Customer> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(Customer entity) {
        return false;
    }

    @Override
    public boolean delete(String data) {
        return false;
    }
}
