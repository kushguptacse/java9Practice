package practiceJava9;

import java.util.Arrays;
import java.util.List;

public class InterfacePrivateTesting {
	public static void main(String[] args) {
		System.out.println("hello");
		List<Integer> list = List.of(1, 2, 3, 4);
//		list.set(0, 5); 
		System.out.println(list);
		List<Integer> list2 = Arrays.asList(1, 2, 3, 4);
		list2.set(0, 5);// it work in arrays.asList but not for List.of
		System.out.println(list2);
		Interf objIn = (x, y) -> System.out.println(x + ":" + y);
		objIn.print(2, 4);
		System.out.println(objIn.op(5, 6));
		System.out.println(Interf.hello());
	}

}

interface Interf {
	default int op(int x, int y) {
		return private_op(x, y);
	}

	static int hello() {
		System.out.println("static method hello");
		return 1;
	}

	private int private_op(int x, int y) {
		return method2(x, y);
	}

	private int method2(int x, int y) {
		return x + y;
	}

	void print(int x, int y);
}