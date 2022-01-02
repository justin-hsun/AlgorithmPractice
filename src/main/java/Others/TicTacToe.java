package Others;

// 348
// https://leetcode.com/problems/design-tic-tac-toe/

public class TicTacToe {

    int n;
    int[] p1rows;
    int[] p1cols;
    int[] p2rows;
    int[] p2cols;

    int[] p1dias = new int[2];
    int[] p2dias = new int[2];

    public TicTacToe(int n) {
        this.n = n;
        p1rows = new int[n];
        p1cols = new int[n];
        p2rows = new int[n];
        p2cols = new int[n];
    }

    public int move(int row, int col, int player) {
        if (player == 1) {
            p1rows[row] += 1;
            p1cols[col] += 1;
            if (row == col) p1dias[0] += 1;
            if (row + col == n-1) p1dias[1] += 1;
            return (p1rows[row] == n) || (p1cols[col] == n) || (p1dias[0] == n) || (p1dias[1] == n) ? player : 0;
        } else {
            p2rows[row] += 1;
            p2cols[col] += 1;
            if (row == col) p2dias[0] += 1;
            if (row + col == n-1) p2dias[1] += 1;
            return (p2rows[row] == n) || (p2cols[col] == n) || (p2dias[0] == n) || (p2dias[1] == n) ? player : 0;
        }
    }
}
