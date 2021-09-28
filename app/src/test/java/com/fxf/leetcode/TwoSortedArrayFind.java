package com.fxf.leetcode;


/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到 下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断 数组中是否含有该整数
 */
class TwoSortedArrayFind {


    public void f(int col,int row,int n){
        for (int i=row-1,j=col+1;i>0 && j< n;i++,j--){

        }
    }

        public boolean find(int[][] matrix, int number) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1){
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = 0;
        int col = cols - 1;
        while (row < rows && col >= 0){
            if (matrix[row][col] == number) {
                return true;
            } else if (matrix[row][col] < number){
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}