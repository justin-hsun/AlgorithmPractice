package Backtracking;

// 79
// https://leetcode.com/problems/word-search/
// recursive bfs with backtracking
// key: visited = true, if dfs(next) == false -> visited = false

import java.util.*;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int i=0; i<board.length; ++i) {
            for (int j=0; j<board[0].length; ++j) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    if (dfs(board, word, visited, i, j, 0)) return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, boolean[][] visited, int i, int j, int index) {
        if (i >=0 && i < board.length && j >=0 && j < board[0].length && !visited[i][j]) {
            if (board[i][j] == word.charAt(index)) {
                //System.out.println(i + " " + j);
                visited[i][j] = true;
                if (index == word.length()-1) return true;
                boolean res = dfs(board, word, visited, i-1, j, index+1) || dfs(board, word,visited, i, j-1, index+1) || dfs(board, word,visited, i+1, j, index+1) || dfs(board,word, visited, i, j+1, index+1);
                if (res) return res;
                else visited[i][j] = false;
            }
        }
        return false;

    }
}
