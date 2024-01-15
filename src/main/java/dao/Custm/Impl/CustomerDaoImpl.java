package dao.Custm.Impl;

import dao.Custm.CustomerDao;
import dao.Hibernate;
import entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public boolean save(Customer entity) {
        Session session = Hibernate.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
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

    @Override
    public Customer getLastCustomer() {
        Session session = Hibernate.getSession();
        Query query = session.createQuery("FROM Customer C ORDER BY C.customer_ID DESC");
        List<Customer> list = query.list();
        for (Customer customer:list) {
            return new Customer(customer.getCustomer_ID(),
                    customer.getCustomer_Name(),
                    customer.getEmail(),
                    customer.getPhone_Num());
        }

        return null;
    }
}
