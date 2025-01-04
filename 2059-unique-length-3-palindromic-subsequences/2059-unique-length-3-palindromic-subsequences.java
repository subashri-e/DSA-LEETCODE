class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int result = 0;

        for (char ch = 'a'; ch <= 'z'; ch++) {
            int first = s.indexOf(ch);  
            int last = s.lastIndexOf(ch); 

            if (first != -1 && last != -1 && first < last) {
                Set<Character> uniqueChars = new HashSet<>();
                for (int i = first + 1; i < last; i++) {
                    uniqueChars.add(s.charAt(i));
                }
                result += uniqueChars.size();
            }
        }
        return result;
    }
}