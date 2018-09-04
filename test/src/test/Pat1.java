package test;

public class Pat1 {
	public static void main(String[] args) {
		for (int i = 1; i <=5 ; i++) {
			int no=i,dec=4;
			for (int j = 1; j <=i; j++) {
				System.out.print(no+" ");
				no=no+dec--;
			}
			System.out.println();
		}
	}
}
