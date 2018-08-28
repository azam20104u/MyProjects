package test;

public class TreeSetImpl {
	static int p=0,temp,count=0;
	static int[] arr=new int[4];
	public void add(int no) {
		count++;
		if (count==1) {
			arr[p++]=no;
			System.out.println("added 0 index");
		} else {
			for (int i = 0; i < count-1; i++) {
				if (arr[i]>no) {
					temp=arr[i];
					arr[i]=no;
					arr[p++]=temp;
					System.out.println("swap the nos");
				}else {
				arr[p++]=no;
				}
			}
		}
	}
	public void comp(int no1,int no2) {
		
	}
	public static void main(String[] args) {
		TreeSetImpl ts=new TreeSetImpl();
		ts.add(9);
		ts.add(8);
		ts.add(11);
		//ts.add(10);
		/*for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}*/
	}
}
