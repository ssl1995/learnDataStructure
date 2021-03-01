package LeetCode.LeetCode88;

import java.util.Arrays;

// 合并两个有序数组
public class Solution {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m + n];
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
        for (int j = 0; j < temp.length; j++) {
            nums1[j] = temp[j];
        }
    }

    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int[] copy = new int[m];
        System.arraycopy(nums1, 0, copy, 0, m);
        int p = 0, q = 0, i = 0;
        // 从前往后找较小的放入nums1中
        while (p < m && q < n) {
            nums1[i++] = copy[p] < nums2[q] ? copy[p++] : nums2[q++];
        }
        if (p < m) {
            System.arraycopy(copy, p, nums1, p + q, m + n - p - q);
        }
        if (q < n) {
            System.arraycopy(nums2, q, nums1, p + q, m + n - p - q);
        }
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p = m - 1, q = n - 1, i = m + n - 1;
        // 从后往前找大的放入nums1中
        while (p >= 0 && q >= 0) {
            nums1[i--] = nums1[p] < nums2[q] ? nums2[q--] : nums1[p--];
        }
        //System.arraycopy(nums2, 0, nums1, 0, q + 1);
        for (int j = 0; j < q + 1; j++) {
            nums1[j] = nums2[j];
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 0, 0};
        int[] arr2 = {0, 0, 0};
        System.arraycopy(arr1, 0, arr2, 0, 3);
        System.out.println(Arrays.toString(arr2));
    }
}
