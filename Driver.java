package AnAddressBook;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * The method to let the program start.
 * @author Qin Weiwei
 * @version 2.0
 */

public class Driver {
		public static void main(String[] args) throws FileNotFoundException,TreeException {
			ArrayList<String> list = new ArrayList<>();
			Scanner keyboard = new Scanner(System.in);
			File file = new File("PersonRecord.txt");
		
			Scanner start = new Scanner(file);
			String line = null;
			while (start.hasNext()) {
				line = start.nextLine();
				list.add(line);
			}
			
			Address[] address = new Address[list.size()];
			PersonRecord[] person = new PersonRecord[list.size()];
			for (int i = 0; i < list.size(); i++) {
				ArrayList<String> information = new ArrayList<>();
				StringTokenizer st = new StringTokenizer(list.get(i),",");
				while (st.hasMoreTokens()) {
					information.add(st.nextToken());
				}			
				address[i] = new Address(information.get(1),information.get(2),information.get(3),information.get(4));
				person[i] = new PersonRecord(information.get(0), address[i], information.get(5));
			}
			
			AddressBook Address = new AddressBook();
			
			for(int i = 0;i < list.size();i ++) {
				if(Address.add(person[i])) {
				}
			}
			System.out.println("Retrieve all person in the address book:");
			Address.print();
			System.out.println("--------------------------------------------------------");
			
			String name = "";
		    String street = "";
		    String city = "";
		    String state = "";
		    String zipcode = "";
			String phone = "";
			Address AnAddress = null;
			PersonRecord p = null;
			
		    System.out.println("Add a record in the address book.");
		    System.out.println("Input the name you want to add: ");
		    String newname = keyboard.nextLine();
			System.out.println("Input the street you want to add: ");
			String newstreet = keyboard.nextLine();
			System.out.println("Input the city you want to add: ");
			String newcity = keyboard.nextLine();
			System.out.println("Input the state you want to add: ");
			String newstate = keyboard.nextLine();
			System.out.println("Input the zip you want to add: ");
			String newzipcode = keyboard.nextLine();
			System.out.println("Input the phone number you want to add: ");
			String newphone = keyboard.nextLine();
			System.out.println("-------------------------END----------------------------");
			System.out.println("After input a record:");
			AnAddress = new Address(newstreet, newcity, newstate, zipcode);
			p = new PersonRecord(name,AnAddress,phone);
			Address.add(p);
			Address.print();
			System.out.println("--------------------------------------------------------");
			
			System.out.println("Input the name you want to delete:");
			String delete = keyboard.nextLine();
			if(Address.delete(delete)) {
				System.out.println("HAVE DELETED.");
			}
			else {
				System.out.println("HAVE NOT DELETED.");
			}
			System.out.println("After delete a record:");
			Address.print();
			System.out.println("--------------------------------------------------------");
			
			System.out.println("Change the record.");
			System.out.println("Input the name you want to change:");
			String newName = keyboard.nextLine();
			System.out.println("Input the street you want to change:");
			String newStreet = keyboard.nextLine();
			System.out.println("Input the city you want to change:");
			String newCity=keyboard.nextLine();
			System.out.println("Input the state you want to change:");
			String newState=keyboard.nextLine();
			System.out.println("Input the zip you want to change:");
			String newZip=keyboard.nextLine();
			System.out.println("Input the phone number you want to change:");
			String newPhone=keyboard.nextLine();
			
			Address newAddress=new Address(newStreet,newCity,newState,newZip);
			PersonRecord replace=new PersonRecord(newName,newAddress,newPhone);
			Address.change(newName, replace);
			Address.print();
		}
}

/*package AnAddressBook;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import AnAddressBook.*;

*//**
 * The method to let the program start.
 * @author Qin Weiwei
 * @version 2.0
 *//*

public class Driver {
	public static void main(String[] args) throws FileNotFoundException,IOException {
		ArrayList<PersonRecord> list = new ArrayList();
		Scanner in = new Scanner(System.in);
		
		Address[] address = new Address[list.toString().length()];
	    PersonRecord[] person = new PersonRecord[list.toString().length()];
	    ArrayList<String> record = new ArrayList<>();
	    
	    for(int i = 0;i < list.toString().length();i ++) {
	    	StringTokenizer line = new StringTokenizer(list.toString().substring(i),",");
	    	while(line.hasMoreTokens()) {
	    		record.add(line.nextToken());
	    	}
	    	//address[i] = new Address(record.get(1),record.get(2),record.get(3),record.get(4));
	    	//person[i] = new PersonRecord(record.get(0),address[i],record.get(5));
	    }
	    
	    
	    AddressBook ad = new AddressBook();
	    PersonRecord p = new PersonRecord(null, null, null);
    	
	    String name = "";
	    String street = "";
	    String city = "";
	    String state = "";
	    String zipcode = "";
		String phone = "";
		Address Address = null;
		
		System.out.println("Retrieve all person in the address book.");
		ReadFile();
		System.out.println("--------------------------------------------------------");
		
	    System.out.println("Add a record in the address book.");
	    System.out.println("Input the name you want to add: ");
	    String newname = in.nextLine();
		System.out.println("Input the street you want to add: ");
		String newstreet = in.nextLine();
		System.out.println("Input the city you want to add: ");
		String newcity = in.nextLine();
		System.out.println("Input the state you want to add: ");
		String newstate = in.nextLine();
		System.out.println("Input the zip you want to add: ");
		String newzipcode = in.nextLine();
		System.out.println("Input the phone number you want to add: ");
		String newphone = in.nextLine();
		System.out.println("-------------------------END----------------------------");
		
		Address = new Address(newstreet, newcity, newstate, zipcode);
		p = new PersonRecord(name,Address,phone);
		
		list = retrieve(p);
		saveToFile(list);
		ReadFile();
		System.out.println("--------------------------------------------------------");
	   
		System.out.println("Delete the record.");
		System.out.println("Input the name you want to delete:");
		String delete = in.nextLine();
		if(ad.delete(delete)) {
			System.out.println("HAVE DELETED.");
		}else {
			System.out.println("HAVE NOT DELETED.");
		}
	}

	public static ArrayList<PersonRecord> ReadFile(){
			StringBuffer str = new StringBuffer("");
			File file = new File("PersonRecord.txt");
			try {
				  FileReader fr = new FileReader(file);
				  int ch = 0;
				  while((ch = fr.read()) != -1 )
				  {
				   System.out.print((char)ch + ""); 
				  }
				  System.out.println("");
				  fr.close();
				 } catch (IOException e) {
				  e.printStackTrace();
				  System.out.println("File reader is wrong.");
				 }
			return null;
	}
	
	public static void saveToFile(ArrayList<PersonRecord> list){
		try
		{
			FileWriter file = new FileWriter("PersonRecord.txt");
			PrintWriter out = new PrintWriter(file);
			//String[] parts = p.toString().split("");
			
			for(int i = 0;i < list.toString().length();i ++)
			{
				//String str = p.getPersonRecord();
				//file.write(str);
				file.write(getInformation(list.get(i)));
			}
			if(file != null)
			{
				file.close();
			}
			
		    // 3. closing the output channel and the file
		    out.close();
		    file.close();

			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	    
	}
	
	public static void printPerson(PersonRecord p)
	{
		System.out.println("The record is: " + p.getPersonRecord());
	}
	
	public static String getInformation(PersonRecord p)
	{
		return p.getName() + "," + p.getAddress() + "," + p.getPhonenumber();
	}
	
	
}*/