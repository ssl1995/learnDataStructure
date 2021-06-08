package leetCode.LeetCode200;

public class Solution {

    public int numIslands(char[][] grid) {
        if (grid == null || grid[0] == null) {
            return 0;
        }
        int M = grid.length;
        int N = grid[0].length;
        int res = 0;
        // 遍历二维数组，遇到'1'就次数+1,并且开始运行感染函数
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    infect(grid, i, j, M, N);
                }
            }
        }
        return res;
    }

    private void infect(char[][] arr, int i, int j, int M, int N) {
        // 停止递归:下标越界或者没遇到'1'
        if (i < 0 || i >= M || j < 0 || j >= N || arr[i][j] != '1') {
            return;
        }
        // 没越界，就感染
        arr[i][j] = '2';
        infect(arr, i + 1, j, M, N);
        infect(arr, i - 1, j, M, N);
        infect(arr, i, j + 1, M, N);
        infect(arr, i, j - 1, M, N);
    }
}
