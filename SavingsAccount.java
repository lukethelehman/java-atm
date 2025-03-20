//SavingsAccount.java

public class SavingsAccount extends CheckingAccount {
	double interestRate = 0d;

	public static void main(String[] args){
		SavingsAccount s = new SavingsAccount();
		s.setBalance(100);
		s.setInterestRate(.05);
		s.calcInterest();
		System.out.println(s.balance);

	}

	public void calcInterest() {
		double interest = interestRate * balance;
		balance = balance + interest;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public double getInterestRate(){
		return interestRate;
	}
}

