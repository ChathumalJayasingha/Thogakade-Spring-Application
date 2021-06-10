package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.exception.ValidateException;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl  implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public boolean addCustomer(CustomerDTO dto) {
        Optional<Customer> byId = customerRepo.findById(dto.getId());
        if (byId.isPresent()){
            throw new ValidateException("Customer Already in this database");
        }else {
            System.out.println(byId);
            Customer save = customerRepo.save(modelMapper.map(dto, Customer.class));
            return true;
        }

    }

    @Override
    public boolean deleteCustomer(String id) {
        CustomerDTO dto = searchCustomer(id);
        customerRepo.delete(modelMapper.map(dto,Customer.class));
        return true;

    }

    @Override
    public CustomerDTO searchCustomer(String id) {
        Optional<Customer> customer = customerRepo.findById(id);
//        if (customer.isPresent()){
//            Customer c = customer.get();
//            return modelMapper.map(c, CustomerDTO.class);
//        }return null;
        return customer.map(value -> modelMapper.map(value, CustomerDTO.class)).orElse(null);
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomer() {
//        ArrayList<CustomerDTO> allCustomer = new ArrayList<>();
//        List<Customer> all = customerRepo.findAll();
//        for (Customer c : all) {
//            allCustomer.add(new CustomerDTO(c.getId(),c.getName(),c.getAddress(),c.getSalary()));
//        }return allCustomer;
        List<Customer> all = customerRepo.findAll();
        return  modelMapper.map(all,new TypeToken<ArrayList<CustomerDTO>>(){}.getType());
    }

    @Override
    public boolean updateCustomer(CustomerDTO dto) {
        if (customerRepo.existsById(dto.getId())){
            customerRepo.save(modelMapper.map(dto,Customer.class));
            return true;
        }
        return false;

    }

    @Override
    public CustomerDTO findTopByName(String name) {
        Optional<Customer> customerByName = customerRepo.findTopByName(name);
//        if (customerByName.isPresent()){
//            Customer c = customerByName.get();
//            return new CustomerDTO(c.getId(),c.getName(),c.getAddress(),c.getSalary());
//        }return null;
        //********************
//        if (customerByName.isPresent()){
//            return modelMapper.map(customerByName.get(),CustomerDTO.class);
//        }return null;
        //*********************
        return customerByName.map(customer -> modelMapper.map(customer, CustomerDTO.class)).orElse(null);
    }

//    @Override
//    public CustomerDTO findCustomerByName(String name) {
//        Optional<Customer> customerByName = customerRepo.findTopByName(name);
//        if (customerByName.isPresent()){
//            Customer c = customerByName.get();
//            return new CustomerDTO(c.getId(),c.getName(),c.getAddress(),c.getSalary());
//        }return null;
//    }

}
