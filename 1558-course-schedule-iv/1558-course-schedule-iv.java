class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] reach = new boolean[numCourses][numCourses];
        
        for (int[] prerequisite : prerequisites) {
            reach[prerequisite[0]][prerequisite[1]] = true;
        }
        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    if (reach[i][k] && reach[k][j]) {
                        reach[i][j] = true;
                    }
                }
            }
        }
        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(reach[query[0]][query[1]]);
        }
        return result;
    }
}