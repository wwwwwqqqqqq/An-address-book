package AnAddressBook;

/**
 * An Address class
 * @author Qin Weiwei
 * @version 2.0
 */

public class Address {
	/**
	 * The street of the person.
	 */
	private String street;
	/**
	 * The city of the person.
	 */
	private String city;
	/**
	 * The state of the person.
	 */
	private String state;
	/**
	 * The zipcode of the person.
	 */
	private String zipcode;
	
	/**
	 * Construct the address of street,city,state,zipcode.
	 * @param street the street
	 * @param city the city
	 * @param state the state
	 * @param zipcode the zip code
	 */
	public Address(String street,String city,String state,String zipcode) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}
	
	/**
	 * Return the street.
	 * @return the street
	 */
	public String getStreet() {
		return this.street;
	}
	
	/**
	 * Return the city.
	 * @return the city
	 */
	public String getCity() {
		return this.city;
	}
	
	/**
	 * Return the state.
	 * @return the state
	 */
	public String getState() {
		return this.state;
	}
	
	/**
	 * Return the zip code.
	 * @return the zip code
	 */
	public String getZipcode() {
		return this.zipcode;
	}
}
