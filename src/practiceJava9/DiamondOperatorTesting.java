package practiceJava9;

import java.util.Iterator;
import java.util.List;

import practiceJava9.model.DataModel;

public class DiamondOperatorTesting {
	public static void main(String[] args) {
		diamondOperatorEnhancement();
		iteratorTesting();
	}

	public static void iteratorTesting() {
		String[] ar = new String[] { "a", "b", "c", "d" };
		Iterator<String> it = new Iterator<>() {
			int i = 0;

			@Override
			public boolean hasNext() {
				return i < ar.length;
			}

			@Override
			public String next() {
				return ar[i++];
			}
		};
		List<String> l = List.of("1", "2", "3", "4");
		l.iterator().forEachRemaining(System.out::println);
		System.out.println("--------------");
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println("------------------");
		it.forEachRemaining(System.out::println); 
	}

	private static void diamondOperatorEnhancement() {
		DataModel<String> model = new DataModel<String>("jimmy") {
			@Override
			public void process() {
				System.out.println("processing java 7 way " + getValue());
			}
		};
		model.process();

		DataModel<String> model2 = new DataModel<>("aaja") {
			@Override
			public void process() {
				System.out.println("processing java 9 way " + getValue());
			}
		};
		model2.process();

	}

}
