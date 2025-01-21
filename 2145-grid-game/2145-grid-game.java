class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        
        long[] prefixTop = new long[n + 1];
        long[] prefixBottom = new long[n + 1];
        
        for (int i = 0; i < n; i++) {
            prefixTop[i + 1] = prefixTop[i] + grid[0][i];
            prefixBottom[i + 1] = prefixBottom[i] + grid[1][i];
        }
        
        long minPointsForSecondRobot = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            long pointsTop = prefixTop[n] - prefixTop[i + 1]; 
            long pointsBottom = prefixBottom[i];  
            long maxPointsSecondRobot = Math.max(pointsTop, pointsBottom);
            
            minPointsForSecondRobot = Math.min(minPointsForSecondRobot, maxPointsSecondRobot);
        }
        
        return minPointsForSecondRobot;
    }
}