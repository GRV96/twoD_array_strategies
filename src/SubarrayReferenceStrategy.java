/**
 * This class tests whether processing a 2-dimension array is faster if the
 * outer loop keeps a reference to the subarray being processed.
 * @author Guyllaume Rousseau
 */
public class SubarrayReferenceStrategy {

	private static final int ITERATION_COUNT = 1000;

	/**
	 * Calculates the sum of all elements in a 2-dimension array. The outer
	 * loop does not keep a reference to the subarrays.
	 * @param array - a 2-dimension array that contains integers
	 */
	private static int arraySumNoRef(int[][] array) {
		int sum = 0;

		for(int i=0; i<array.length; i++) {

			for(int j=0; j<array[i].length; j++) {
				sum += array[i][j];
			}
		}

		return sum;
	}

	/**
	 * Calculates the sum of all elements in a 2-dimension array. The outer
	 * loop keeps a reference to the subarrays.
	 * @param array - a 2-dimension array that contains integers
	 */
	private static int arraySumWithRef(int[][] array) {
		int sum = 0;

		for(int i=0; i<array.length; i++) {
			int[] subarray = array[i];

			for(int j=0; j<subarray.length; j++) {
				sum += subarray[j];
			}
		}

		return sum;
	}

	public static void main(String[] args) {
		int[][] testArray =
			IntArrayGeneration.make2dRandIntArray(100, 100, 0, 100);

		long startTime = System.nanoTime();
		for(int i=1; i<=ITERATION_COUNT; i++) {
			// The return value is not important.
			arraySumNoRef(testArray);
		}
		long endTime = System.nanoTime();
		System.out.println("Execution time with no reference: "
				+ (double) (endTime-startTime)/1000 + " microsec");

		startTime = System.nanoTime();
		for(int i=1; i<=ITERATION_COUNT; i++) {
			// The return value is not important.
			arraySumWithRef(testArray);
		}
		endTime = System.nanoTime();
		System.out.println("Execution time with reference: "
				+ (double) (endTime-startTime)/1000 + " microsec");
	}
}
