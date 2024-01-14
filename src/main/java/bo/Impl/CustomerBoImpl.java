package bo.Impl;

import bo.CustomerBo;
import dao.Custm.CustomerDao;
import dao.Custm.Impl.CustomerDaoImpl;
import dto.CustomerDto;
import entity.Customer;

public class CustomerBoImpl implements CustomerBo {
    private CustomerDao customerDao=new CustomerDaoImpl();
    @Override
    public boolean saveCustomer(CustomerDto dto) {
        return customerDao.save(new Customer(dto.getCustomerID(),
                dto.getCustomerName(),
                dto.getEmail(),
                dto.getNumber()));

    }
}
