package utils.sort;

import java.util.Arrays;

/**
 * create by Stewart on 2018/12/19
 *
 * @Descripe 插入排序
 * 说明：从第二个元素开始插入，第i个元素插入时，左侧i-1个元素都是有序的，
 * 即第i元素与i-1有序队列比较（从小到大比较则找到第一个比i元素大的前一位置，从大到小顺序则找第一个i元素比其小的前一位置）
 * （1，3，5，2，6，4）
 */
public class InsertSort {

    /**
     * 自己写的
     **/
    public static int[] getSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new RuntimeException("arr is null");
        }
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            for (int j = i; j > 0; j--) {   //设置为小到大，循环一个个比较（冒泡）
                if (temp < arr[j - 1]) {
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
        return arr;
    }

    /** 网上的**/
    public int[] sort(int[] sourceArray) throws Exception {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        // 从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int i = 1; i < arr.length; i++) {

            // 记录要插入的数据
            int tmp = arr[i];

            // 从已经排序的序列最右边的开始比较，找到比其小的数
            int j = i;
            while (j > 0 && tmp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }

            // 存在比其小的数，插入
            if (j != i) {
                arr[j] = tmp;
            }

        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 21, 23, 1, 3, 22, 12, 2, 14};
        int[] integers = Arrays.copyOf(arr, arr.length);
        int[] order = getSort(integers);
        System.err.println(order);
    }
}
