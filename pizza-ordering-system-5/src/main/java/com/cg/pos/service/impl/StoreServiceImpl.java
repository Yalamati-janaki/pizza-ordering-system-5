package com.cg.pos.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.pos.dao.StoreDao;
import com.cg.pos.entity.StoreDetailsDTO;
import com.cg.pos.exceptions.StoreExceptions;
import com.cg.pos.service.StoreService;
import com.cg.pos.utility.ExceptionMessages;

/**
 * class for adding, deleting, viewing, modifying the store details.
 * 
 * @author trainee
 *
 */
@Service
public class StoreServiceImpl implements StoreService {
	@Autowired
	private StoreDao storeDao;

	public void setStoreDao(StoreDao storeDao) {
		this.storeDao = storeDao;
	}

	/**
	 * method for adding store details to list.
	 * 
	 * @throws StoreExceptions
	 * @throws SQLException
	 */
	public int addStoreDetails(StoreDetailsDTO storeDetailEntity) throws StoreExceptions {

		int addDetails = 0;
		addDetails = storeDao.addStore(storeDetailEntity);
		return addDetails;
	}

	/**
	 * method for viewing store details.
	 * 
	 * @throws InValidStoreNameException
	 * @throws StoreExceptions
	 * @throws SQLException
	 */

	public StoreDetailsDTO viewStoreDetails(StoreDetailsDTO storeDetailsDTO) throws StoreExceptions {
		StoreDetailsDTO viewDetails = storeDao.viewStore(storeDetailsDTO);
		return viewDetails;
	}

	public StoreDetailsDTO modifyStore(StoreDetailsDTO storeDetailsDTO) throws StoreExceptions {

		StoreDetailsDTO modifyDetails = storeDao.modifyStore(storeDetailsDTO);
		return modifyDetails;
	}

	public StoreDetailsDTO deleteStoreDetails(StoreDetailsDTO storeDetailEntity1) throws StoreExceptions {
		StoreDetailsDTO deleteDetails = storeDao.deleteStore(storeDetailEntity1);
		return deleteDetails;
	}

	@Override
	public List<String> getStore(StoreDetailsDTO dto) throws StoreExceptions {
		String address=ExceptionMessages.isValidPin(dto.getStoreAddress());
		List<String> store = null;
		if(address.equals("1")) {
			store=storeDao.getStore(dto);
		}
		return store;
	}

}
