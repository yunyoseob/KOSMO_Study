package a.b.c.test.account;

/*
synchronized 사용 자바 동기화
1. 메서드 사용
public synchronized void method(){
	// 코드
}
2. 객체변수 사용
private Object obj = new Object();
public void exampleMethod(){
	synchronized(obj){
		// 코드
	}
}
*/


public class AccountTest_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable r = new SyncTest_1();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);

		t1.start();
		t2.start();
	}
}

class BankAccount_1 {

	int balance = 1000;

	public synchronized void withdraw(int money){
		
		if(balance >= money) {
			try { Thread.sleep(1000);} catch(Exception e) {}
			balance -= money;
		}
	} // withdraw
}

class SyncTest_1 implements Runnable {

	BankAccount_1 ac1 = new BankAccount_1();

	public void run() {
		synchronized(this){
			while(ac1.balance > 0) {

				// 100, 200, 300중의 한 값을 임으로 선택해서 출금(withdraw)
				int money = (int)(Math.random() * 3 + 1) * 100;
				ac1.withdraw(money);
				System.out.println(" balance >>> : " + ac1.balance
					               + " : 출금시간 >>> : " 
					               + CurrentTime.cTime());
			}
		}
	} 
}

abstract class CurrentTime 
{
	public static String cTime(){
		
		long time = System.currentTimeMillis();		
		java.text.SimpleDateFormat sdf = 
			new java.text.SimpleDateFormat("yyyy.mm.dd hh:mm:ss");
		String cTime = sdf.format(new java.util.Date(time));

		return cTime;
	}
}
