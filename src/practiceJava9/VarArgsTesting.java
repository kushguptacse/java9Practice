package practiceJava9;

import java.util.List;

public class VarArgsTesting {
	public static void main(String[] args) {
		test();
		test(1, 2, 3);
		testList(List.of(1, 2, 3), List.of(4, 5, 6));
	}

	@SafeVarargs
	private static void testList(List<Integer>... l) {
		List[] obj = l;
		obj[0] = List.of("Hello","Kush");
		System.out.println("heap pollution testing");
		for (List<Integer> list : l) {
			System.out.println(list);
			System.out.println(list.get(0)-1);
		}
	}

	private static void test(int... is) {
		int sum = 0;
		for (int i : is) {
			sum += i;
		}
		System.out.println("sum : " + sum);
	}

}
