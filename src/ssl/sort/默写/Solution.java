package ssl.sort.默写;

import java.util.Random;

/**
 * @Author ssl
 * @Date 2020/12/14 16:35
 * @Description
 */
public class Solution {

    public static <E extends Comparable<E>> void quickSort(E[] arr) {
        Random random = new Random();
        quickSort(arr, 0, arr.length - 1, random);
    }

    private static <E extends Comparable<E>> void quickSort(E[] arr, int l, int r, Random random) {
        if (l >= r) {
            return;
        }
        int p = l+random.nextInt(r - l + 1);
        swap(arr, l, p);
        // 三路快排
        int lt = l, i = l + 1, gt = r + 1;
        while (i < gt) {
            if (arr[i].compareTo(arr[l]) < 0) {
                lt++;
                swap(arr, i, lt);
                i++;
            } else if (arr[i].compareTo(arr[l]) > 0) {
                gt--;
                swap(arr,i,gt);
            }else{
                i++;
            }
        }
        swap(arr,l,lt);
        quickSort(arr,l,lt-1,random);
        quickSort(arr,gt,r,random);
    }


    private static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr1 = {4, 2, 5, 6, 3, 8, 7, 1};
        quickSort(arr1);
        for (Integer num : arr1) {
            System.out.print(num + " ");
        }
    }

}
