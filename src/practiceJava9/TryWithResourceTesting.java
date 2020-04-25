package practiceJava9;

import java.util.Scanner;

import practiceJava9.model.MyResource;

public class TryWithResourceTesting {
	public static void main(String[] args) {
		MyResource r = new MyResource(1);
		MyResource r2 = new MyResource(2);
		try (r; r2) {
			System.out.println("inside try");
			r.process();
			r2.process();
		}
		simpleScannerResource();
		AutoCloseable ac = () -> System.out.println("resource closed lambda");
		try (ac) {
			System.out.println("inside try again");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void simpleScannerResource() {
		Scanner sc = new Scanner(System.in);
		try (sc) {
			System.out.println("Enter something to echo :");
			String s = sc.nextLine();
			System.out.println(s);
		}
	}
}
