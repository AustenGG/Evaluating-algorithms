package com.company;
import java.util.Arrays;
import java.time.Instant;

public class Quicksort {
    public static void main(String[] args) {
        int[] x = { 9, 2, 3, 10, 1, 4, 7 };
        System.out.println(Arrays.toString(x));
        long initiated =   Instant.now().toEpochMilli();
        System.out.println(("TIme initiated: " + initiated));
        int low = 0;
        int high = x.length - 1;

        quickSort(x, low, high);
        System.out.println(Arrays.toString(x));
        long complete =   Instant.now().toEpochMilli();
        System.out.println(("TIme completed: " + complete));
        long taken = complete-initiated;
        System.out.println("Time taken: " + taken + "ms");
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0)
            return;

        if (low >= high)
            return;

        int middle = low + (high - low) / 2; // picking the pivot
        int pivot = arr[middle];

        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        // recursively sort two sub parts
        if (low < j)
            quickSort(arr, low, j);

        if (high > i)
            quickSort(arr, i, high);
    }

}