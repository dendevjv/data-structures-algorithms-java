package dsalgjava.ch01.lst0101;

public class BankApp {

	public static void main(String[] args) {
		BankAccount ba1 = new BankAccount(100);
		System.out.print("Before transaction, ");
		ba1.display();
		
		ba1.deposit(75.0);
		ba1.withdraw(20.0);
		
		System.out.print("After transactions, ");
		ba1.display();
	}

}
