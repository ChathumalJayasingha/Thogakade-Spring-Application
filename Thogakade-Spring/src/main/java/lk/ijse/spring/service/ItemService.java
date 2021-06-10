package lk.ijse.spring.service;

import lk.ijse.spring.dto.ItemDTO;

import java.util.ArrayList;

public interface ItemService {
     boolean addItem(ItemDTO dto);
     boolean deleteItem(String code);
     ItemDTO searchItem(String code);
     ArrayList<ItemDTO> getAllItem();
     boolean updateItem(ItemDTO dto);

}
