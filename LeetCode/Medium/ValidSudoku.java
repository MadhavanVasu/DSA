package LeetCode.Medium;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        Set<Character> numSet1;
        Set<Character> numSet2;

        // Row and Column check
        for (int i = 0; i < 9; i++) {
            numSet1 = new HashSet<>();
            numSet2 = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (numSet1.contains(board[i][j]))
                    return false;
                if (numSet2.contains(board[j][i]))
                    return false;
                if (board[i][j] != '.')
                    numSet1.add(board[i][j]);
                if (board[j][i] != '.')
                    numSet2.add(board[j][i]);
            }
        }

        // 3 x 3 grid check
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                numSet1 = new HashSet<>();
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        if (numSet1.contains(board[i + x][j + y]))
                            return false;
                        if (board[i + x][j + y] != '.')
                            numSet1.add(board[i + x][j + y]);
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(isValidSudoku(board));
    }
}
