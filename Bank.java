//Bank.java
import java.util.*;
import java.io.*;

public class Bank implements HasMenu{
	Admin admin = new Admin(); 
	CustomerList customers = new CustomerList();	

	public static void main(String[] args){
		Bank b = new Bank();
		b.start();
		b.saveCustomers();
	}
	public Bank(){
		this.loadCustomers();
}
	public String menu(){
		java.util.Scanner input = new java.util.Scanner(System.in);
		System.out.println();
		System.out.println("Bank Menu");
		System.out.println("0) exit");
		System.out.println("1) login as admin");
		System.out.println("2) login as customer");
		System.out.println();
		System.out.print("please enter (0-2): ");
		String response = input.nextLine();
		return response;
	}

	public void start(){
		boolean keepGoing = true;
		while (keepGoing){
			String response = menu();
 			if (response.equals("0")){
				keepGoing = false;
			}
			else if (response.equals("1")){
				if(admin.login()){
					System.out.println("login successful");
					this.adminStart();
				}
				else {
					System.out.println("login unsuccessful");
				}
			}
			else if (response.equals("2")){
				loginAsCustomer();
			}
			else {
				System.out.println("ERROR: please enter an integer (0-3)");
			}
		}			
	}

	public void loadSampleCustomers(){
		customers.add(new Customer("alice", "1111"));
		customers.add(new Customer("lucas", "1111"));
		customers.add(new Customer("andy", "1111"));
	}

	public void saveCustomers(){
		try {
			FileOutputStream fo = new FileOutputStream("customers.dat");
			ObjectOutputStream obOut = new ObjectOutputStream(fo);
			obOut.writeObject(customers);
			obOut.close();
			fo.close();
		} catch (Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public void loadCustomers(){
		try {
			FileInputStream fIn = new FileInputStream("customers.dat");
			ObjectInputStream obIn = new ObjectInputStream(fIn);
			customers = (CustomerList) obIn.readObject();
			obIn.close();
			fIn.close();
		} catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public void fullCustomerReport(){
		System.out.println();
		System.out.println("Full Customer Report");
		for (int i = 0; i < customers.size(); i++){
			customers.get(i).getReport();
		}
	}

	public void addUser(){
		java.util.Scanner input = new java.util.Scanner(System.in);
		System.out.println();
		System.out.println("Add User");
		System.out.print("Name: ");
		String username = input.nextLine();
		System.out.print("PIN: ");
		String pin = input.nextLine();
		Customer newCustomer = new Customer(username, pin);
		customers.add(newCustomer);
		System.out.println("user added");
		saveCustomers();

	}

	public void applyInterest(){
		for (int i = 0; i < customers.size(); i++){
			customers.get(i).savings.calcInterest();
		}
		System.out.println("interest applied to each savings account");
	}

	public void adminStart(){
		boolean keepGoing = true;
		while(keepGoing){
			String response = admin.menu();
			if (response.equals("0")){
				keepGoing = false;
			}
			else if (response.equals("1")){
				fullCustomerReport();
			}
			else if (response.equals("2")){
				addUser();
			}
			else if (response.equals("3")){
				applyInterest();
			}
			else {
				System.out.println("ERROR: please enter an integer (0-3)");
			}
		}
	}

	public void loginAsCustomer(){
		java.util.Scanner input = new java.util.Scanner(System.in);
		System.out.print("username: ");
		String username = input.nextLine();
		System.out.print("PIN: ");
		String pin = input.nextLine();
		Customer currentCustomer = null;
		boolean login = false;	
		for (int i = 0; i < customers.size(); i++){
			if (customers.get(i).login(username, pin)){
				System.out.println("login successful");
				login = true;
				currentCustomer = customers.get(i);
				currentCustomer.start();
			}
		}

		if (login == false){
			System.out.println("login unsuccessfull");
		}
	}	
}

class CustomerList extends ArrayList<Customer> implements Serializable {};








