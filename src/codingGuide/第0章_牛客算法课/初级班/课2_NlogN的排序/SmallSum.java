package codingGuide.第0章_牛客算法课.初级班.课2_NlogN的排序;

public class SmallSum {
    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return smallSum(arr, 0, arr.length - 1);
    }

    private static int smallSum(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + (r - l) / 2;
        return // 左右两边排序，并且求小和
                smallSum(arr, l, mid) + smallSum(arr, mid + 1, r)
                        // 左右两边归并，并且求小和
                        + merge(arr, l, mid, r);
    }

    private static int merge(int[] arr, int l, int mid, int r) {
        int[] temp = new int[r - l + 1];
        int i = 0, p = l, q = mid + 1;
        int res = 0;
        while (p <= mid && q <= r) {
            // 求小和关键：右大于左，小和=arr[l]*(右边大于的长度)
            res += arr[p] < arr[q] ? arr[p] * (r - q + 1) : 0;
            temp[i++] = arr[p] < arr[q] ? arr[p++] : arr[q++];
        }
        while (p <= mid) {
            temp[i++] = arr[p++];
        }
        while (q <= r) {
            temp[i++] = arr[q++];
        }
        for (int j = 0; j < temp.length; j++) {
            arr[l + j] = temp[j];
        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 5};
        System.out.println(smallSum(arr));
    }

}
