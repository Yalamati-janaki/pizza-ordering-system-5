package com.cg.pos.service;

import java.util.List;

import com.cg.pos.entity.StoreDetailsDTO;
import com.cg.pos.exceptions.StoreExceptions;

public interface StoreService {
	public int addStoreDetails(StoreDetailsDTO storeDetailEntity) throws StoreExceptions;

	public StoreDetailsDTO deleteStoreDetails(StoreDetailsDTO storeDetailEntity1) throws StoreExceptions;

	public StoreDetailsDTO viewStoreDetails(StoreDetailsDTO storeDetailsDTO) throws StoreExceptions;

	public StoreDetailsDTO modifyStore(StoreDetailsDTO storeDetailsDTO) throws StoreExceptions;

	public List<String> getStore(StoreDetailsDTO dto) throws StoreExceptions;

}
