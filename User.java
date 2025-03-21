//User.java 

public abstract class User implements HasMenu {
	String username;
	String pin;

	public boolean login() {
		java.util.Scanner input = new java.util.Scanner(System.in);
		System.out.print("username: ");
		String username = input.nextLine();
		System.out.print("PIN: ");
		String pin = input.nextLine();

		if (username.equals(this.username) && pin.equals(this.pin)){
			System.out.println("Login Successful");
			return true;
			
		}
		else {
			System.out.println("Login Unsuccessful");
			return false;
		}
	}

	public boolean login(String username, String pin){
		if (username.equals(this.username) && pin.equals(this.pin)){
			System.out.println("Login Successful");
			return true;
			
		}
		else {
			System.out.println("Login Unsuccessful");
			return false;
		}
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return this.username;
	}

	public void setPin(String pin){
		this.pin = pin;
	}

	public String getPin(){
		return this.pin;
	}
	abstract String getReport();
}
   	

		
				

