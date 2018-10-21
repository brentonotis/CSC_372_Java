package searching;

/**
 * Class for performing binary search of array
 */

public class BinarySearch {
	/**
	 * Finds value in range of a sorted array using binary search algorithm
	 * @param a - array in which to search
	 * @param low - low index of the range
	 * @param high - high index of the range
	 * @param value - value to find
	 * @return - index at which the value occurs, or -1 if not present
	 */
	public static int search (int[] a, int low, int high, int value) {
		if (low <= high) {
			int mid = (low + high) / 2;		
			
			if (a[mid] == value) {
				return mid;
			}
			else if (a[mid] < value) {
				return search(a, mid + 1, high, value);
			}
			else {
				return search(a, low, mid - 1, value);
			}
		}
		else {
			return -1;
		}
	}
}
