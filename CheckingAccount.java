//CheckingAccount.java

public class CheckingAccount implements HasMenu{
	java.util.Scanner input = new java.util.Scanner(System.in);
	double balance = 0.00;

	public CheckingAccount(){
		balance = 0.00;
	}

	public CheckingAccount(double balance){
		this.balance = balance;
	}

	public static void main(String[] args){
		CheckingAccount c = new CheckingAccount();
		c.start();
	}

	public String menu(){
		System.out.println("0) exit");
		System.out.println("1) check balance");
		System.out.println("2) make a deposit");
		System.out.println("3) make a withdrawal");
		System.out.println();
		System.out.print("please enter (0-3): ");
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
				checkBalance();
			}
			else if (response.equals("2")){
				makeDeposit();
			}
			else if (response.equals("3")){
				makeWithdrawal();
			}
			else {
				System.out.println("ERROR: please enter an integer (0-3)");
			}
		}					
	}
	public double getBalance(){
		return balance;
	}

	public void setBalance(double balance){
		this.balance = balance;
	}
		
	public String getBalanceString(){
		String sBalance = String.format("%.2f", balance);
		return sBalance;
	}

	public void checkBalance(){
		System.out.println("checking balance...");
		System.out.println("current balance: $" + getBalance());
		System.out.println();
	}

	public void makeDeposit(){
		System.out.println("making deposit...");
		System.out.print("amount to deposit: ");
		double deposit = getDouble();
		setBalance(deposit);
		System.out.println("new balance: $" + getBalance());
		System.out.println();
	}
	public void makeWithdrawal(){
		System.out.println("makeWithdrawal");
	}
	private double getDouble(){
		String sResult = input.nextLine();
		double result = 0d;
		try {
			result = Double.parseDouble (sResult);
			return result;
		}
		catch (NumberFormatException e) {
			System.out.println("ERROR: Input must be a number. No letters or symbols allowed.");
		}
		return result;
	}
}
