package utils.sort;

import java.util.Arrays;

/**
 * create by Stewart on 2018/12/18
 *
 * @Descripe 冒泡排序
 * 说明：比较相邻两个的大小，按排序顺序排列
 * 循环说明：两个循环（1.所有元素循环(最后一个元素不需要循环，length+1越界)  2.每个元素次数循环）
 *                      0-(length-1)                                    length-i-1(i是元素位，因为数组从0开始，所有要多减一)
 *
 */
public class BubbleSort {

    public static Integer[] getSort(Integer[] arr){
        if(arr == null || arr.length == 0){
            throw new RuntimeException("arr is null");
        }
       for(int i=1;i<arr.length;i++){
           for (int j=0;j<arr.length-i;j++){
               if(arr[j]<arr[j+1]){
                   Integer temp;
                   temp = arr[j] ;
                   arr[j] = arr[j+1];
                   arr[j+1] = temp;
               }
           }
       }
        return arr;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{4,21,53,1,3,52};
        Integer[] integers = Arrays.copyOf(arr, arr.length);
        Integer[] order = getSort(integers);
        System.err.println(order);
    }
}
