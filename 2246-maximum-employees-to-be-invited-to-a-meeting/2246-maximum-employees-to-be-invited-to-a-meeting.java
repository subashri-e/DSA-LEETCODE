class Solution {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int[] indegree = new int[n];
        for (int fav : favorite) {
            indegree[fav]++;
        }
        boolean[] visited = new boolean[n];
        int[] dp = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            visited[curr] = true;
            int fav = favorite[curr];
            dp[fav] = Math.max(dp[fav], dp[curr] + 1);
            indegree[fav]--;
            if (indegree[fav] == 0) {
                queue.offer(fav);
            }
        }
        
        int result = 0, twoCycleLength = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int length = 0;
                int curr = i;
                while (!visited[curr]) {
                    visited[curr] = true;
                    curr = favorite[curr];
                    length++;
                }
                if (length == 2) {
                    twoCycleLength += 2 + dp[i] + dp[favorite[i]];
                } else {
                    result = Math.max(result, length);
                }
            }
        }
        
        return Math.max(result, twoCycleLength);
    }
}
