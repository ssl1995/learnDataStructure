package 剑指Offer.递归.剑指Offer64_求1加到n;

public class Solution {

    // 不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句
    public int sumNums(int n) {
        // n=1时停止递归,使用逻辑与短路完成
        // java中,A&&B<需要一个返回值接受,否则单独返回会拨错
        // java中,A&&B两边必须为判断语句,由于sumNums必为>0的数,所以用>0完善语法
        boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
        // 返回n
        return n;
    }

    // 常见求和递归
    private int sumN(int n) {
        // 当n=1时停止递归
        if (n == 1) {
            return 1;
        }
        // sum=n+fun(n-1)=n+n-1+fun(n-2)依次类推
        n += sumN(n - 1);
        return n;
    }
}
