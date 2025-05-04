class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] arr = new int[1000];
        int ct = 0;

        for(int[] d: dominoes) {
            int v = d[0] < d[1] ? d[0] * 10 + d[1] : d[1] * 10 + d[0];
            ct += arr[v];
            arr[v]++;
        }

        return ct;
    }
}