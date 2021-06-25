package leetCode.LeetCode88;


// 合并两个有序数组
public class Solution {

    // 方法1:双指针,从前往后遍历两个数组,需要辅助数组
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        // temp存储每次排序好的数组
        int[] temp = new int[m + n];
        // p遍历nums1,q遍历nums2,i遍历temp
        int p = 0, q = 0, i = 0;
        while (p < m && q < n) {
            temp[i++] = nums1[p] < nums2[q] ? nums1[p++] : nums2[q++];
        }
        while (p < m) {
            temp[i++] = nums1[p++];
        }
        while (q < n) {
            temp[i++] = nums2[q++];
        }
        // 将temp数组遍历回nums1
        System.arraycopy(temp, 0, nums1, 0, m + n);
    }

    // 方法2:双指针,从后往前遍历两个数组,放最大,不需要辅助数组
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p = m - 1, q = n - 1, i = m + n - 1;
        // 从后往前找大的放入nums1中
        while (p >= 0 && q >= 0) {
            nums1[i--] = nums1[p] < nums2[q] ? nums2[q--] : nums1[p--];
        }
        // p<0上面遍历结束,此时q还没遍历到0,将nums2从[0,q+1)复制到nums1中
        System.arraycopy(nums2, 0, nums1, 0, q + 1);
    }
}
