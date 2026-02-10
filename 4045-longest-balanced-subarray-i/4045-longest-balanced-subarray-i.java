class Solution {

    public int longestBalanced(int[] nums) {
        int n = nums.length, ans = 0;

        for (int i = 0; i < n; i++) {
            HashMap<Integer, Integer> o = new HashMap<>();
            HashMap<Integer, Integer> e = new HashMap<>();

            for (int j = i; j < n; j++) {
                if ((nums[j] & 1) == 1)
                    o.put(nums[j], o.getOrDefault(nums[j], 0) + 1);
                else
                    e.put(nums[j], e.getOrDefault(nums[j], 0) + 1);

                if (o.size() == e.size())
                    ans = Math.max(ans, j - i + 1);
            }
        }
        return ans;
    }
}
