package myPackage;

public class Account {

	public static int acc_balance=25000;
	
	public String withdraw(int amount) {
		acc_balance=acc_balance-amount;
		return "Withdraw Successfull!!";
	}
	
	public String showBalance() {
		return "Your Balance is: "+acc_balance;
	}
}
