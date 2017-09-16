package com.boot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;

@RestController
@RequestMapping("/v1")
public class ShipwreckController {

	@Autowired
	private ShipwreckRepository shipwreckRepository;
	
	@RequestMapping(value="/shipwrecks",method=RequestMethod.GET)
	public List<Shipwreck> list(){
		return shipwreckRepository.findAll();
	}
	
	@RequestMapping(value="/shipwrecks",method=RequestMethod.POST)
	public Shipwreck create(@RequestBody Shipwreck wreck){
		return shipwreckRepository.saveAndFlush(wreck);
	}
	
	@RequestMapping(value="/shipwrecks/{id}",method=RequestMethod.GET)
	public Shipwreck get(@PathVariable Long id){
		Optional<Shipwreck> shipwreck = Optional.ofNullable(shipwreckRepository.findOne(id));
		return shipwreck.get();
	}
	
	@RequestMapping(value="/shipwrecks/{id}",method=RequestMethod.PUT)
	public Shipwreck update(@PathVariable Long id,@RequestBody Shipwreck wreck){
		Shipwreck existingShipwreck = shipwreckRepository.findOne(id);
		BeanUtils.copyProperties(wreck, existingShipwreck);
		return shipwreckRepository.saveAndFlush(existingShipwreck);
	}
	
	@RequestMapping(value="/shipwrecks/{id}",method=RequestMethod.DELETE)
	public Shipwreck delete(@PathVariable Long id){
		Shipwreck existingShipwreck = shipwreckRepository.findOne(id);
		shipwreckRepository.delete(id);
		return existingShipwreck;
	}
}
