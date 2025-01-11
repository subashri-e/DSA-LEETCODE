class Solution {
    public boolean canConstruct(String s, int k) {
        if (s.length() < k) {
            return false; 
        }
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        int oddCount = 0;
        for (int count : freq.values()) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }
        return oddCount <= k;
    }
}