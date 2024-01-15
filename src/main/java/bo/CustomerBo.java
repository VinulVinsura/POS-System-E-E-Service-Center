package bo;

import dto.CustomerDto;

public interface CustomerBo {
    boolean saveCustomer(CustomerDto dto);
    String generateCustomerID();
}
