class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Deque<int[]> deque = new ArrayDeque<>();
        int[][] cost = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }
        deque.offerFirst(new int[]{0, 0});
        cost[0][0] = 0;

        while (!deque.isEmpty()) {
            int[] cell = deque.pollFirst();
            int x = cell[0];
            int y = cell[1];

            for (int dir = 0; dir < 4; dir++) {
                int newX = x + directions[dir][0];
                int newY = y + directions[dir][1];
                int newCost = cost[x][y] + (grid[x][y] == dir + 1 ? 0 : 1);

                if (newX >= 0 && newX < m && newY >= 0 && newY < n && newCost < cost[newX][newY]) {
                    cost[newX][newY] = newCost;

                    if (grid[x][y] == dir + 1) {
                        deque.offerFirst(new int[]{newX, newY});
                    } else {
                        deque.offerLast(new int[]{newX, newY});
                    }
                }
            }
        }
        return cost[m - 1][n - 1];
    }
}