package lk.ijse.spring.service;

import lk.ijse.spring.dto.CustomerDTO;

import java.util.ArrayList;

public interface CustomerService {
     boolean addCustomer(CustomerDTO dto);
     boolean deleteCustomer(String id);
     CustomerDTO searchCustomer(String id);
     ArrayList<CustomerDTO> getAllCustomer();
     boolean updateCustomer(CustomerDTO dto);
     CustomerDTO findTopByName(String name);

}
