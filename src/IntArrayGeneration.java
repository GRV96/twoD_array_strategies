import java.lang.Math;

public final class IntArrayGeneration {

	public static int[][] make2dRandIntArray(int iSize, int jSize,
			int minimum, int maximum) {
		int[][] randArray = new int[iSize][jSize];

		for(int i=0; i<iSize; i++) {
			for(int j=0; j<jSize; j++) {
				randArray[i][j] = randInt(minimum, maximum);
			}
		}

		return randArray;
	}

	public static void printIntArrayOneLine(int[] array, String separator) {
		String line = "";
		int length = array.length;

		if(length > 0) {
			line += array[0];

			for(int i=1; i<length; i++) {
				line += separator + array[i];
			}
		}

		System.out.println(line);
	}

	public static void print2dIntArray(int[][] array, String separator) {
		for(int i=0; i<array.length; i++) {
			printIntArrayOneLine(array[i], separator);
		}
	}

	private static int randInt(int minimum, int maximum) {
		return minimum +
			(int) Math.floor((maximum - minimum + 1) * Math.random());
	}
}