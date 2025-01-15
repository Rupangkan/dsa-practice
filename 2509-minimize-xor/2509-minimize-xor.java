class Solution {
    boolean isSet(int x, int bit) {
        return (x & (1 << bit)) != 0;
    }

    int setBit(int x, int bit) {
        return x | (1 << bit);
    }

    public int minimizeXor(int num1, int num2) {
        int res = 0, target = Integer.bitCount(num2), setBits = 0, currBit = 31;

        while(setBits < target) {
            if(isSet(num1, currBit) || (target - setBits > currBit)) {
                res = setBit(res, currBit);
                setBits++;
            }
            currBit--;
        }
        return res;
    }
}