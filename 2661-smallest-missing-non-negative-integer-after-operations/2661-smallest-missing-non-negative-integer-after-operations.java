class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] freq = new int[value];
        for (int a : nums) {
            freq[(a % value + value) % value]++;
        }
        int res = 0;
        while (freq[res % value]-- > 0) res++;
        return res;
    }
}
