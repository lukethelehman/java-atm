//Bank.java

public class Bank implements HasMenu(){
	Admin admin = new Admin();
	ArrayList<Customer> customers = new ArrayList<>();

	public menu(){
		java.util.Scanner input = new java.util.Scanner(System.in);
		System.out.println("Bank Menu");
		System.out.println();
		System.out.println("0) exit");
		System.out.println("1) login as admin");
		System.out.println("2) login as customer");
		System.out.println();
		System.out.println("please enter (0-2): ");
		String response = input.nextLine();

