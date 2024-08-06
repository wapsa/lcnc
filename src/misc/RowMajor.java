package misc;

public class RowMajor {

	private static final String[] ARRAY = new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i" };

	private static final String[][] MATRIX = new String[][] {

			{ "a", "b", "c" },

			{ "d", "e", "f" },

			{ "g", "h", "i" }

	};

	public static void main(String[] args) {
		// i = r * num of cols + c
		System.out.println("1D array index for 'd', " + (1 * 3 + 0));
		System.out.println("1D array index for 'e', " + (1 * 3 + 1));
		System.out.println("1D array index for 'f', " + (1 * 3 + 2));

		// r = i / num of cols
		// c = i % num of cols
		System.out.println("3cols 2d row: " + 5 / 3);
		System.out.println("3cols 2d col: " + 5 % 3);

	}

}
