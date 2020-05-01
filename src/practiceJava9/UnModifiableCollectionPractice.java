package practiceJava9;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import practiceJava9.model.DataModel;

public class UnModifiableCollectionPractice {
	public static void main(String[] args) {
		UnModifiableCollectionPractice obj = new UnModifiableCollectionPractice();
		obj.listPractice();
		obj.setPractice();
		obj.mapPractice();
		obj.testSerializable();
	}

	private void listPractice() {
		System.out.println("list practice");
		// till java 8
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		List<Integer> oldwayList = Collections.unmodifiableList(list);
		System.out.println(oldwayList);
		System.out.println(oldwayList.getClass().getName());

//		oldwayList.add(2);//UnsupportedOperationException
//		oldwayList.set(1, 20);//UnsupportedOperationException
//		oldwayList.remove(0);//UnsupportedOperationException

		// from java 9
		List<Integer> newWayUnModifiableList = List.of(1, 2, 3);
		System.out.println(newWayUnModifiableList);
		System.out.println(newWayUnModifiableList.getClass().getName());
//		newWayUnModifiableList.add(2);//UnsupportedOperationException
//		newWayUnModifiableList.set(1, 20);//UnsupportedOperationException
//		newWayUnModifiableList.remove(0);//UnsupportedOperationException
//		List.of(1,2,null);//NullPointerException
		System.out.println(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		System.out.println(List.of());
		System.out.println(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11));
	}

	private void mapPractice() {
		System.out.println("map practice");
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(null, null);
		Map<Integer, String> oldway = Collections.unmodifiableMap(map);
		System.out.println(oldway);
		System.out.println(oldway.getClass().getName());

		Map<Integer, String> newWayMap = Map.of(1, "a", 2, "b", 3, "c");
		System.out.println(newWayMap);
		System.out.println(newWayMap.getClass().getName());
//		newWayMap.put(null, "d");//UnsupportedOperationException
//		newWayMap.put(1, "d");//UnsupportedOperationException
//		newWayMap.remove(2);//UnsupportedOperationException
//		newWayMap.remove(null);//UnsupportedOperationException
//		Map.of(1,null);//NullPointerException
//		Map.of(null, 2);// NullPointerException
		System.out.println(Map.of(1, "a", 2, "a"));
//		Map.of(1,"a",2,"b",1,"c");//IllegalArgumentException
		System.out.println(Map.of());
		System.out.println(Map.of(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10));
		Map.Entry<Integer, String> e1 = Map.entry(1, "a");
		Map.Entry<Integer, String> e2 = Map.entry(2, "b");
		Map.Entry<Integer, String> e3 = Map.entry(3, "c");
		System.out.println(Map.ofEntries(e1, e2, e3));
//		e1.setValue("v");//UnsupportedOperationException
	}

	private void setPractice() {
		System.out.println("set practice");
		Set<Integer> set = new HashSet<>();
		set.add(1);
		set.add(2);
		set.add(3);
		Set<Integer> oldwaySet = Collections.unmodifiableSet(set);
		System.out.println(oldwaySet);
		System.out.println(oldwaySet.getClass().getName());

		Set<Integer> newWay = Set.of(1, 2, 3);
		System.out.println(newWay);
		System.out.println(newWay.getClass().getName());
//		newWay.remove(1);//UnsupportedOperationException
//		newWay.add(4);//UnsupportedOperationException
//		Set.of(1,null);//NullPointerException
//		Set.of(2,1,3,1);//IllegalArgumentException
		System.out.println(Set.of());
		System.out.println(Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		System.out.println(Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11));
	}

	private void testSerializable() {
		System.out.println("serializable unmodifiable list");
		try {
			FileOutputStream fos = new FileOutputStream("file.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			try (fos; oos) {
				List<DataModel<Integer>> list = List.of(new DataModel<>(1), new DataModel<>(2));
				oos.writeObject(list);
			}

			FileInputStream fis = new FileInputStream("file.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			try (fis; ois) {
				List<DataModel<Integer>> list = (List<DataModel<Integer>>) ois.readObject();
				System.out.println(list);
//				list.add(new DataModel<>(2));//UnsupportedOperationException
			}

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}
