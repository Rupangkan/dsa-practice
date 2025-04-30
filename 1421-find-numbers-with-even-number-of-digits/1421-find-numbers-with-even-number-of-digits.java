class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;

        for(int n: nums) {
            int dc = (int) Math.floor(Math.log10(n)) + 1;
            if(dc % 2 == 0) {
                count++;
            }
        }

        return count;
    }
}