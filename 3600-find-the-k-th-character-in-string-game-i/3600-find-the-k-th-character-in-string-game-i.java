class Solution {
    public char kthCharacter(int k) {
        int ans = 0, a;

        while(k != 1) {
            a = 31 - Integer.numberOfLeadingZeros(k);
            if((1 << a) == k) a--;
            k = k - (1 << a);
            ans++;
        }
        return (char) ('a' + ans);
    }
}