package MSR;

import CommonSource.Array;

public class ArrayMSR {
	public static void main(String[] args) {
		int[] array1 = { 10, 5, 20, 38, 30, 99, 65, 205, 40 };
		int[] array2 = { 0, 40, 24, 50, 25, 60, 25, 999, 7 };
		int[] array3 = { 234, 45, 56, 8, 5468, 254, 13, 87, 45 };
		Array intArray1 = new Array(array1);
		Array intArray2 = new Array(array2);
		Array intArray3 = new Array(array3);

		//print arrays before some manipulations
		System.out.print("Elements of the first array at the begining: ");
		intArray1.printArray();
		System.out.print("Elements of the second array at the begining: ");
		intArray2.printArray();
		System.out.print("Elements of the third array at the begining: ");
		intArray3.printArray();
		System.out.println();
		
		//merge arrays
		System.out.print("After merge array 1 and 2: ");
		intArray1.mergeArray(intArray2);
		intArray1.printArray();
		System.out.print("After merge array 2 and 3: ");
		intArray3.mergeArray(intArray2);
		intArray3.printArray();
		System.out.println();
		
		//sort arrays use java api and implemented quicksort
		System.out.print("After sort array 1 and 2: ");
		intArray1.defaultJavaSortArray();
		intArray1.printArray();
		System.out.print("After sort array 2 and 3: ");
		intArray3.quickSort(0,intArray3.getArrayLength()-1);
		intArray3.printArray();
		System.out.println();
		
		//reverse the order of the arrays
		System.out.print("After reverse the merged array 1 and 2: ");
		intArray1.reverseArray();
		intArray1.printArray();
		System.out.print("After reverse the merged array 2 and 3: ");
		intArray3.reverseArray();
		intArray3.printArray();
		System.out.println();
		
		//print them after manipulations
		System.out.print("Elements of the first array at the end: ");
		intArray1.printArray();
		System.out.print("Elements of the second array at the end: ");
		intArray2.printArray();
		System.out.print("Elements of the third array at the end: ");
		intArray3.printArray();
	}
}
