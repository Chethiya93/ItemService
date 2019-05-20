package com.group_4.service;

import java.util.List;
import java.util.Optional;

import com.group_4.modal.ItemTypes;

public interface TypeService {
	
	 void saveType(ItemTypes itemTypes);
	 void updateType(ItemTypes itemTypes);
	 void deleteType(Integer id);
	 Optional<ItemTypes> getItemTypes(Integer id);
	 List <ItemTypes> getAllTypes(Integer cid);
	
}
