package AnAddressBook;

/**
 *  Specifications on the design of AddressBook. 
 * @author Qin Weiwei
 * @version 2.0
 */

import java.io.IOException;

public interface AddressBookInterface<T> {
	/**
	 * Add a record.
	 * @param person A person variable
	 * @return Whether have add the record
	 * @throws IOException
	 */
	public boolean add(PersonRecord person);
	
	/**
	 * Delete the record.
	 * @param key A string variable
	 * @return Whether have delete
	 * @throws IOException
	 */
	public boolean delete(String key) throws TreeException;
	
	/**
	  * Change the record.
	  * @param name A string variable
	  * @param person A person variable
	  * @throws TreeException
	  */
	public void change(String name, PersonRecord person) throws TreeException;
	
	/**
	 * Output the person record.
	 */
	public boolean retrieve(String key) throws TreeException;
	
	/**
	 * Print the information
	 */
	public void print();
}
