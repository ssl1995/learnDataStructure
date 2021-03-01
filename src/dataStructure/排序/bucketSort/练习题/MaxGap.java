package dataStructure.排序.bucketSort.练习题;


public class MaxGap {

    public static int maxGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        // 1.找出数组中最大值和最小值
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        if (min == max) {
            return 0;
        }
        // 2.生成3个桶，长度为n+1,目的是留出一个空桶
        boolean[] hasNum = new boolean[len + 1];
        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];
        // 3.最大值桶只放区间最大值，最小值桶只放区间最小值
        int bid = 0;// 桶id用于遍历
        for (int i = 0; i < len; i++) {
            bid = bucket(nums[i], len, min, max);
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], nums[i]) : nums[i];
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], nums[i]) : nums[i];
            hasNum[bid] = true;
        }
        // 4.持续比较其一个桶的max - 后一个桶的min的值
        int res = 0;
        int lastMax = maxs[0];
        for (int i = 1; i <= len; i++) {
            if (hasNum[i]) {
                // 前一个桶的max - 后一个桶的min的值的差值，和当前差值作比较，选最大值
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;
    }

    // 找出nums[i]属于哪个桶
    public static int bucket(long num, long len, long min, long max) {
        // (当前数-最小值)/ [(max-min)/len+1]，把len+1变成len = 向下取整
        return (int) ((num - min) * len / (max - min));
    }
}
