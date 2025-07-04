class Solution {
    public char kthCharacter(long k, int[] operations) {
        int ans = 0, a;

        while(k != 1) {
            a = 63 - Long.numberOfLeadingZeros(k);
            if((1L << a) == k) a--;
            k = k - (1L << a);
            if(operations[a] != 0) ans++;
        }
        return (char) ('a' + (ans % 26));
    }
}