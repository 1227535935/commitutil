package utils.sort;

import java.util.Arrays;

/**
 * create by Stewart on 2018/12/19
 *
 * @Descripe
 */
public class MergeSort {
    public static int[] getSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new RuntimeException("arr is null");
        }
        if(arr.length<2){
            return arr;
        }
        int middle = (int) Math.floor(arr.length/2);
        int[] left = Arrays.copyOfRange(arr,0 ,middle);
        int[] right = Arrays.copyOfRange(arr,middle,arr.length);
        int[] sortleft = getSort(left);
        int[] sortright = getSort(right);
        return merge(sortleft,sortright);
    }

    private static int[] merge(int[] left, int[] right){
        int[] result = new int[left.length+right.length];
        int i=0;
        while(left.length>0 && right.length>0){
             if(left[0] <= right[0]){
                 result[i++] = left[0];
                 left = Arrays.copyOfRange(left,1 ,left.length);
             }else {
                 result[i++] = right[0];
                 right = Arrays.copyOfRange(right,1,right.length);
             }
        }

        while(left.length>0){
            result[i++] = left[0];
            left = Arrays.copyOfRange(left,1,left.length);
        }

        while(right.length>0){
            result[i++] = right[0];
            right = Arrays.copyOfRange(right,1,right.length);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 21, 23, 1, 3, 22, 12, 2, 14};
        int[] integers = Arrays.copyOf(arr, arr.length);
        int[] order = getSort(integers);
        System.err.println(order);
    }
}
