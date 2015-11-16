// Jerry Huang
// Period 2
// APCS
// Bubble Sort Program

public class BubbleSort {
	
	/**
	 * Performs bubble sort on array
	 * @param array
	 * @return array
	 */
	public static int[] doBubbleSort(int[] array) {
		
		int temp = 0;
		for (int i = 0; i < array.length - 1; i++) {
			
			for (int k = 0; k < array.length - i - 1; k++) {
				if (array[k] > array[k+1]) {
					temp = array[k];
					array[k] = array[k+1];
					array[k+1] = temp;
				}
			}
		}
		return array;
	}
	
	/**
	 * Main method tests bubble sort method
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr1 = {10,34,2,56,7,67,88,42};
		int[] arr2 = doBubbleSort(arr1);
		for (int i: arr2) {
			System.out.print(i + ", ");
		}
	}
}