package com.cg.pos.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.stereotype.Repository;

import com.cg.pos.entity.StoreDetailsDTO;
import com.cg.pos.exceptions.StoreExceptions;
import com.cg.pos.utility.ExceptionMessages;

/**
 * class for adding, viewing, deleting and modifying the store details in
 * database.
 * 
 * @author trainee
 *
 */
@Repository
@Transactional
public class StoreDaoImpl implements StoreDao {
	/**
	 * method for ADDING the store details to database.
	 * 
	 * @throws StoreExceptions
	 * @throws SQLException
	 */
	@PersistenceContext
	private EntityManager entityManager;

	public int addStore(StoreDetailsDTO storeDetailsDTO) {
		entityManager.persist(storeDetailsDTO);
		return 1;
	}

	/**
	 * method for VIEWING store details from database.
	 * 
	 * @throws StoreExceptions
	 * @throws SQLException
	 */

	public StoreDetailsDTO viewStore(StoreDetailsDTO storeDetailsDTO) {
		StoreDetailsDTO viewStore = entityManager.find(StoreDetailsDTO.class, storeDetailsDTO.getStoreId());
		return viewStore;
	}

	public StoreDetailsDTO deleteStore(StoreDetailsDTO storeDetailEntity1) {
		StoreDetailsDTO result;
		result = entityManager.find(StoreDetailsDTO.class, storeDetailEntity1.getStoreId());
		if (result != null) {
			entityManager.remove(result);
		} else {
			result = null;
		}
		return result;
	}

	public StoreDetailsDTO modifyStore(StoreDetailsDTO storeDetailsDTO) {
		StoreDetailsDTO detailsDTO;
		detailsDTO = entityManager.find(StoreDetailsDTO.class, storeDetailsDTO.getStoreId());
		if(detailsDTO==null) {
			detailsDTO=null;
		}
		else {
			if (storeDetailsDTO.getStoreName() != null) {
				detailsDTO.setStoreName(storeDetailsDTO.getStoreName());
			}
			if (storeDetailsDTO.getStoreAddress() != null) {
				detailsDTO.setStoreAddress(storeDetailsDTO.getStoreAddress());
			}
			if (storeDetailsDTO.getStoreContact() != null) {
				detailsDTO.setStoreContact(storeDetailsDTO.getStoreContact());
			}
			if (storeDetailsDTO.getOwnerName() != null) {
				detailsDTO.setOwnerName(storeDetailsDTO.getOwnerName());
			}

		}
		return detailsDTO;
	}

	@Override
	public List<String> getStore(StoreDetailsDTO dto) {
		String pattern="%"+dto.getStoreAddress()+"%";
		TypedQuery<String> query= entityManager.createQuery("select s.storeName from StoreDetailsDTO s where s.storeAddress LIKE :saddress",String.class);														
		query.setParameter("saddress", pattern);
		List<String> store=query.getResultList();
		return store;
	}
}
