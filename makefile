Bank.class: Bank.java User.class CheckingAccount.class SavingsAccount.class Customer.class Admin.class
	javac -g Bank.java
Customer.class: Customer.java User.class CheckingAccount.class SavingsAccount.class
	javac -g Customer.java

User.class: User.java HasMenu.class
	javac -g User.java

Admin.class: Admin.java User.class 
	javac -g Admin.java

CheckingAccount.class: CheckingAccount.java HasMenu.class
	javac -g CheckingAccount.java

SavingsAccount.class: SavingsAccount.java CheckingAccount.class
	javac -g SavingsAccount.java

HasMenu.class: HasMenu.java
	javac -g HasMenu.java

run: Bank.class
	java Bank

clean:
	rm *.class
