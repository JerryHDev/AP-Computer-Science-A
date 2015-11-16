// Jerry Huang
// Period 2
// APCS
// Insertion Sort Program

public class InsertionSort {
	
	/**
	 * Performs insertion sort on an array
	 * @param array
	 * @return array
	 */
	public static int[] doInsertionSort(int[] array) {
		
		int temp;
		for (int i = 0; i < array.length; i++) {
			
			for (int k = i; k > 0; k--) {
				if (array[k] < array[k-1]) {
					temp = array[k];
					array[k] = array[k-1];
					array[k-1] = temp;
				}
			}
		}
		return array;
	}
	
	/**
	 * Main method tests insertion sort method
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr1 = {10, 34, 2, 56, 7, 67, 88, 42};
        int[] arr2 = doInsertionSort(arr1);
        for(int i: arr2){
            System.out.print(i + ", ");
        }
	}
}