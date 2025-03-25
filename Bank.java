//Bank.java

public class Bank implements HasMenu{
	Admin admin = new Admin();
	java.util.ArrayList<Customer> customers = new java.util.ArrayList<>();
	
	public static void main(String[] args){
		Bank b = new Bank();
		b.start();
	}

	public String menu(){
		java.util.Scanner input = new java.util.Scanner(System.in);
		System.out.println("Bank Menu");
		System.out.println();
		System.out.println("0) exit");
		System.out.println("1) login as admin");
		System.out.println("2) login as customer");
		System.out.println();
		System.out.println("please enter (0-2): ");
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
				System.out.println("login as admin");
			}
			else if (response.equals("2")){
				System.out.println("login as customer");
			}
			else {
				System.out.println("ERROR: please enter an integer (0-3)");
			}
		}			
	}
}		







