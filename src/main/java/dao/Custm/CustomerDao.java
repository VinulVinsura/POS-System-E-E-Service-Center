package dao.Custm;

import dao.CrudDao;
import entity.Customer;

public interface CustomerDao extends CrudDao<Customer> {
    Customer getLastCustomer();
}
