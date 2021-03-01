package ssl.排序.radixSort;


public class LC75 {
    // 力扣75题：
    public void sortColors(int[] nums) {
        int[] cnt = new int[3];
        // nums[i]对应arr[X]索引的元素个数
        for (int num : nums) {
            cnt[num]++;
        }
        // 存放0位置
        // nums[0,cnt-1]=0
        for (int i = 0; i < cnt[0]; i++) {
            nums[i] = 0;
        }
        // 存放1位置
        // nums[cnt[0],cnt[0]+cnt[1]]=1
        for (int i = cnt[0]; i < cnt[0] + cnt[1]; i++) {
            nums[i] = 1;
        }
        // 存放2位置
        // nums[cnt[0]+cnt[1],n-1]
        for (int i = cnt[0] + cnt[1]; i < nums.length; i++) {
            nums[i] = 2;
        }
    }

    // 基数排序通用写法
    public void sortColors1(int[] nums) {
        // 1.指定处理元素区间长度R和计数数组cnt，处理元素范围[0,R)的排序
        int R = 3;
        int[] cnt = new int[R];
        for (int num : nums) {
            cnt[num]++;
        }
        // 2.创建index数组，长度为R+1
        int[] index = new int[R + 1];
        for (int i = 0; i < R; i++) {
            // [index[i],index[i+1]]的值为i
            // index[i]表示前i的元素的合
            index[i + 1] = index[i] + cnt[i];
        }
        // 3.业务逻辑代码
        for (int i = 0; i + 1 < index.length; i++) {
            for (int j = index[i]; j < index[i + 1]; j++) {
                nums[j] = i;
            }
        }
    }
}
