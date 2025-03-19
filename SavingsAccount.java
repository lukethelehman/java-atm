//SavingsAccount.java

public class SavingsAccount extends CheckingAccount {
	double interestRate = 0d;

	public static void main(String[] args){
		SavingsAccount s = new SavingsAccount();
		s.setBalance(100);
		s.setInterestRate(.05);
		double interest = s.calcInterest();
		System.out.println(interest);

	}

	public double calcInterest() {
		double interest = interestRate * balance;
		return interest;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public double getInterestRate(){
		return interestRate;
	}
}

