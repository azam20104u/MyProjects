package test;

public class Test {
	static void m(int no) {
		System.out.println(no++);
		if(no<=5) {
			m(no);
			System.out.println(--no);
		}
	}
	public static void main(String[] args) {
		m(1);
	}
}
