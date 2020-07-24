package practiceJava9;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPractice {
	public static void main(String[] args) {
		List<Integer> l = Stream.of(2, 4, 1, 6, 3).takeWhile(x -> x % 2 == 0).collect(Collectors.toList());
		System.out.println(l);
		l = Stream.of(2, 4, 1, 6, 3).dropWhile(x -> x % 2 == 0).collect(Collectors.toList());
		System.out.println(l);
		System.out.println("java 8 iterate method");
		Stream.iterate(0, x -> x + 1).limit(10).forEach(System.out::print);
		System.out.println();
		System.out.println("java 9 iterate method");
		Stream.iterate(0, x -> x <= 9, x -> x + 1).forEach(System.out::print);
		System.out.println();
		List<String> list = Stream.of("a", "b", null, "c").flatMap(x -> Stream.ofNullable(x))
				.collect(Collectors.toList());
		System.out.println(list);
		Map<String, String> map = new HashMap<>();
		map.put("a", "apple");
		map.put(null, "zebra");
		map.put("b", "ball");
		map.put("d", null);
		map.entrySet().stream().flatMap(e -> Stream.ofNullable(e.getKey())).forEach(x -> System.out.println(x));
		map.entrySet().stream().flatMap(e -> Stream.ofNullable(e.getValue())).forEach(x -> System.out.println(x));
		StringBuilder sb = new StringBuilder();
		Map.of("a", 2, "b", 4, "c", 1).entrySet().stream().sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
				.forEach(x -> IntStream.range(0, x.getValue()).forEach(c -> sb.append(x.getKey())));
		System.out.println(sb.toString());
	}

}
