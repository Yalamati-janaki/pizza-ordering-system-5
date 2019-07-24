package com.cg.pos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import com.cg.pos.utility.ExceptionMessages;

/**
 * DTO class for store details
 * 
 * @author trainee
 *
 */
@Entity
@Table(name = "store1")
public class StoreDetailsDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sid")
	@SequenceGenerator(name = "sid", sequenceName = "sid", initialValue = 000123, allocationSize = 1)
	@Column(name = "storeid")
	private int storeId;
	@Column(name="storename")
	@Pattern(regexp = "^[a-zA-Z]*$",message = ExceptionMessages.INVALID_NAME)
	private String storeName;
	@Column(name="storeaddress")
	@Pattern(regexp = "[A-Za-z0-9'\\.\\-\\s\\,]*",message=ExceptionMessages.INVALID_ADDRESS)
	private String storeAddress;
	@Column(name="storecontact")
	@Pattern(regexp = "[1-9][0-9]{9}",message = ExceptionMessages.INVALID_CONTACT)
	private String storeContact;
	@Column(name="ownername")
	@Pattern(regexp = "^[a-zA-Z]*$",message = ExceptionMessages.INVALID_NAME)
	private String ownerName;

	/**
	 * default constructor
	 */
	public StoreDetailsDTO() {

	}

	/**
	 * Parameterized constructor
	 * 
	 * @param storeId
	 * @param storeName
	 * @param storeAddress
	 * @param storeContact
	 * @param ownerName
	 */
	public StoreDetailsDTO(int storeId, String storeName, String storeAddress, String storeContact, String ownerName) {
		super();
		this.storeId = storeId;
		this.storeName = storeName;
		this.storeAddress = storeAddress;
		this.storeContact = storeContact;
		this.ownerName = ownerName;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public String getStoreContact() {
		return storeContact;
	}

	public void setStoreContact(String storeContact) {
		this.storeContact = storeContact;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	@Override
	public String toString() {
		return '\n' + "storeId=" + storeId + '\n' + "storeName=" + storeName + '\n' + "storeAddress=" + storeAddress
				+ '\n' + "storeContact=" + storeContact + '\n' + "ownerName=" + ownerName + '\n';
	}

}
