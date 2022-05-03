package a.b.c.test.account;


public class AccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable r = new SyncTest();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);

		t1.start();
		t2.start();
	}
}

class BankAccount {

	int balance = 1000;

	public void withdraw(int money){

		if(balance >= money) {
			try { Thread.sleep(1000);} catch(Exception e) {}
			balance -= money;
		}
	} // withdraw
}

class SyncTest implements Runnable {

	BankAccount ac = new BankAccount();

	public void run() {

		while(ac.balance > 0) {

			// 100, 200, 300중의 한 값을 임으로 선택해서 출금(withdraw)
			int money = (int)(Math.random() * 3 + 1) * 100;
			ac.withdraw(money);
			System.out.println(" balance >>> :"+ac.balance);
		}
	} 
}
