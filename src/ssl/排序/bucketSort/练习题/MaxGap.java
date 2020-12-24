package ssl.排序.bucketSort.练习题;


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
        // 2.生成3个桶，长度为n+1,要留出一个空桶
        boolean[] hasNum = new boolean[len + 1];
        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];
        // 3.最大值桶只放区间最大值，最小值桶只放区间最小值
        int bid = 0;// 桶id
        for (int i = 0; i < len; i++) {
            bid = bucket(nums[i], len, min, max);
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], nums[i]) : nums[i];
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], nums[i]) : nums[i];
            hasNum[bid] = true;
        }
        // 4.持续比较其一个桶的max - 后一个桶的min的值
        int res = 0;
        int lastMax = maxs[0];
        int i = 1;
        for (; i <= len; i++) {
            if (hasNum[i]) {
                // 其一个桶的max - 后一个桶的min的值
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;
    }

    // 找出nums[i]属于哪个桶
    public static int bucket(long num, long len, long min, long max) {
        // (向下取整) (当前数-最小值)/ [(max-min)/len]
        return (int) ((num - min) * len / (max - min));
    }
}
