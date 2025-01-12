class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if (n % 2 != 0) return false; // Odd length strings can't be valid

        int open = 0, close = 0;

        // Left to Right Scan
        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '1') {
                if (s.charAt(i) == '(') open++;
                else close++;
            } else {
                open++; // Treat unlocked as '('
            }
            if (close > open) return false; // More closed brackets than possible open
        }

        open = close = 0;
        // Right to Left Scan
        for (int i = n - 1; i >= 0; i--) {
            if (locked.charAt(i) == '1') {
                if (s.charAt(i) == '(') open++;
                else close++;
            } else {
                close++; // Treat unlocked as ')'
            }
            if (open > close) return false; // More open brackets than possible close
        }

        return true;
    }
}