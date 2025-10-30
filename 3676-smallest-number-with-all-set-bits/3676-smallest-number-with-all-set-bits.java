class Solution {
    public int smallestNumber(int n) {
        String ans = "";
        while (n != 0) {
            ans += "1";
            n = n >> 1;
        }
        return Integer.parseInt(ans, 2);
    }
}
