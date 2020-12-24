package ssl.排序.shellSort;

import ssl.排序.helpUtils.ArrayGenerator;
import ssl.排序.helpUtils.SortingHelper;

import java.util.Arrays;

public class ShellSort {
    private ShellSort() {
    }

    // 希尔排序1：三重循环
    public static <E extends Comparable<E>> void shellSort1(E[] data) {
        // h希尔的步长
        int h = data.length / 2;
        while (h >= 1) {
            // start是每个子数组的起始位置
            for (int start = 0; start < h; start++) {
                // 以下是使用插入排序
                // 对每个子数组进行插入排序:data[start+h,start+2h...data.length-1]
                for (int i = start + h; i < data.length; i += h) {
                    E temp = data[i];
                    int j;
                    // 前一个元素是j-h
                    for (j = i; j - h >= 0 && temp.compareTo(data[j - h]) < 0; j -= h) {
                        data[j] = data[j - h];
                    }
                    data[j] = temp;
                }
            }
            h = h / 2;
        }
    }

    // 希尔排序2:二重循环
    public static <E extends Comparable<E>> void shellSort2(E[] data) {
        // h希尔的步长
        int h = data.length / 2;
        while (h >= 1) {
            // 对每个子数组进行插入排序:data[start+h,start+2h...data.length-1]
            for (int i = h; i < data.length; i++) {
                E temp = data[i];
                int j;
                // 前一个元素是j-h
                for (j = i; j - h >= 0 && temp.compareTo(data[j - h]) < 0; j -= h) {
                    data[j] = data[j - h];
                }
                data[j] = temp;
            }
            h = h / 2;
        }
    }

    // 希尔排序3：修改步长序列
    public static <E extends Comparable<E>> void shellSort3(E[] data) {
        // h希尔的步长
        int h = 1;
        while (h < data.length) {
            h = h * 3 + 1;
        }
        while (h >= 1) {
            // 对每个子数组进行插入排序:data[start+h,start+2h...data.length-1]
            for (int i = h; i < data.length; i++) {
                E temp = data[i];
                int j;
                // 前一个元素是j-h
                for (j = i; j - h >= 0 && temp.compareTo(data[j - h]) < 0; j -= h) {
                    data[j] = data[j - h];
                }
                data[j] = temp;
            }
            h = h / 3;
        }
    }
}
