class Solution {
    public int distinctPrimeFactors(int[] nums) {
        long prod = 1, n = nums.length;
        Set<Integer> hs = new HashSet<>();

        for(int num: nums) {
            int i = 2;
            while(num > 1) {
                if(num % i == 0) {
                    hs.add(i);
                    num /= i;
                }
                else i++;
            }
        }

        return hs.size();
    }
}