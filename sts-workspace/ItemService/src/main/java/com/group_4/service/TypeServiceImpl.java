package com.group_4.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group_4.modal.Category;
import com.group_4.modal.ItemTypes;
import com.group_4.repository.CategoryRepository;
import com.group_4.repository.TypeRepository;

import javassist.NotFoundException;

@Service
public class TypeServiceImpl implements TypeService {
	
	@Autowired
	TypeRepository typeRepository;
	
	@Override
	public List <ItemTypes> getAllTypes(Integer cid)
	{
		List<ItemTypes> types= new ArrayList<>();
		typeRepository.findByCategoryId(cid).forEach(types :: add);
		return types;
	}
	
	@Override
	public Optional<ItemTypes> getItemTypes(Integer id)
	{
		return typeRepository.findById(id);
	}
	
	@Override
	public void saveType(ItemTypes itemTypes)
	{
		typeRepository.save(itemTypes);
	}
	
	 
	@Override
	public void updateType(ItemTypes itemTypes)
	{
		typeRepository.save(itemTypes);
	}
	
	@Override
	public void deleteType(Integer id)
	{
		typeRepository.deleteById(id);
	}
	
	
	
	

	

}
