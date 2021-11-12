package Graph;

// https://leetcode.com/problems/walls-and-gates/
// 286
// BFS

import java.util.*;

public class WallsAndGates {
    public class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void wallsAndGates(int[][] rooms) {
        LinkedList<Node> queue = new LinkedList<>();
        Stack<Node> gates = new Stack<>();
        int xMax = rooms.length;
        int yMax = rooms[0].length;
        for (int i=0; i<rooms.length; ++i) {
            for (int j=0; j<rooms[i].length; ++j) {
                if (rooms[i][j] == 0) gates.add(new Node(i,j));
            }
        }

        while (!gates.isEmpty()) {
            boolean[][] visited = new boolean[xMax][yMax];
            int[][] dist = new int[xMax][yMax];
            Node gate = gates.pop();
            queue.add(gate);
            visited[gate.x][gate.y] = true;
            dist[gate.x][gate.y] = 0;
            while (!queue.isEmpty()) {
                Node n = queue.poll();
                if (n.x-1 >= 0 && n.x-1 < xMax && !visited[n.x-1][n.y] && rooms[n.x-1][n.y] != 0 && rooms[n.x-1][n.y] != -1) {
                    visited[n.x-1][n.y] = true;
                    dist[n.x-1][n.y] = dist[n.x][n.y] + 1;
                    rooms[n.x-1][n.y] = Math.min(rooms[n.x-1][n.y], dist[n.x-1][n.y]);
                    queue.add(new Node(n.x-1, n.y));
                }
                if (n.x+1 >= 0 && n.x+1 < xMax && !visited[n.x+1][n.y] && rooms[n.x+1][n.y] != 0 && rooms[n.x+1][n.y] != -1) {
                    visited[n.x+1][n.y] = true;
                    dist[n.x+1][n.y] = dist[n.x][n.y] + 1;
                    rooms[n.x+1][n.y] = Math.min(rooms[n.x+1][n.y], dist[n.x+1][n.y]);
                    queue.add(new Node(n.x+1, n.y));
                }
                if (n.y+1 >= 0 && n.y+1 < yMax && !visited[n.x][n.y+1] && rooms[n.x][n.y+1] != 0 && rooms[n.x][n.y+1] != -1) {
                    visited[n.x][n.y+1] = true;
                    dist[n.x][n.y+1] = dist[n.x][n.y] + 1;
                    rooms[n.x][n.y+1] = Math.min(rooms[n.x][n.y+1], dist[n.x][n.y+1]);
                    queue.add(new Node(n.x, n.y+1));
                }
                if (n.y-1 >= 0 && n.y-1 < yMax && !visited[n.x][n.y-1] && rooms[n.x][n.y-1] != 0 && rooms[n.x][n.y-1] != -1) {
                    visited[n.x][n.y-1] = true;
                    dist[n.x][n.y-1] = dist[n.x][n.y] + 1;
                    rooms[n.x][n.y-1] = Math.min(rooms[n.x][n.y-1], dist[n.x][n.y-1]);
                    queue.add(new Node(n.x, n.y-1));
                }
            }
        }
    }
}
