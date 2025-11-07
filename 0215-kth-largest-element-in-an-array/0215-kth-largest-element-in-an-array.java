class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        if(k > n) return -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i<n; i++) {
            pq.add(nums[i]);
        }

        for(int i = 0; i<k-1; i++) {
            pq.poll();
        }
        return pq.poll();
    }
}