package test;
class Res {
	  void print() {
		for (int i = 1; i <= 5; i++) {
			System.out.println(Thread.currentThread().getName()+" print i "+i);
			//try {Thread.sleep(1000);} catch (InterruptedException e) { e.printStackTrace(); }
		}
	}
}
class MyThread extends Thread{
	Res res;

	public MyThread(Res res) {
		this.res = res;
	}
	@Override
	public void run() {
		res.print();
	}
	
}
public class ThreadDemo {
	public static void main(String[] args) {
		Res res1=new Res();
		MyThread th1=new MyThread(res1);
		MyThread th2=new MyThread(res1);
		th1.start();
		th2.start();
	}
}
