package Day3.Assignment4;

import java.util.Scanner;

public class SortAndInsert {

	public static int[] SortedArray(int[] num) {
		int temp = 0;
		for (int i = 0; i < num.length; i++) {
			for (int j = i; j < num.length; j++) {
				if (num[i] > num[j]) {
					temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
		}
		return num;
	}

	public static int[] InsertedArray(int[] sortedArray, int insert) {
		int[] insertedArray = new int[sortedArray.length + 1];
		int flag = 0;
		int pos = 0;
		for (int i = 0; i < sortedArray.length; i++) {
			if (insert >= sortedArray[i]) {
				flag = 1;
				pos = i + 1;
			}

		}

		if (flag == 1) {
			for (int j = pos; j < sortedArray.length; j++) {
				insertedArray[j + 1] = sortedArray[j];
			}
			for (int j = 0; j < sortedArray.length; j++) {
				insertedArray[j] = sortedArray[j];
			}
			insertedArray[pos] = insert;
		} else {
			for (int j = 0; j < sortedArray.length; j++) {
				insertedArray[j] = insertedArray[j];
			}
			insertedArray[sortedArray.length + 1] = insert;
		}
		return insertedArray;

	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the Number of Element you want to Enter :");
		int noOfElements = scan.nextInt();

		int arr[] = new int[noOfElements];

		// Input of the Array which is to be reversed
		for (int i = 0; i < noOfElements; i++) {
			System.out.println("Enter the " + (i + 1) + "element of the array");
			arr[i] = scan.nextInt();
		}
		System.out.println("Enter the Number you want to Insert :");
		int insert = scan.nextInt();
		scan.close();

		// Calling Static Function: SortedArray to return the array after
		// sorting
		int sortedArray[] = SortAndInsert.SortedArray(arr);

		// Calling Static Function: InsertedArray to return the array after
		// Insertion of the Number
		int insertedArray[] = InsertedArray(sortedArray, insert);

		// Printing the New Array after Insertion of Element
		System.out.println('\n' + "-----ORIGINAL ARRAY  -----");
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println('\n' + "-----Number to be inserted----" + '\n' + insert);

		// Printing the New Array after Insertion of Element
		System.out.println("-----Array after Sorting and Insertion -----");
		for (int i = 0; i < insertedArray.length; i++)
			System.out.print(insertedArray[i] + " ");

	}

}
