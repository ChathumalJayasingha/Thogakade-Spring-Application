package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.exception.NotFoundException;
import lk.ijse.spring.exception.ValidateException;
import lk.ijse.spring.service.CustomerService;
import lk.ijse.spring.service.ItemService;
import lk.ijse.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@CrossOrigin
@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService service;

    @PostMapping
    public ResponseEntity saveItem(@RequestBody ItemDTO dto) throws Exception {
        System.out.println(dto.toString());
        if(dto.getCode().trim().length()<=0){
            throw new ValidateException("Item code Cannot be empty");
        }
        if(dto.getDescription().trim().length()<=0){
            throw new ValidateException("Item desc Cannot be empty");
        }
        if(dto.getQty()<=0){
            throw new ValidateException("Item qty Cannot be empty");
        }
        if(dto.getUnitPrice()<=0){
            throw new ValidateException("Item Unit Price Cannot be empty");
        }
        service.addItem(dto);
        return new ResponseEntity(new StandardResponse("201","Done",dto), HttpStatus.CREATED);
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllItems() {
        ArrayList<ItemDTO> allItem = service.getAllItem();
        return new ResponseEntity(new StandardResponse("200", "Done", allItem.toString()), HttpStatus.OK);
    }


    @GetMapping(params = {"code"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchItem(@RequestParam String code) {
        ItemDTO itemDTO = service.searchItem(code);
        return new ResponseEntity(new StandardResponse("200", "Done", itemDTO), HttpStatus.OK);
    }


    @DeleteMapping(params = {"code"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteItem(@RequestParam String code) {
        boolean b = service.deleteItem(code);
        return new ResponseEntity(new StandardResponse("200", "Done", b), HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateItem(@RequestBody ItemDTO dto) {
        if (dto.getCode().trim().length() <= 0) {
            throw new NotFoundException("No code provided to update");
        }
        service.updateItem(dto);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.OK);
    }

}
