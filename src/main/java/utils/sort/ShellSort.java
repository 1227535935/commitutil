package utils.sort;

import java.util.Arrays;

/**
 * create by Stewart on 2018/12/19
 *
 * @Descripe 希尔排序
 * 说明：选择一个增量序列 t1，t2，……，tk，其中 ti > tj, tk = 1；
 * 增量一般是gap*3+1,但是小于length，gap/3做循环
 * 按增量序列个数 k，对序列进行 k 趟排序；
 * <p>
 * 每趟排序，根据对应的增量 ti，将待排序列分割成若干长度为 m 的子序列，
 * 分别对各子表进行直接插入排序。仅增量因子为 1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
 */
public class ShellSort {

    public static int[] getSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new RuntimeException("arr is null");
        }
        int gap = 1;
        while (gap < arr.length) {  // 10 /4
            gap = gap * 3 + 1;
        }
        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {    //4-10
                int temp = arr[i];
                int j = i - gap;
                while (j >= 0 && temp < arr[j]) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = temp;
            }
            gap = (int) Math.floor(gap / 3);
        }

        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                int temp = arr[i];
                int j = i - gap;
                while (j >= 0 && temp < arr[j]) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = temp;
            }
            gap = (int) Math.floor(gap / 3);
        }

        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                int temp = arr[i];
                int j = i - gap;
                while (j >= 0 && temp < arr[j]) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = temp;
            }
            gap = (int) Math.floor(gap / 3);
        }


        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 21, 23, 1, 3, 22, 12, 2, 14, 9};
        int[] integers = Arrays.copyOf(arr, arr.length);
        int[] order = getSort(integers);
        System.err.println(order);
    }
}
