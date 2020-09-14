package com.github.solairerove.algs4.leprosorium.arrays;

import java.util.HashSet;
import java.util.Set;

/*
Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

1) Each row must contain the digits 1-9 without repetition.
2) Each column must contain the digits 1-9 without repetition.
3) Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'
*/
public class SudokuCheck {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        boolean res = isValidSudoku(board);

        System.out.println(res);
    }

    private static boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (!isUnique(board[i][j], set) || !isUnique(board[j][i], set)) {
                    return false;
                }
            }
            set = new HashSet<>();
        }
        return true;
    }

    private static boolean isUnique(char current, Set<Character> set) {
        return current == '.' || set.add(current);
    }
}
