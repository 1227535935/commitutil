package utils.sort;

import java.util.Arrays;

/**
 * create by Stewart on 2018/12/19
 *
 * @Descripe 选择排序
 * 说明：先讲所有元素中的最小元素选出排在首位，再从剩余元素中选出最小元素排在已排序元素的末尾，循环此操作
 *  （把最小的一个个挑出来拍好）
 * 循环说明：假设倒序情况下，A(m/m-1)
 */
public class SelectSort {

    /**
     * 自己写的（多交换了好多次）
     * @param arr
     * @return
     */
    public static int[] getSort(int[] arr){
        if(arr == null || arr.length == 0){
            throw new RuntimeException("arr is null");
        }
        for(int i=0;i<arr.length-1;i++){

            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    int temp;
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * 网上写的
     * @param arr
     */
    public static int[] getSort2(int[] arr){
        if(arr == null || arr.length == 0){
            throw new RuntimeException("arr is null");
        }
        for(int i=0;i<arr.length-1;i++){
            int min=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[min]>=arr[j]){
                    min =j;
                }
            }
            int temp;
            temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,21,53,1,3,52};
        int[] integers = Arrays.copyOf(arr, arr.length);
        int[] order = getSort2(integers);
        System.err.println(order);
    }
}
