package com.cg.pos.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.pos.entity.StoreDetailsDTO;
import com.cg.pos.exceptions.StoreExceptions;
import com.cg.pos.service.StoreService;
import com.cg.pos.utility.ExceptionMessages;

@RestController
//@RequestMapping(value = "/store")
public class StoreController {
	@Autowired
	private StoreService service;

	Logger log=LoggerFactory.getLogger(StoreController.class);
	public void setService(StoreService service) {
		this.service = service;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
	public int addStore(@Valid @RequestBody StoreDetailsDTO storeDetailsDTO) throws StoreExceptions {
		log.info("Store :- Add Method started");
		int addResult;
		addResult = service.addStoreDetails(storeDetailsDTO);
		if (addResult != 1) {
			throw new StoreExceptions(ExceptionMessages.MESSAGE1);
		}
		log.info("Store Add method CLOSED");
		return addResult;
	}

	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET, produces = "application/json")
	public StoreDetailsDTO viewStore(@Valid @PathVariable("id") int id) throws StoreExceptions {
		log.info("Store :- view Method started");
		StoreDetailsDTO viewResult = null;
		StoreDetailsDTO storeDetailsDTO = new StoreDetailsDTO();
		storeDetailsDTO.setStoreId(id);
		viewResult = service.viewStoreDetails(storeDetailsDTO);
		if (viewResult == null) {
			throw new StoreExceptions(ExceptionMessages.STORE_ID_NOT_EXISTS);
		}
		log.info("Store :- view Method Closed");
		return viewResult;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.PUT, headers = "Accept=application/json")
	public StoreDetailsDTO delete(@Valid @RequestBody StoreDetailsDTO storeDetailsDTO) throws StoreExceptions {
		log.info("Store :- delete Method started");
		StoreDetailsDTO deleteResult = null;
		deleteResult = service.deleteStoreDetails(storeDetailsDTO);
		if (deleteResult == null) {
			throw new StoreExceptions(ExceptionMessages.STORE_ID_NOT_EXISTS);
		}
		log.info("Store :- delete Method closed");
		return deleteResult;
	}

	@RequestMapping(value = "/modify", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public StoreDetailsDTO modifyName(@Valid @RequestBody StoreDetailsDTO dto) throws StoreExceptions {
		log.info("Store :- Modify Method started");
		StoreDetailsDTO detailsDTO = new StoreDetailsDTO();
		detailsDTO = service.modifyStore(dto);
		if (detailsDTO == null) {
			throw new StoreExceptions(ExceptionMessages.STORE_ID_NOT_EXISTS);
		}
		log.info("Store :- Modify Method closed");
		return detailsDTO;
	}
	@RequestMapping(value = "/get", method = RequestMethod.PUT, consumes = "application/json")
	public String getStore(@Valid @RequestBody StoreDetailsDTO dto) throws StoreExceptions {
		List<String> store=service.getStore(dto); 
		int storeCount=store.size();
		if(dto==null) {
			throw new StoreExceptions(ExceptionMessages.INVALID_ADDRESS);
		}
		return storeCount+" "+store;
		
	}
}
