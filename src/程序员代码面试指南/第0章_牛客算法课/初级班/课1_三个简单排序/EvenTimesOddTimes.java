package 程序员代码面试指南.第0章_牛客算法课.初级班.课1_三个简单排序;

public class EvenTimesOddTimes {
    // Q1:一个数为奇数次，其他数为偶数次
    public static int question1(int[] arr) {
        int res = 0;
        for (int cur : arr) {
            res ^= cur;
        }
        return res;
    }

    // Q2:两个数为奇数次，其他数为偶数次
    public static void question2(int[] arr) {
        int a = 0, b = 0;
        for (int cur : arr) {
            // 次数的a = 数1^数2
            a ^= cur;
        }
        // 把a中最右侧的1提取出来
        int rightOne = a & (~a + 1);
        for (int cur : arr) {
            if ((rightOne & cur) == 1) {
                b ^= cur;
            }
        }
        a ^= b;
        System.out.println("数1:" + a);
        System.out.println("数2:" + b);
    }
}
