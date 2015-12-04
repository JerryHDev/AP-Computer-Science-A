import java.util.ArrayList;
import java.util.Arrays;

// Jerry Huang
// APCS
// Period 2
// Median Finder Program

/**
 * Median Finder Program
 * This program takes in an array and finds the median
 * @author Jerry Huang
 *
 */
public class MedianFinder {
	
	public static void main(String[] args) {
		
		ArrayList<Integer> testArray = new ArrayList<Integer>(Arrays.asList(3, 6, 1, 9, 4, 7, 6));
		int median = findMedian(testArray, 0, 0);
		
		System.out.println("The array: " + testArray.toString());
		System.out.println("The median is: " + median);
	}
	
	/**
	 * Finds the median of the array through a recursive method
	 * Algorithm: determines the number of values above or below the pivot
	 * and partitions the array through recursion.
	 * The final value returned is the median of the array.
	 * 
	 * @param testArray
	 * @param numsBelow
	 * @param numsAbove
	 * @return median
	 */
	private static int findMedian(ArrayList<Integer> myArray, int numsBelow, int numsAbove) {
		
		// initial pivot value used to partition array
		int pivot = findPivot(myArray);
		
		// Three array lists to store values smaller, same, or bigger than the pivot value
		ArrayList<Integer> smaller = new ArrayList<Integer>();
		ArrayList<Integer> same = new ArrayList<Integer>();
		ArrayList<Integer> bigger = new ArrayList<Integer>();
		
		// Adds elements to three array lists
		for (int num : myArray) {
			if (num < pivot) smaller.add(num);
			else if (num == pivot) same.add(num);
			else bigger.add(num);
		}
		
		// If difference between all elements above pivot and all elements below pivot is less than or equal to
		// size of ArrayList same, then the median is the pivot
		if (Math.abs((bigger.size() + numsAbove) - (smaller.size() + numsBelow)) <= same.size()) {
			return pivot;
		}
		
		// If total number of elements above pivot is greater than total number of elements below pivot,
		// then the median must be in the ArrayList bigger
		else if ((bigger.size() + numsAbove) > (smaller.size() + numsBelow)) {
			return findMedian(bigger, numsBelow + same.size() + smaller.size(), numsAbove);
		}
		
		// If total number of elements below pivot is greater than total number of elements above pivot,
		// then the median must be in the ArrayList smaller
		else if((smaller.size() + numsBelow) > (bigger.size() + numsAbove)) {
			return findMedian(smaller, numsBelow, bigger.size() + same.size() + numsAbove);
		}
		
		// Impossible scenario
		else {
			System.out.println("This scenario should never occur. Error in program if this message is printed");
			return pivot;
		}
	}
	
	
	/**
	 * Takes the middle value of the unsorted array
	 * and makes that value the pivot
	 * @param testArray
	 * @return pivot
	 */
	private static int findPivot(ArrayList<Integer> myArray) {
		int pivotIndex = myArray.size() / 2;
		return myArray.get(pivotIndex);
	}
}