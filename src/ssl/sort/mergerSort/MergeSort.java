package ssl.sort.mergerSort;


import java.util.Arrays;

public class MergeSort {
    private MergeSort() {
    }

    public static <E extends Comparable<E>> void mergeSort(E[] arr) {

        mergeSort(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void mergeSort(E[] arr, int l, int r) {
        // 递归结束条件
        if (l >= r) {
            return;
        }
        // 分治
        int mid = l + (r - l) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        // 归并
        merge(arr, l, mid, r);
    }

    // 归并merger：已知两个有序的A和B数组，将A和B合并成有序数组
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r) {
        // 归并辅助函数，辅助数组从0开始的，原数组arr是从l开始
        E[] temp = Arrays.copyOfRange(arr, l, r + 1);
        // i遍历原数组,i1,i2遍历辅助数组
        int i1 = l, i2 = mid + 1;
        for (int i = l; i <= r; i++) {
            // i>mid，左边部分遍历比较完毕
            if (i1 > mid) {
                // 注意temp数组是从0开始的，temp都需要-l才是原值
                arr[i] = temp[i2++ - l];
            } else if (i2 > r) {
                arr[i] = temp[i1++ - l];
            }// 单路归并左边<=v,右边>v
            else if (temp[i1 - l].compareTo(temp[i2 - l]) <= 0) {
                arr[i] = temp[i1++ - l];
            } else {
                arr[i] = temp[i2++ - l];
            }
        }
    }

    // merge1是比较好背的归并代码，但是多了一个复制回原数组的过程
    private static <E extends Comparable<E>> void merge1(E[] arr, int l, int mid, int r) {
        E[] temp = Arrays.copyOfRange(arr, l, r + 1);
        int i = 0;
        int i1 = l, i2 = mid + 1;
        while (i1 <= mid && i2 <= r) {
            temp[i++] = arr[i1].compareTo(arr[i2]) < 0 ? arr[i1++] : arr[i2++];
        }
        while (i1 <= mid) {
            temp[i++] = arr[i1++];
        }
        while (i2 <= r) {
            temp[i++] = arr[i2++];
        }
        // 最后记得复制回原数组
        for (int k = 0; k < temp.length; k++) {
            arr[l + k] = temp[k];
        }
    }

}
