package practiceJava9.model;

public class MyResource implements AutoCloseable {
	private int i;

	public MyResource(int i) {
		this.i = i;
	}

	@Override
	public void close() {
		System.out.println("resource closed " + i);
	}

	public void process() {
		System.out.println("processing resource " + i);
	}

}
