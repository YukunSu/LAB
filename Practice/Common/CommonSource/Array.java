package CommonSource;

import java.util.Arrays;

public class Array {

	private int[] intArray;

	public Array(int[] array) {
		intArray = new int[array.length];
		for (int i = 0; i < intArray.length; i++) 
			intArray[i] = array[i];
	}

	public int getArrayLength() {
		return this.intArray.length;
	}

	public int getElement(int index) {
		return this.intArray[index];
	}

	public int[] getIntegerArray() {
		return this.intArray;
	}

	public void defaultJavaSortArray() {
		Arrays.sort(this.intArray);
	}

	public void mergeArray(Array arrayAddin) {
		int[] mergedArray = new int[this.intArray.length
				+ arrayAddin.getArrayLength()];
		for (int i = 0; i < mergedArray.length; i++) {
			if (i < arrayAddin.getArrayLength())
				mergedArray[i] = this.intArray[i];
			else
				mergedArray[i] = arrayAddin.getElement(i - arrayAddin.getArrayLength());
		}
		this.intArray = mergedArray;
	}

	public void printArray() {
		for (int i = 0; i < intArray.length; i++) {
			System.out.print(intArray[i]);
			if (i != intArray.length - 1)
				System.out.print(", ");
			else
				System.out.println();
		}
	}

	public void quickSort(int low, int high) {
		int i = low;
		int j = high;
		// Get the pivot element from the middle of the list
		int pivot = this.intArray[low + ((high - low) >> 1)];
		
		// Divide into two lists
		while (i <= j) {
			// If the current value from the left list is smaller then the pivot
			// element then get the next element from the left list
			while (this.intArray[i] < pivot) {
				i++;
			}
			// If the current value from the right list is larger then the pivot
			// element then get the next element from the right list
			while (this.intArray[j] > pivot) {
				j--;
			}
			
			// If we have found a values in the left list which is larger then
			// the pivot element and if we have found a value in the right list
			// which is smaller then the pivot element then we exchange the
			// values.
			// As we are done we can increase i and j
			if (i <= j) {
				swap(i, j);
				i++;
				j--;
			}
		}
		// Recursion
		if (low < j)
			quickSort(low, j);
		if (i < high)
			quickSort(i, high);
	}
	
	public void reverseArray() {
		for (int i = 0; i < (intArray.length >> 1); i++) 
			swap(i, intArray.length - i - 1);
	}

	public void swap(int i, int j) {
		int temp = this.intArray[i];
		this.intArray[i] = this.intArray[j];
		this.intArray[j] = temp;
	}
}
