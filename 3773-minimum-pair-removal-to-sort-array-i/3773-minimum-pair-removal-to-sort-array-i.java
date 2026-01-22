class Solution {
    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        int[] next = new int[n];
        for (int i = 0; i < n - 1; i++) next[i] = i + 1;
        next[n - 1] = -1;

        int removed = 0;

        while (n - removed > 1) {
            int cur = 0, best = 0;
            int bestSum = nums[0] + nums[next[0]];
            boolean sorted = true;

            while (cur != -1 && next[cur] != -1) {
                if (nums[cur] > nums[next[cur]]) sorted = false;
                int s = nums[cur] + nums[next[cur]];
                if (s < bestSum) {
                    bestSum = s;
                    best = cur;
                }
                cur = next[cur];
            }

            if (sorted) break;

            removed++;
            nums[best] = bestSum;
            next[best] = next[next[best]];
        }
        return removed;
    }
}
