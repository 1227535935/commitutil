package utils.sort;

import java.util.Arrays;

/**
 * create by Stewart on 2018/12/19
 *
 * @author Administrator
 * @Descripe 快速排序
 */
public class QuickSort {
    public static int[] getSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new RuntimeException("arr is null");
        }
        return quickSort(arr, 0, arr.length - 1);
    }

    private static int[] quickSort(int arr[], int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    private static int partition(int arr[], int left, int right) {
        int pivot = left;
        int index = pivot +1;
        for(int i=index;i<=right;i++){
            if(arr[i]<arr[pivot]){
                swap(arr,i,index);
                index++;
            }
        }
        swap(arr,pivot,index-1);
        return index-1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 21, 23, 1, 3, 22, 12, 2, 14};
        int[] integers = Arrays.copyOf(arr, arr.length);
        int[] order = getSort(integers);
        System.err.println(order);
    }
}
