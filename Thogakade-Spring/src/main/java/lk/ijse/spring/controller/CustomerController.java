package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.exception.NotFoundException;
import lk.ijse.spring.exception.ValidateException;
import lk.ijse.spring.service.CustomerService;
import lk.ijse.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@CrossOrigin
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping
    public ResponseEntity saveCustomer(@RequestBody CustomerDTO dto) throws Exception {
        System.out.println(dto.toString());
        if(dto.getId().trim().length()<=0){
            throw new ValidateException("Customer ID Cannot be empty");
        }
        if(dto.getName().trim().length()<=0){
            throw new ValidateException("Customer Name Cannot be empty");
        }
        if(dto.getAddress().trim().length()<=0){
            throw new ValidateException("Customer address Cannot be empty");
        }
        if(dto.getSalary()<=0){
            throw new ValidateException("Customer salary Cannot be empty");
        }
        service.addCustomer(dto);
        return new ResponseEntity(new StandardResponse("201","Done",dto), HttpStatus.CREATED);
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllCustomers() {
        ArrayList<CustomerDTO> allCustomers = service.getAllCustomer();
        return new ResponseEntity(new StandardResponse("200", "Done", allCustomers), HttpStatus.OK);
    }


    @GetMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchCustomer(@RequestParam String id) {
        CustomerDTO customerDTO = service.searchCustomer(id);
        return new ResponseEntity(new StandardResponse("200", "Done", customerDTO), HttpStatus.OK);
    }


    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteCustomer(@RequestParam String id) {
        boolean b = service.deleteCustomer(id);
        return new ResponseEntity(new StandardResponse("200", "Done", null), HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateCustomer(@RequestBody CustomerDTO dto) {
        if (dto.getId().trim().length() <= 0) {
            throw new NotFoundException("No id provided to update");
        }
        service.updateCustomer(dto);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.OK);
    }


//    @GetMapping("/getAll")
//    public ArrayList<CustomerDTO> getAllCustomers(){
//            return service.getAllCustomer();
//    }


//
//    @GetMapping(path = "/{id}")
//    public CustomerDTO searchCustomer(@PathVariable String id){
//            return service.searchCustomer(id);
//    }
//
//
//    @DeleteMapping (params ={"id"})
//    public boolean deleteCustomer(@RequestParam String id){
//        boolean b = service.deleteCustomer(id);
//        return b;
//    }
//
//
//    @PutMapping
//    public String updateCustomer(@RequestBody CustomerDTO dto){
//        boolean b = service.updateCustomer(dto);
//        return b+"";
//    }
//
//
//    @GetMapping(path = "/findCustomerByName/{name}")
//    public CustomerDTO findCustomerByName(@PathVariable String name){
//        return service.findTopByName(name);
//    }

}
