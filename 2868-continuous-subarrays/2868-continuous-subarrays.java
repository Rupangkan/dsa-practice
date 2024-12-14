class Solution {
    public long continuousSubarrays(int[] nums) {
        int l = 0, r = 0, n = nums.length;
        long c = 0;

        PriorityQueue<Integer> pqMin = new PriorityQueue<>(
            (a, b) -> nums[a] - nums[b]
        );

        PriorityQueue<Integer> pqMax = new PriorityQueue<>(
            (a, b) -> nums[b] - nums[a]
        );

        while(r < n) {
            pqMin.add(r);
            pqMax.add(r);

            while(l < r && nums[pqMax.peek()] - nums[pqMin.peek()] > 2) {
                l++;
                while(!pqMax.isEmpty() && pqMax.peek() < l) pqMax.poll();
                while(!pqMin.isEmpty() && pqMin.peek() < l) pqMin.poll();
            }
            c += r - l + 1;
            r++;
        }

        return c;
    }
}