class Solution {
    class Pair {
        long a;
        int b;
        Pair(long x, int y) {
            a = x;
            b = y;
        }
    }

    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length, l = 0, r = 0, ans = Integer.MAX_VALUE;
        long sum = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.a, b.a));
        for(int i = 0; i<n; i++) {
            sum += nums[i];

            if(sum >= k) {
                ans = (int) Math.min(ans, i+1);
            }

            while(!pq.isEmpty() && sum - pq.peek().a >= k) {
                ans = Math.min(ans, i - pq.poll().b);
            }

            pq.offer(new Pair(sum, i));

        }
        if(ans == Integer.MAX_VALUE) return -1; 
        return ans;
    }
}