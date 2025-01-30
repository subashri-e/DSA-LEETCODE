import java.util.*;

class Solution {
    public int magnificentSets(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        int[] color = new int[n + 1];
        Arrays.fill(color, -1);
        int maxGroups = 0;
        for (int i = 1; i <= n; i++) {
            if (color[i] == -1) {
                List<Integer> component = new ArrayList<>();
                if (!bipartiteCheck(graph, i, color, component)) return -1;
                maxGroups += bfsMaxDepth(graph, component);
            }
        }
        return maxGroups;
    }
    
    private boolean bipartiteCheck(List<Integer>[] graph, int start, int[] color, List<Integer> component) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        color[start] = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            component.add(node);
            for (int neighbor : graph[node]) {
                if (color[neighbor] == -1) {
                    color[neighbor] = 1 - color[node];
                    queue.add(neighbor);
                } else if (color[neighbor] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private int bfsMaxDepth(List<Integer>[] graph, List<Integer> component) {
        int maxDepth = 0;
        for (int node : component) {
            maxDepth = Math.max(maxDepth, bfsDepth(graph, node));
        }
        return maxDepth;
    }
    
    private int bfsDepth(List<Integer>[] graph, int start) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                for (int neighbor : graph[node]) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }
        return depth;
    }
}
