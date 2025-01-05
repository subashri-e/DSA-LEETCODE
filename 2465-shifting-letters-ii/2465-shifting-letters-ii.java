class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diff = new int[n + 1];

        for (int[] shift : shifts) {
            int start = shift[0], end = shift[1], increment = (shift[2] == 1) ? 1 : -1;
            diff[start] += increment;
            diff[end + 1] -= increment;
        }

        int shiftValue = 0;
        char[] result = s.toCharArray();
        for (int i = 0; i < n; i++) {
            shiftValue += diff[i];
            int newChar = (result[i] - 'a' + shiftValue % 26 + 26) % 26;
            result[i] = (char) ('a' + newChar);
        }

        return new String(result);
    }
}