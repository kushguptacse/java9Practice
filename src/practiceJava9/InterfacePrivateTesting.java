package practiceJava9;

import java.util.Arrays;
import java.util.List;

public class InterfacePrivateTesting {
	public static void main(String[] args) {
		List<Integer> list = List.of(1, 2, 3, 4);
//		list.set(0, 5); 
		System.out.println(list);
		List<Integer> list2 = Arrays.asList(1, 2, 3, 4);
		list2.set(0, 5);// it work in arrays.asList but not for List.of
		System.out.println(list2);
		Interf objIn = (x, y) -> System.out.println(x + ":" + y);
		objIn.print(2, 4);
		System.out.println(objIn.op(5, 6));
		System.out.println("Java 9");
		System.out.println(Interf.hello());
		// objIn.hello();// static interface method can only be called by interface name
		// only
		ClassF obj = new ClassF();
		// obj.hello();
		// ClassF.hello();
		Interf.hello();// static interface method can only be called by interface name only
		obj.op(2, 22);
	}

}

class ClassF implements Interf {

	@Override
	public void print(int x, int y) {
		System.out.println(x + "-" + y);
	}

}

interface Interf {
	default int op(int x, int y) {
		Interf.hello();
		return private_op(x, y);
	}

	static int hello() {
		printMessage("static method hello");
		return 1;
	}

	private int private_op(int x, int y) {
		return method2(x, y);
	}

	private int method2(int x, int y) {
		return x + y;
	}

	private static void printMessage(String s) {
		System.out.println(s);
	}

	void print(int x, int y);
}