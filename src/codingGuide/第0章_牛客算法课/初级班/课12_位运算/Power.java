package codingGuide.第0章_牛客算法课.初级班.课12_位运算;

public class Power {
    // 是不是2的幂
    public static boolean is2Power(int n) {

        return (n & (n - 1)) != 0;
    }

    // 是不是4的幂
    public static boolean is4Power(int n) {

        return (n & (n - 1)) != 0 && (n & 0x55555555) != 0;
    }

}
