//Admin.java

public class Admin extends User {
	
	public Admin(){
		username = "admin";
		pin = "0000";
	}

	public String menu(){
		java.util.Scanner input = new java.util.Scanner(System.in);
		System.out.println();
		System.out.println("Admin Menu");
		System.out.println("0) exit");
		System.out.println("1) full customer report");
		System.out.println("2) add user");
		System.out.println("3) apply interest to savings accounts");
		System.out.println();
		System.out.print("please enter (0-3): ");
		String response = input.nextLine();
		return response;
	}

	public void start(){

	}

	public void getReport(){
		System.out.println("username: " + username);
		System.out.println("PIN: " + pin);
	}
}
