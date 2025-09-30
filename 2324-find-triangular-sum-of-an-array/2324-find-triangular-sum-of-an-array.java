class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        int[] arr = nums.clone();
        for (int len = n; len > 1; len--) {
            for (int i = 0; i < len - 1; i++) {
                arr[i] = (arr[i] + arr[i + 1]) % 10;
            }
        }
        return arr[0];
    }
}
