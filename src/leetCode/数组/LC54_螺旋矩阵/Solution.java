package leetCode.数组.LC54_螺旋矩阵;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        // 输入空列，返回空数组
        if (matrix.length == 0) {
            return new ArrayList<>();
        }
        // 初始化左上角、右下角坐标
        int tR = 0, tC = 0;
        int dR = matrix.length - 1, dC = matrix[0].length - 1;
        // 结果二维数组大小=原始数组大小
        List<Integer> res = new ArrayList<>();
        // 数组遍历坐标
        while (tR <= dR && tC <= dC) {
            spiralMatrix(matrix, res, tR++, tC++, dR--, dC--);
        }
        return res;
    }

    private void spiralMatrix(int[][] matrix, List<Integer> res, int tR, int tC, int dR, int dC) {
        if (tR == dR) {// 子矩阵只有一行,就复制列
            for (int i = tC; i <= dC; i++) {
                res.add(matrix[tR][i]);
            }
        } else if (tC == dC) {// 子矩阵只有一列,就复制行
            for (int i = tR; i <= dR; i++) {
                res.add(matrix[i][tC]);
            }
        } else {// 一般情况
            // 实现螺旋式顺时针打印
            int curR = tR;
            int curC = tC;
            while (curC != dC) {
                res.add(matrix[tR][curC++]);
            }
            while (curR != dR) {
                res.add(matrix[curR++][dC]);
            }
            while (curC != tC) {
                res.add(matrix[dR][curC--]);
            }
            while (curR != tR) {
                res.add(matrix[curR--][tC]);
            }
        }
    }
}
