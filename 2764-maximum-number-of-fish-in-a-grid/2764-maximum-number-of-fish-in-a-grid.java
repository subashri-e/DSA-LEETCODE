class Solution {
    public int findMaxFish(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int maxFish = 0;

        boolean[][] visited = new boolean[m][n];
        int[] directions = {-1, 0, 1, 0, -1};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0 && !visited[i][j]) {
                    maxFish = Math.max(maxFish, dfs(grid, visited, i, j, directions));
                }
            }
        }
        return maxFish;
    }

    private int dfs(int[][] grid, boolean[][] visited, int x, int y, int[] directions) {
        visited[x][y] = true;
        int fishCount = grid[x][y];

        for (int d = 0; d < 4; d++) {
            int nx = x + directions[d], ny = y + directions[d + 1];
            if (nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length && !visited[nx][ny] && grid[nx][ny] > 0) {
                fishCount += dfs(grid, visited, nx, ny, directions);
            }
        }
        return fishCount;
    }
}