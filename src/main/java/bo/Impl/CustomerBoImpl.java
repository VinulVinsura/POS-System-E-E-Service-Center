package bo.Impl;

import bo.CustomerBo;
import dao.Custm.CustomerDao;
import dao.Custm.Impl.CustomerDaoImpl;
import dto.CustomerDto;
import entity.Customer;
import entity.Employee;

public class CustomerBoImpl implements CustomerBo {
    private CustomerDao customerDao=new CustomerDaoImpl();
    @Override
    public boolean saveCustomer(CustomerDto dto) {
        return customerDao.save(new Customer(dto.getCustomerID(),
                dto.getCustomerName(),
                dto.getEmail(),
                dto.getNumber()));

    }

    @Override
    public String generateCustomerID() {
        Customer lastCustomer = customerDao.getLastCustomer();
        if (lastCustomer!=null){
            String customerId = lastCustomer.getCustomer_ID();
            int num= Integer.parseInt(customerId.split("C")[1]);
            num++;
            return String.format("C%03d",num);
        }else {
            return "C001";
        }
    }
}
