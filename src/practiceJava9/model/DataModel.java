package practiceJava9.model;

public class DataModel<T> {

	private T obj;

	public DataModel(T t) {
		obj = t;
	}

	public T getValue() {
		return obj;
	}

	public void process() {
		System.out.println("doing processing");
	}
}
