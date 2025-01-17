class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        int original = 0;

        for (int i = 0; i < n; i++) {
            original ^= derived[i];
        }
        return original == 0;
    }
}