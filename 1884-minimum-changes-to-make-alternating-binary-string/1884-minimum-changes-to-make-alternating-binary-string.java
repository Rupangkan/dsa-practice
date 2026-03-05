class Solution {
    public int minOperations(String s) {
        int a = 0, n = s.length();
        for (int i = 0; i < n; i++)
            if (s.charAt(i) - '0' != (i & 1)) a++;
        return Math.min(a, n - a);
    }
}
