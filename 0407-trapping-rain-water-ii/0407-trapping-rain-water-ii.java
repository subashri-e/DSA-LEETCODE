class Solution {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }

        int m = heightMap.length, n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> a.height - b.height);

        for (int i = 0; i < m; i++) {
            pq.offer(new Cell(i, 0, heightMap[i][0]));
            pq.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }
        for (int j = 0; j < n; j++) {
            pq.offer(new Cell(0, j, heightMap[0][j]));
            pq.offer(new Cell(m - 1, j, heightMap[m - 1][j]));
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }

        int[] directions = {-1, 0, 1, 0, -1}; 
        int waterTrapped = 0;
        int maxHeight = 0;

        while (!pq.isEmpty()) {
            Cell cell = pq.poll();
            maxHeight = Math.max(maxHeight, cell.height);

            for (int k = 0; k < 4; k++) {
                int ni = cell.row + directions[k];
                int nj = cell.col + directions[k + 1];

                if (ni >= 0 && ni < m && nj >= 0 && nj < n && !visited[ni][nj]) {
                    visited[ni][nj] = true;
                    waterTrapped += Math.max(0, maxHeight - heightMap[ni][nj]);
                    pq.offer(new Cell(ni, nj, Math.max(heightMap[ni][nj], maxHeight)));
                }
            }
        }

        return waterTrapped;
    }
    static class Cell {
        int row, col, height;

        public Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }
}