package misc;

import java.util.Arrays;

public class Test {

	private static final int[] PRIMES;

	static {
		PRIMES = new int[] { 1, 2, 3 };
	}

	public static void main(String args[]) {
		get()[0] = 1000;
		System.out.println(Arrays.toString(PRIMES));
	}

	public static int[] get() {
		return PRIMES;
	}

}
