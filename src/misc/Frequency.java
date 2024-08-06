package misc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Frequency {

	public static void main(String[] args) {
		String str = "A a b a c d c a";

		Map<Character, Integer> freq1 = new HashMap<>();
		for (Character ch : str.toCharArray())
			if (!Character.isWhitespace(ch))
				freq1.put(Character.toLowerCase(ch), freq1.getOrDefault(ch, 0) + 1);

		Map<Character, Integer> freq2 = new HashMap<>();
		for (Character ch : str.toCharArray())
			if (!Character.isWhitespace(ch))
				freq2.merge(Character.toLowerCase(ch), 1, Integer::sum);

		Map<Character, Long> freq3 = str.chars().mapToObj(ch -> (char) ch).filter(ch -> !Character.isWhitespace(ch))
				.collect(Collectors.groupingBy(Character::toLowerCase, Collectors.counting()));

		Map<Character, Long> freq4 = str.chars().mapToObj(ch -> (char) ch).filter(ch -> !Character.isWhitespace(ch))
				.collect(Collectors.groupingBy(Character::toLowerCase, Collectors.counting()));

		Map<Character, Integer> freq5 = str.chars().mapToObj(c -> (char) c).filter(ch -> !Character.isWhitespace(ch))
				.collect(Collectors.toMap(Character::toLowerCase, v -> 1, Integer::sum));

		System.out.println("freq: " + freq1);
		System.out.println("freq: " + freq2);
		System.out.println("freq: " + freq3);
		System.out.println("freq: " + freq4);
		System.out.println("freq: " + freq5);

		System.out.println("---");

		int[] nums = { 1, 1, 1, 2, 2, 3, 4, 3, 4, 3, 4, 4, 4 };

		Map<Integer, Integer> freq6 = new HashMap<>();
		for (int num : nums)
			freq6.put(num, freq6.getOrDefault(num, 0) + 1);

		Map<Integer, Integer> freq7 = new HashMap<>();
		for (int num : nums)
			freq7.merge(num, 1, Integer::sum);

		Map<Integer, Long> freq8 = Arrays.stream(nums).mapToObj(Integer::valueOf)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		Map<Integer, Integer> freq9 = Arrays.stream(nums).mapToObj(Integer::valueOf)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(a -> 1)));

		Map<Integer, Integer> freq10 = Arrays.stream(nums).mapToObj(Integer::valueOf)
				.collect(Collectors.toMap(Function.identity(), v -> 1, Integer::sum));

		System.out.println("freq: " + freq6);
		System.out.println("freq: " + freq7);
		System.out.println("freq: " + freq8);
		System.out.println("freq: " + freq9);
		System.out.println("freq: " + freq10);
	}

}
