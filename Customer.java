//Customer.java 

public class Customer extends User {
	java.util.Scanner input = new java.util.Scanner(System.in);
	CheckingAccount checking = new CheckingAccount();
	SavingsAccount savings = new SavingsAccount();

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
		System.out.println("Customer Menu");
		System.out.println();
		System.out.println("0) exit");
		System.out.println("1) manage checking account");
		System.out.println("2) manage savings account");
		System.out.println("3) change PIN");
		System.out.println();
		System.out.print("please enter (0-3): ");
		String response = input.nextLine();
		return response;
	}

	public String getReport(){
		System.out.println("username: " + username);
		System.out.println("pin: " + pin);
		System.out.println("Savings: " + savings.getBalance());
		System.out.println("Checking: " + checking.getBalance());
		return username;
	}

	public void changePin(){
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
