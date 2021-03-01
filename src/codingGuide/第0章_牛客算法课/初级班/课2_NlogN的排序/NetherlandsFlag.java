package codingGuide.第0章_牛客算法课.初级班.课2_NlogN的排序;

public class NetherlandsFlag {
    // <=t放左边，>t放右边
    public static void question(int[] arr, int l, int r, int t) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int less = l - 1;
        while (l < r) {
            if (arr[l] <= t) {
                swap(arr, ++less, l++);
            } else {
                l++;
            }
        }
    }

    // 荷兰国旗问题：<t放左边，=t放中间，>t放右边
    public static void netherlandsFlag(int[] arr, int l, int r, int t) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int less = l - 1;
        int more = r + 1;
        while (l < more) {
            if (arr[l] < t) {
                swap(arr, ++less, l++);
            } else if (arr[l] > t) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
