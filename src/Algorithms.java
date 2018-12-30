import java.util.Random;

/**
 * Created by Kavin on 12/21/18.
 */
public class Algorithms {
    public static void selectionSort(int[] input) {
        int n = input.length;
        for (int i = 0; i < n-1; i++)
        {
            // Find the smallest number
            int smallest = i;
            for (int j = i+1; j < n; j++) {
                if (input[j] < input[smallest]) {
                    smallest = j;
                }
            }
            //switch with first number
            int temp = input[smallest];
            input[smallest] = input[i];
            input[i] = temp;
        }

    }
    public static void merge(int[] a, int[] first, int[] second) {
        int firstIndex = 0;
        int secondIndex = 0;
        int primeIndex = 0;
        //as merging, sort from smallest to biggest
        while (firstIndex < first.length && secondIndex < second.length) {
            if (first[firstIndex] <= second[secondIndex]) {
                a[primeIndex] = first[firstIndex];
                primeIndex++;
                firstIndex++;
            } else {
                a[primeIndex] = second[secondIndex];
                primeIndex++;
                secondIndex++;
            }
        }
        //if one of the arrays finishes before the other, then finish up the process for the other one
        while (firstIndex < first.length) {
            a[primeIndex] = first[firstIndex];
            primeIndex++;
            firstIndex++;
        }
        while (secondIndex < second.length) {
            a[primeIndex] = second[secondIndex];
            primeIndex++;
            secondIndex++;
        }
    }
    public static void mergeSort(int[] a) {
        if(a.length < 2) {
            return;
        }
        int mid = a.length/2;
        int[] first = new int[mid];
        int[] second = new int[a.length - mid];
        //put correct numbers into respective arrays
        for(int i = 0; i < mid; i++)  {
            first[i] = a[i];
        }
        for(int i = mid ; i < a.length; i++)  {
            second[i - mid] = a[i];
        }
        //keep on splitting
        mergeSort(first);
        mergeSort(second);
        merge(a, first, second);
    }
    public static void insertionSort(int[] a)  {
        for(int i = 1; i < a.length; i++) {
            //store current value to be later set in correct place
            int current = a[i];
            int update = i - 1;
            //set all values in previous positions one position above (only if current value is less than them)
            while(update >= 0 && a[update] > current) {
                a[update+1] = a[update];
                update -= 1;
            }
            //set the current value where it needs to be
            a[update + 1] = current;
        }
    }
    public static void swap(int[] arr, int indexOfFirst, int indexOfSecond) {
        int temp = arr[indexOfFirst];
        arr[indexOfFirst] = arr[indexOfSecond];
        arr[indexOfSecond] = temp;
    }
    public static void cocktailSort(int[] a) {
        boolean swapped = true;
        int start = 0;
        int end = a.length;

        while (swapped == true) {
            // reset
            swapped = false;

            // put biggest number where it need to be
            for (int i = start; i < end - 1; i++) {
                if (a[i] > a[i + 1]) {
                    swap(a, i, i + 1);
                    swapped = true;
                }
            }
            // reset
            swapped = false;
            end = end - 1;
            //put the smallest number where it needs to be
            for (int i = end - 1; i >= start; i--) {
                if (a[i] > a[i + 1]) {
                    swap(a, i, i+1);
                    swapped = true;
                }
            }
            start = start + 1;
        }
    }
    public static int binarySearch(int[] a, int numTF) {

        /*int iteration=2;
        for (int i=0; i<a.length; i++) {
            int midPoint=a.length/iteration;

            if
        }*/

        int index = -1;
        int guess = a.length/2;
        int count = 0;
        for(int i = 0; i < a.length; i++)  {
            System.out.println(count);
            if(numTF == a[guess])  {
                index = guess;
                return index;
            } else if(numTF > a[guess])  {
                guess += a.length/((i+1)*4);
            } else if(numTF < a[guess])  {
                guess -= a.length/((i+1)*4);
            }
            count++;
        }
        return index;
    }
    public static int[] randomArrayGen(int length) {
        Random random = new Random(12);
        int[] result = new int[length];
        for(int i = 0; i < result.length; i++)  {
            result[i] = random.nextInt(length);
        }
        return result;
    }

    public static void main(String[] args) {
        //selection sort
        System.out.println("Selection Sort:");
        int[] test = {5, 6, 3, 78, 9};
        System.out.println("Original: " + PrintArray.printArray(test));
        selectionSort(test);
        System.out.println("Sorted: " + PrintArray.printArray(test) + "\n");

        //merge sort
        System.out.println("Merge Sort:");
        int[] test2 = {4, 3, 31, 1, 25, 6};
        System.out.println("Original: " + PrintArray.printArray(test2));
        mergeSort(test2);
        System.out.println("Sorted: " + PrintArray.printArray(test2) + "\n");

        //insertion sort
        System.out.println("Insertion Sort:");
        int[] test3 = {2, 4, 5, 8, 9 , 4, 2, 2, 34, 6};
        System.out.println("Original: " + PrintArray.printArray(test3));
        insertionSort(test3);
        System.out.println("Sorted: " + PrintArray.printArray(test3) + "\n");

        //cocktail sort
        System.out.println("Cocktail Sort:");
        int[] test4 = {2, 5, 8, 0, 4, 2, 1, 3, 6, 9, 5};
        System.out.println("Original: " + PrintArray.printArray(test4));
        cocktailSort(test4);
        System.out.println("Sorted: " + PrintArray.printArray(test4) + "\n");

        //binary search
        System.out.println("Binary Search:");
        int[] test5 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Original: " + PrintArray.printArray(test5));
        System.out.println("Number: " + 8);
        System.out.println("Index Of Number: " + binarySearch(test5, 8) + "\n");

        //binary search with random array
        System.out.println("Binary search with random array");
        //int size = (int)(Math.random() * 1000);
        int[] test6 = randomArrayGen(10000);
        System.out.println("Size of Array: " + 10000);
        System.out.println("Original: " + PrintArray.printArray(test6));
        mergeSort(test6);
        System.out.println("Sorted: " + PrintArray.printArray(test6));
        int r = 3031;//(int)(Math.random() * 10000);
        System.out.println("Number: " + r);
        System.out.println("Index Of Number: " + binarySearch(test6, r) + "\n");
    }
}