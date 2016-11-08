import static java.util.Arrays.copyOfRange;

/**
 * CSC 1600
 * Data Structures
 * Project Description:
 *
 *  You can sort a large array of integers that are in the range 1 to n by using an array count
 *  of n entries to count the number of occurrences of each integer in the array.
 *  For example, consider the following array of 14 integers that range from 1 to 9:
 *
 *  9 2 4 8 9 4 3 2 8 1 2 7 2 5
 *
 *  Form an array count of 9 elements such that count[i-1] contains the number of times that i occurs in
 *  the array to be sorted. Thus, count is
 *
 *  1 4 1 2 1 0 1 2 2
 *
 *  We now know that 1 occurs once in the original array, 2 occurs four times, and so on.
 *  Thus, the sorted array is
 *
 *  1 2 2 2 2 3 4 4 5 7 8 8 9 9
 *
 *  a. Implement this sorting algorithm. You must include the test of sorting algorithm.
 *
 *  b. Using Big Oh notation, describe the efficiency of this algorithm. (Answer this in the code as comments)
 *
 *  c. Is this algorithm useful as a general sorting algorithm? Explain. (Answer this in the code as comments)
 *
 * @author Brandon Young
 */
// File Name: SortArrayYoung.java
public class SortArrayYoung {

    public static void main(String[] args) {
        // The top range of the array to sort
        final int N = 9;
        // An array of integers to sort
        int[] numbers = {9, 2, 4, 8, 9, 4, 3, 2, 8, 1, 2, 7, 2, 5};

        System.out.println("The Array before it is sorted: ");
        // Print the unsorted Array
        printArray(numbers);

        // Sort the Array with countSort
        numbers = countSort(numbers, N);

        System.out.println("The Array after it is sorted: ");
        // Print the sorted array
        printArray(numbers);


    }  // end main

    /**
     * The method countSort sorts an Array of integers in the range of 1 to n and returns a new array of sorted integers
     * sorted in ascending order. This method takes advantage of the fact that Java initializes Arrays with 0's.
     * Precondition: Java initializes empty Arrays with 0
     * Post Condition: Returns a sorted Array of ascending order integers using the count sort method
     * @param unsortedArray int[]: An array of unsorted integers
     * @param n int: The upper most integer that occurs in unsortedArray
     * @return sortedArray (int[]): The Array unsortedArray after it has been sorted in ascending order.
     */
    private static int[] countSort(int[] unsortedArray, int n) {
        // holds the number of occurrences of each integer in unsortedArray
        int[] count = new int[n];
        // loops through unsortedArray to count the occurrences of each integer
        for (int i = 0; i < unsortedArray.length; i++) {
            // adds 1 to each occurrence of an integer in unsortedArray at index n-1 in count
           count[ unsortedArray[i] - 1 ]++;
        } // end for loop
        // loops through count to change it to hold the index of the given number
        for (int i = 1; i < n; i++) {
            // Change the counting array to n + n-1
            count[i] = count[i] + count[i - 1];
        } // end for loop
        // A new Array that will be used to hold the sorted array to return
        int[] sortedArray = new int[unsortedArray.length + 1];
        // takes the number at index i and finds the new index from Array count to place it in sortedArray
        for (int i = 0; i < unsortedArray.length; i++) {
            // Takes the item at index i in unsorted array and uses that number to find the location to put the number
            // in sortedArray
            sortedArray[ count[unsortedArray[i] - 1] ] = unsortedArray[i];
            // Subtracts the value in count
            count[unsortedArray[i] - 1]--;
        } // end for loop
        // returns the sortedArray - index 1 to get rid of the extra zero
        return copyOfRange(sortedArray, 1, unsortedArray.length + 1);
    } // end countSort

    /**
     * The printArray method loops through an Array of integers and prints it out in the format [n, n, n, n, n]
     * Precondition: none
     * Post Condition: Loops through Array array and prints it out in the format [n, n, n, n, n]
     * @param array int[]: The array of integers to be printed
     */
    private static void printArray(int[] array) {
        // Loops through the sorted array and prints it out
        for (int index = 0; index < array.length; index++) {
            // Add [ if its the first item of the Array
            if (index == 0) {
                System.out.print("[" + array[index] + ", ");
            } else if (index == array.length - 1) { // Add ] if its the last item in the Array
                System.out.print(array[index] + "]");
            } else {
                System.out.print(array[index] + ", ");
            } // end if else
        } // end for loop
        // Print a newline character so the next item printed is not on the same line.
        System.out.println("\n");
    } // end printArray

} // end SortArrayYoung
