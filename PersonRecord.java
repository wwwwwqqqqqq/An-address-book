package AnAddressBook;

/**
 * A personrecord to store name,address,number.
 * @author Qin Weiwei
 * @version 2.0
 */

public class PersonRecord {
	/**
	 * The name of the person.
	 */
	private String name;
	/**
	 * The address of the person.
	 */
	private Address address;
	
	/**
	 * The phone number of the person.
	 */
	private String phone;
	/**
	 * Creates a person record with name,address,phone.
	 * @param name the name
	 * @param address the address
	 * @param phone the phone number
	 */
	public PersonRecord(String name,Address address,String phone) {
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	/**
	 * Get the name.
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Return the street
	 * @return the street
	 */
	public String getAddress() {
		return this.address.getStreet()+this.address.getCity()+this.address.getState()+this.address.getZipcode();
	}

	/**
	 * Get the phone number.
	 * @return the phone number
	 */
	public String getPhonenumber() {
		return this.phone;
	}
	
	/**
	 * Get the information.
	 * @return all the information
	 */
	public String getPersonRecord() {
		return this.getName() + this.getAddress() + this.getPhonenumber();
	}
}
