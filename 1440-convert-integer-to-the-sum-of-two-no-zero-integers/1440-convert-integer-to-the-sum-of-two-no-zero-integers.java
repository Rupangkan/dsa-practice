class Solution {
    public int[] getNoZeroIntegers(int n) {
        for (int a = 1; a < n; a++) {
            int b = n - a;
            if (!(""+a).contains("0") && !(""+b).contains("0")) return new int[]{a,b};
        }
        return new int[0];
    }
}
