package test;

import java.util.Comparator;
import java.util.TreeSet;

class Desc implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Integer i1=(Integer) o1;
		Integer i2=(Integer) o2;
		return -(i1-i2);
	}
}
public class ComparatorDemo {

	public static void main(String[] args) {
		TreeSet ts=new TreeSet(new Desc());
		ts.add(8);
		ts.add(9);
		ts.add(11);
		ts.add(10);
		for (Object object : ts) {
			System.out.println(object);
		}
	}
}
