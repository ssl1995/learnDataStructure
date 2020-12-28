package ssl.排序.shellSort;


public class ShellSort {
    private ShellSort() {
    }

    // 希尔排序1：三重循环
    public static <E extends Comparable<E>> void shellSort1(E[] arr) {
        // 希尔的步长
        int step = arr.length / 2;
        while (step >= 1) {
            // start是每个子数组的起始位置
            for (int start = 0; start < step; start++) {
                // 以下是使用插入排序
                // 对每个子数组进行插入排序:data[start+step,start+2h...data.length-1]
                for (int i = start + step; i < arr.length; i += step) {
                    E temp = arr[i];
                    int j;
                    // 前一个元素是j-step
                    for (j = i; j - step >= 0 && temp.compareTo(arr[j - step]) < 0; j -= step) {
                        arr[j] = arr[j - step];
                    }
                    arr[j] = temp;
                }
            }
            step = step / 2;
        }
    }

    // 希尔排序2:二重循环，背这个版本
    public static <E extends Comparable<E>> void shellSort2(E[] arr) {
        // 希尔的步长
        int step = arr.length / 2;
        while (step >= 1) {
            // 对每个子数组进行插入排序:data[start+h,start+2h...data.length-1]
            for (int i = step; i < arr.length; i++) {
                E temp = arr[i];
                int j;
                // 前一个元素是j-step
                for (j = i; j - step >= 0 && temp.compareTo(arr[j - step]) < 0; j -= step) {
                    arr[j] = arr[j - step];
                }
                arr[j] = temp;
            }
            step = step / 2;
        }
    }

    // 希尔排序3：修改步长序列
    public static <E extends Comparable<E>> void shellSort3(E[] arr) {
        // 希尔的步长
        int step = 1;
        while (step < arr.length) {
            step = step * 3 + 1;
        }
        while (step >= 1) {
            // 对每个子数组进行插入排序:data[start+h,start+2h...data.length-1]
            for (int i = step; i < arr.length; i++) {
                E temp = arr[i];
                int j;
                // 前一个元素是j-step
                for (j = i; j - step >= 0 && temp.compareTo(arr[j - step]) < 0; j -= step) {
                    arr[j] = arr[j - step];
                }
                arr[j] = temp;
            }
            step = step / 3;
        }
    }
}
