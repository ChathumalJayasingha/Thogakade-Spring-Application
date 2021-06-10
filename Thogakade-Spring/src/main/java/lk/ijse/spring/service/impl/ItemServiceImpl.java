package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.entity.Item;
import lk.ijse.spring.exception.ValidateException;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.repo.ItemRepo;
import lk.ijse.spring.service.CustomerService;
import lk.ijse.spring.service.ItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public boolean addItem(ItemDTO dto) {
        Optional<Item> byCode = itemRepo.findById(dto.getCode());
        if (byCode.isPresent()){
            throw new ValidateException("Item Already in this database");
        }else {
            System.out.println(byCode);
            Item save = itemRepo.save(modelMapper.map(dto, Item.class));
            return true;
        }
    }

    @Override
    public boolean deleteItem(String code) {
        ItemDTO itemDTO = searchItem(code);
        Item map = modelMapper.map(itemDTO, Item.class);
        itemRepo.delete(map);
        return true;
    }

    @Override
    public ItemDTO searchItem(String code) {
        Optional<Item> byCode = itemRepo.findById(code);
        return modelMapper.map(byCode, ItemDTO.class);
    }

    @Override
    public ArrayList<ItemDTO> getAllItem() {
        List<Item> all = itemRepo.findAll();
        return modelMapper.map(all,new TypeToken<ArrayList<ItemDTO>>(){}.getType());
    }

    @Override
    public boolean updateItem(ItemDTO dto) {
        if (itemRepo.existsById(dto.getCode())){
            itemRepo.save(modelMapper.map(dto,Item.class));
            return true;
        }
        throw new ValidateException(dto.toString()+"This Item No found");

    }
}
