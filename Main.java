// original code by ChatGPT to demonstrate the different principles
// of linear search and binary search, including the sorting step for binary search.
// ontop of the bubblesort array.
// greate examples of Arrays and sorting through index location or the opposite, the value at the index location.
import java.util.Arrays;
import java.util.Scanner;
// applied a messy, but effective, way for the user to input the index value, and it returns the integer value at that index.
public class Main {
    public static void main(String[] args) {

        int[] arr = {
            73, 914, 256, 481, 999, 32, 678, 145, 802, 567,
            219, 430, 761, 88, 690, 12, 947, 523, 276,
            389, 354, 15, 49, -23, -343, 0
        };
        System.out.println("Original array: " + Arrays.toString(arr));
        System.out.println("Value at index 20 (before sorting): " + arr[20]); // value at index 20 is 15, but after sorting it will be -23, which is the smallest value in the array

        int targetIndex = 0; // index of the value to search for
        int target = arr[targetIndex]; // value to search for
        System.out.println("Enter the index of the arr you want to retrieve: " );
        int targetIndexInput = new Scanner(System.in).nextInt();
        target = arr[targetIndexInput];
        System.out.println("The value you were looking for is: " + target); 

        // ---------- LINEAR SEARCH (unsorted) ----------
        // searches an array through in a linear fashion, compares each element to the target, in this case 354, if it finds
        // it then it returnts the index of the target array... in this case that is 14. If for example, I change the target
        // and place that at a differnet position, it then returns that index position, in the next example that is 20.
        int linearComparisons = 0;
        int linearIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            linearComparisons++;
            if (arr[i] == target) {
                linearIndex = i;
                break;
            }
        }

        // ---------- SORT ARRAY ----------
        bubbleSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));

        // ---------- BINARY SEARCH ----------
        int binaryComparisons = 0;
        int binaryIndex = binarySearch(arr, target);

        // ---------- OUTPUT ----------
        System.out.println("Value at index 20 (by the time it gets here is sorted): " + arr[20]);
        System.out.println("\n--- RESULTS ---");
        
        if (linearIndex != -1) {
            System.out.println("Linear Search found at index: " + linearIndex);
        } else {
            System.out.println("Linear Search: Not found");
        }
            System.out.println("Linear comparisons: " + linearComparisons);

        if (binaryIndex != -1) {
            System.out.println("Binary Search found at index: " + binaryIndex);
        } else {
            System.out.println("Binary Search: Not found");
        }
            System.out.println("Binary comparisons: " + binaryComparisons);
    }

    

    // ---------- BUBBLE SORT ----------
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // ---------- BINARY SEARCH WITH COUNTER ----------
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int comparisons = 0;

        while (left <= right) {
            comparisons++;

            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                System.out.println("Binary comparisons: " + comparisons);
                return mid;
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println("Binary comparisons: " + comparisons);
        return -1;
    }
}