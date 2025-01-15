class Solution {
    public int minimizeXor(int num1, int num2) {
        int countSetBitsNum2 = Integer.bitCount(num2);
        int x = 0;
        int bitsToSet = countSetBitsNum2;
        
        for (int i = 31; i >= 0; i--) {
            if ((num1 & (1 << i)) != 0) {
                if (bitsToSet > 0) {
                    x |= (1 << i);
                    bitsToSet--;
                }
            }
        }

        for (int i = 0; i < 32 && bitsToSet > 0; i++) {
            if ((x & (1 << i)) == 0) {
                x |= (1 << i);
                bitsToSet--;
            }
        }
        return x;
    }
}