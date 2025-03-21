//Customer.java 

public class Customer extends User {
	java.util.Scanner input = new java.util.Scanner(System.in);
	CheckingAccount checking = new CheckingAccount();
	SavingsAccount savings = new SavingsAccount();

	public static void main(String[] args){
		Customer c = new Customer();
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
		String response = menu();
		boolean keepGoing = true;
		while (keepGoing){
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
		System.out.println("Customer Menu");
		System.out.println();
		System.out.println("0) exit");
		System.out.println("1) manage checking account");
		System.out.println("2) manage savings account");
		System.out.println("3) change PIN");
		System.out.println();
		System.out.println("please enter (0-3): ");
		String response = input.nextLine();
		return response;
	}

	public String getReport(){
		String test = "test";
		return test;
	}

	public void changePin(){
		System.out.println("test");
	}
}
