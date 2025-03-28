//Bank.java

public class Bank implements HasMenu{
	Admin admin = new Admin();
	java.util.ArrayList<Customer> customers = new java.util.ArrayList<>();
	
	public static void main(String[] args){
		Bank b = new Bank();
		b.loadSampleCustomers();
		b.start();
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
					System.out.println("login successfull");
					this.adminStart();
				}
				else {
					System.out.println("login unsuccessfull");
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
				System.out.println("login successfull");
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







