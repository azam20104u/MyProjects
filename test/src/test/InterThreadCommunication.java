package test;
class Account{
	int bal=10000;
	 void withdraw(int amt) {
		System.out.println(Thread.currentThread().getName()+" going for withdraw");
		if (amt>bal) {
			System.out.println(Thread.currentThread().getName()+" Less balance waiting for deposit "+bal);
			//try { wait(); } catch (InterruptedException e) { e.printStackTrace(); }
		} 
		bal-=amt;
		System.out.println("withdraw completed Your balance "+bal);
	}
	 void deposit(int amt) {
		System.out.println(Thread.currentThread().getName()+" going for deposit");
		bal+=amt;
		System.out.println(Thread.currentThread().getName()+" deposit completed "+bal);
		//notify();
	}
}
class SBINetBanking extends Thread{
	Account ac;
	
	public SBINetBanking(Account ac) {
		this.ac = ac;
	}
	@Override
	public void run() {
		ac.withdraw(15000);
	}
}
class SBIDebitCart extends Thread{
	Account ac;
	
	public SBIDebitCart(Account ac) {
		this.ac = ac;
	}
	@Override
	public void run() {
		ac.deposit(10000);
	}
}
public class InterThreadCommunication {
	public static void main(String[] args) {
		Account ac=new Account();
		SBINetBanking th1=new SBINetBanking(ac);
		SBIDebitCart th2=new SBIDebitCart(ac);
		th1.setName("withdraw thread");
		th2.setName("deposit thread");
		th1.start();
		th2.start();
	}
}
