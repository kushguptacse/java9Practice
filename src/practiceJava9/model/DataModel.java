package practiceJava9.model;

import java.io.Serializable;

public class DataModel<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6703986296501083061L;
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

	@Override
	public String toString() {
		return "DataModel [obj=" + obj + "]";
	}
}
