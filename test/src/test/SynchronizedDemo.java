package test;
class Bank{
	double balance=10000.00;
	synchronized void withdraw(double amt) throws InterruptedException{
		System.out.println(Thread.currentThread().getName()+" going for withdraw.....");
		if (amt>balance) {
			System.out.println(Thread.currentThread().getName()+ " less balance waiting for deposit.....");
			wait();
		}
		balance=balance-amt;
		System.out.println(Thread.currentThread().getName()+" after transaction balance "+balance);
	}
	synchronized void deposit(double amt) {
		System.out.println(Thread.currentThread().getName()+" going for deposit.....");
		balance=balance+amt;
		System.out.println(Thread.currentThread().getName()+" deposit completed by ");
		System.out.println(Thread.currentThread().getName()+" after deposit balance "+balance);
		notifyAll();
	}
}
class WithDraw extends Thread{
	Bank account;
	
	public WithDraw(Bank account) {
		this.account = account;
	}
	public void run() {
		try {
			account.withdraw(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class Deposit extends Thread{
	Bank account;
	
	public Deposit(Bank account) {
		this.account = account;
	}
	public void run() {
		account.deposit(20000);
	}
}
public class SynchronizedDemo {
	public static void main(String[] args) {
		Bank account=new Bank();
		WithDraw wd=new WithDraw(account);
		wd.setName("wd");
		Deposit dp=new Deposit(account);
		dp.setName("dp");
		WithDraw wd1=new WithDraw(account);
		wd1.setName("wd1");
		wd.start();
		wd1.start();
		dp.start();
	}
}
