package ssl.排序.bucketSort;


public class BucketSort {
    // 桶排序：又叫计数排序
    public static void bucketSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 1.从所有数中找出最大值
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        // 2.生成max+1个元素的桶数组，因为[0.max]有max+1的元素
        int[] bucket = new int[max + 1];
        // 3.遍历数组，每个元素出现的个数加入桶
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }
        // 4.遍历桶，将非0数据放回原数组
        int i = 0;// i遍历数组
        for (int j = 0; j < bucket.length; j++) {
            while (bucket[j]-- > 0) {
                arr[i++] = j;
            }
        }
    }
}
