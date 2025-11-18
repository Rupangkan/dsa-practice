class Solution {
    public boolean isOneBitCharacter(int[] b) {
        int n = b.length - 2;

        while(n >= 0 && b[n] > 0) n--;
        return (b.length - n) % 2 == 0;
    }
}