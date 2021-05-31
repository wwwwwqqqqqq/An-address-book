package AnAddressBook;

/**
 * Represents an exception thrown from a tree when operations fail.
 * @author Qin Weiwei
 * @version 2.0
 */

import java.lang.RuntimeException;

public class TreeException extends RuntimeException{
  /**
   * Construct an exception object with a message.
   * @param message A reference to an exception message
   */
	public TreeException(String message) {
		super(message);
	}
}
