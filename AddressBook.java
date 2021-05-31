package AnAddressBook;

/**
 * An address book.
 * @author Qin Weiwei
 * @version 2.0
 */

import AnAddressBook.TreeNode;
import AnAddressBook.BinarySearchTree;
import java.io.*;
import java.util.Scanner;

public class AddressBook<T> implements AddressBookInterface{

	/**
	 * The tree of the Binary Search Tree
	 */
	private BinarySearchTree<String> tree;

	/**
	 * A constructor of AddressBook.
	 */
	public AddressBook() {
		this.tree = new BinarySearchTree<String>();
	}

	/**
	 * Add a record.
	 * @param person A person variable
	 * @return Whether have add the record
	 * @throws IOException
	 */
	public boolean add(PersonRecord person) {
		return this.tree.insert(person.getName(), person.getPersonRecord());
	}

	/**
	 * Delete the record.
	 * @param key A string variable
	 * @return Whether have delete
	 * @throws IOException
	 */
	public boolean delete(String key) throws TreeException {
		return this.tree.delete(key);
	}

	/**
	  * Change the record.
	  * @param name A string variable
	  * @param person A person variable
	  * @throws TreeException
	  */
	public void change(String name, PersonRecord person) throws TreeException {
		if (tree.delete(name)) {
			tree.insert(person.getName(), person.getPersonRecord());
		} else {
			System.out.println("not find");
		}
	}

	/**
	 * Retrieve the person record.
	 */
	public boolean retrieve(String key) throws TreeException {
		return tree.search(key);
	} 
	
	/**
	 * Print the person record.
	 */
	public void print() {
		tree.print(tree);
	}
}
	/**
	 * A constructor of AddressBook.
	 *//*
	public AddressBook() {
		this.tree = tree;
	}
	public void Menu() {
		System.out.println("--------------menu------------");
		System.out.println("1.Retrieve by name.");
		System.out.println("2.Add message.");
		System.out.println("3.Delete message.");
		System.out.println("4.Change message.");
		System.out.println("0.End.");
		
		System.out.println("Input your choice by the serial number");
		
		Scanner in = new Scanner(System.in);
		String choice = in.toString();

		switch(choice) {
		case "0":
			break;
		case "1":
			try {
				retrieve();
			} catch (IOException e) {
				e.printStackTrace();
			}
            break;
        case "2":
        	try {
				add();
			} catch (IOException e) {
				e.printStackTrace();
			}
            break;
        case "3":
        	try {
				delete();
			} catch (IOException e) {
				e.printStackTrace();
			}
            break;
        case "4":
        	try {
				change();
			} catch (IOException e) {
				e.printStackTrace();
			}
            break;
        default:
            System.out.println("The input is wrong,plese input again.");
		}
	}

	public AddressBook(TreeNode<T> name) {
	    tree = new BinarySearchTree(name);
	}

	*//**
	 * Add a record.
	 * @param person A person variable
	 * @return Whether have add the record
	 * @throws IOException
	 *//*
	public void add(TreeNode<T> key,T newItem) throws IOException{
		tree.insert(key,newItem);
	}
		Scanner in = new Scanner(System.in);
		tree = new BinarySearchTree();
		System.out.print("Input firstname:");
		firstname = in.nextLine().replace(" ","");
		System.out.print("Input lastname:");
		lastname = in.nextLine().replace(" ","");
		System.out.print("Input address:");
		address = in.nextLine().replace(" ","");
		System.out.print("Input city:");
		city = in.nextLine().replace(" ","");
		System.out.print("Input state:");
		state = in.nextLine().replace(" ","");
		System.out.print("Input zip:");
		zip = in.nextLine().replace(" ","");
		System.out.print("Input phone:");
		phone = in.nextLine().replace(" ","");
		
		ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("PersonRecord.txt"));
            if (ois != null) {
            	tree = (BinarySearchTree) ois.readObject();
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
        } finally {
        try {
            if (ois != null)
                ois.close();
        } catch (IOException e) {
        }
        if (tree == null) {
            tree = new BinarySearchTree();
        }
        }
	
	*//**
	 * Delete the record.
	 * @param person A string variable
	 * @return Whether have delete
	 * @throws IOException
	 *//*
	 public boolean delete(String person) throws IOException{ 
		 System.out.println("Input the name of the person who you want to delete:");
		 
		 return tree.delete(person);
	 }
	   Scanner in = new Scanner(System.in);
  	   System.out.println("Input the firstname you want to delete：");
  	   String name = in.toString(); 
  	   if(name.isEmpty()) {
  		   System.out.println("It is empty.");
  	   }
  	   if(name.compareTo(firstname) < 0) {
  		   System.out.println("Doesn't have the person.");
  	   }
  	   AddressBook ab = new AddressBook();
  	   ab.retrieve();
  	   tree.delete(ab);
  	   return name;
	
	 *//**
	  * Change the record.
	  * @param a A string variable
	  * @param b A person variable
	  * @throws TreeException
	  *//*
	public void change(TreeNode<T> key,T newItem) throws TreeException{
		if(!tree.delete(newItem)) {
			tree.insert(key,newItem);
		}
		else {
			System.out.println("Don't have the person.");
		}
	}
		Scanner in = new Scanner(System.in);
		String name = in.nextLine();
		System.out.print("Input firstname:");
		retrieve();
		   if(name.equals(firstname)) {
			   System.out.println("Input the record again:"); 
			   System.out.print("Input address:");
			   address = in.nextLine();
			   System.out.print("Input city:");
			   city = in.nextLine(); 
			   System.out.print("Input state:");
			   state = in.nextLine(); 
			   System.out.print("Input zip:");
			   zip = in.nextLine(); 
			   System.out.print("Input phone:");
			   phone = in.nextLine();
      }
       System.out.println("False");
	}
	
	*//**
	 * Output the person record.
	 *//*
	public boolean retrieve(TreeNode<T> n,T k) throws TreeException {
		return tree.search(n,k);
	}
		tree = new BinarySearchTree();
		System.out.println("Input the name: ");
		Scanner in = new Scanner(System.in);
		String name = in.nextLine();
		if(tree == null) {
			return;
		}
			for (TreeIterator<T> node = tree.iterator();node.hasNext();) {
	            T ab = node.next();
	            System.out.println(name);
				tree.iterator();
	        }
	        return;
		}
}*/