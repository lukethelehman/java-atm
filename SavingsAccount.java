//SavingsAccount.java
import java.io.*;

public class SavingsAccount extends CheckingAccount implements Serializable {
	double interestRate = .05d;

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

