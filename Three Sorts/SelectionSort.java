// Jerry Huang
// Period 4
// ACPS
// Selection Sort Program

public class SelectionSort {
	
	/**
	 * Performs selection sort on an array
	 * @param array
	 * @return array
	 */
	public static int[] doSelectionSort(int[] array) {
		
		int index, temp;
		for (int i = 0; i < array.length - 1; i++) {
			
			index = i;
			
			for (int k = i + 1; k < array.length; k++) {
				if (array[k] < array[index]) {
					index = k;
				}
			}
			temp = array[i];
			array[i] = array[index];
			array[index] = temp;
		}
		return array;
	}
	
	/**
	 * Main method tests selection sort method
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr1 = {10,34,2,56,7,67,88,42};
		int[] arr2 = doSelectionSort(arr1);
		for (int i: arr2) {
			System.out.print(i + ", ");
		}
	}
}