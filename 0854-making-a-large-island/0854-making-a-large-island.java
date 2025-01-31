class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int maxArea = 0;
        int index = 2;
        Map<Integer, Integer> areaMap = new HashMap<>();
        areaMap.put(0, 0);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j, index);
                    areaMap.put(index, area);
                    maxArea = Math.max(maxArea, area);
                    index++;
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> seen = new HashSet<>();
                    int newArea = 1;
                    for (int[] d : new int[][]{{0,1},{1,0},{0,-1},{-1,0}}) {
                        int x = i + d[0], y = j + d[1];
                        if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] > 1) {
                            seen.add(grid[x][y]);
                        }
                    }
                    for (int idx : seen) {
                        newArea += areaMap.get(idx);
                    }
                    maxArea = Math.max(maxArea, newArea);
                }
            }
        }
        
        return maxArea;
    }
     private int dfs(int[][] grid, int i, int j, int index) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = index;
        return 1 + dfs(grid, i + 1, j, index) + dfs(grid, i - 1, j, index) + dfs(grid, i, j + 1, index) + dfs(grid, i, j - 1, index);
    }
}