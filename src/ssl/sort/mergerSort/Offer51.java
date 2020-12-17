package ssl.sort.mergerSort;

public class Offer51 {
    private int res;

    // 归并排序法，原理是利用nums[i]>nums[j],那么[i,mid]中都是逆序对个数
    public int reversePairs(int[] nums) {
        int[] temp = new int[nums.length];
        res = 0;
        sort(nums, 0, nums.length - 1, temp);
        return res;
    }

    private void sort(int[] nums, int l, int r, int[] temp) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        sort(nums, l, mid, temp);
        sort(nums, mid + 1, r, temp);
        // >保证了，如果j位置小于i位置的，左边未排序中的肯定是逆序对
        if (nums[mid] > nums[mid + 1]) {
            merge(nums, l, mid, r, temp);
        }
    }

    private void merge(int[] nums, int l, int mid, int r, int[] temp) {
        System.arraycopy(nums, l, temp, l, r - l + 1);
        int i = l, j = mid + 1;
        // 每轮循环为 arr[k] 赋值
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                nums[k] = temp[j++];
            } else if (j > r) {
                nums[k] = temp[i++];
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i++];
            } else {
                // 判断逆序对条件：temp[i]>temp[j]
                res += mid - i + 1;
                nums[k] = temp[j++];
            }
        }
    }
}
