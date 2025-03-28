//Customer.java 
import java.io.*;

public class Customer extends User implements Serializable {
	CheckingAccount checking = new CheckingAccount();
	SavingsAccount savings = new SavingsAccount();
	final static long serialVersionUID = 2L;

	public static void main(String[] args){
		Customer c = new Customer();
		boolean keepGoing = true;
		while(keepGoing){
			if (c.login()){
				keepGoing = false;
			}
			else {
				continue;
			}
		}
		c.start();
		
			
	}

	public Customer(){
		username = "Alice";
		pin = "1111";
	}

	public Customer(String username, String pin){
		this.username = username;
		this.pin = pin;
	}

	public void start(){	
		boolean keepGoing = true;
		while (keepGoing){
			String response = menu();
 			if (response.equals("0")){
				keepGoing = false;
			}
			else if (response.equals("1")){
				checking.start();
			}
			else if (response.equals("2")){
				savings.start();
			}
			else if (response.equals("3")){
				changePin();
			}
			else {
				System.out.println("ERROR: please enter an integer (0-3)");
			}
		}			
	}

	public String menu(){
		java.util.Scanner input = new java.util.Scanner(System.in);
		System.out.println();
		System.out.println("Customer Menu");
		System.out.println("0) exit");
		System.out.println("1) manage checking account");
		System.out.println("2) manage savings account");
		System.out.println("3) change PIN");
		System.out.println();
		System.out.print("please enter (0-3): ");
		String response = input.nextLine();
		return response;
	}

	public void getReport(){
		System.out.print("user: " + username);
		System.out.print(", savings: $" + savings.getBalanceString());
		System.out.println(", checking: $" + checking.getBalanceString());
	}

	public void changePin(){
		java.util.Scanner input = new java.util.Scanner(System.in);
		System.out.print("new PIN: ");
		String newPin = input.nextLine();
		if (newPin.matches("^\\d{4}$")){
			pin = newPin;
			System.out.println("pin set to " + pin);
		}
		else {
			System.out.println("ERROR: pin must be numeric and 4 digits");
			pin = "0000";
			System.out.println("pin set to " + pin);
		}
	}
}
