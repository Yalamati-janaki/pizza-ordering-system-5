package com.cg.pos.utility;

import com.cg.pos.exceptions.StoreExceptions;

public class ExceptionMessages {

	public static final String MESSAGE1 = "store name Exception";
	public static final String STORE_NAME_EXISTS = "Store name already exists...";
	public static final String STORE_NAME_NOT_EXISTS = "Store ID doesn't exist";
	public static final String STORE_ID_NOT_EXISTS = "Store ID doesn't exist";
	public static final String DATA_BASE_EXCEPTION = "Something went wrong in database...:(";
	public static final String INVALID_NAME = "Enter the name in alphabets within the limit of 15.... ";
	public static final String INVALID_ADDRESS = "Give the proper address.";
	public static final String INVALID_CONTACT = "Enter contact number only in numbers.....";
	public static final String INVALID_PIN = "Enter only pin of 6 digits";

	public static String isValidPin(String address) throws StoreExceptions {
		if (!address.matches("[0-9]{6}")) {
			throw new StoreExceptions(ExceptionMessages.INVALID_PIN);
		}

		return "1";
	}
}
