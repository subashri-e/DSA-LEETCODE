class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] answer = new int[n];

        int operations = 0;
        int balls = 0; 
        for (int i = 0; i < n; i++) {
            answer[i] += operations;
            if (boxes.charAt(i) == '1') {
                balls++;
            }
            operations += balls; 
        }

        operations = 0;
        balls = 0;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] += operations;
            if (boxes.charAt(i) == '1') {
                balls++;
            }
            operations += balls; 
        }
        return answer;
    }
}