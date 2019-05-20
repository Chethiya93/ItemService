package com.group_4.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.group_4.modal.Category;
import com.group_4.modal.ItemTypes;
import com.group_4.service.TypeService;

@RestController
@RequestMapping(value="/typecloud")
public class TypeController {
	
	@Autowired
	TypeService typeService;
	
	
	@RequestMapping(value="category/{cid}/itemtype", method=RequestMethod.POST)
	public void saveType( @RequestBody ItemTypes itemTypes,@PathVariable Integer cid )
	{
		itemTypes.setCategory(new Category (cid, ""));
		typeService.saveType(itemTypes);
	}
	
	@RequestMapping(value="category/{cid}/itemtype", method=RequestMethod.GET)
	public List<ItemTypes> getAllTypes (@PathVariable Integer cid)
	{
		return typeService.getAllTypes(cid);
	}
	
	
	@RequestMapping(value="itemtype/{id}", method=RequestMethod.GET)	
	public Optional<ItemTypes> getItemType(@PathVariable Integer id)
	{
		return typeService.getItemTypes(id);
	}
	
	@RequestMapping(value="category/{cid}/itemtype/{id}", method=RequestMethod.PUT)
	public void updateType( @RequestBody ItemTypes itemTypes,@PathVariable Integer cid, Integer id )
	{
		itemTypes.setCategory(new Category (cid, ""));
		typeService.updateType(itemTypes);
	}
	
	@RequestMapping(value="category/{cid}/itemtype/{id}", method=RequestMethod.DELETE)
	public void deleteType( @PathVariable Integer id )
	{
		typeService.deleteType(id);
	}
}
