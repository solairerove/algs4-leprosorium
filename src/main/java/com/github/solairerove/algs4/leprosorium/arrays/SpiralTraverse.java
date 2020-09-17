package com.github.solairerove.algs4.leprosorium.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {
    public static void main(String[] args) {
        int[][] a = new int[][]{
                {1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9, 8, 7}
        };

        System.out.println(spiralTraverse(a));
    }

    private static List<Integer> spiralTraverse(int[][] a) {
        var res = new ArrayList<Integer>();
        int startRow = 0, endRow = a.length - 1;
        int startCol = 0, endCol = a[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {
            for (int col = startCol; col <= endCol; col++)
                res.add(a[startRow][col]);

            for (int row = startRow + 1; row <= endRow; row++)
                res.add(a[row][endCol]);

            for (int col = endCol - 1; col >= startCol; col--) {
                if (startRow == endRow) break;
                res.add(a[endRow][col]);
            }

            for (int row = endRow - 1; row > startRow; row--) {
                if (startCol == endCol) break;
                res.add(a[row][startCol]);
            }

            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }

        return res;
    }
}
