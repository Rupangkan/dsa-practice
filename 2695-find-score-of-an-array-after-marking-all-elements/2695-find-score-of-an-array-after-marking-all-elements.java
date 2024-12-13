class Solution {
    public long findScore(int[] nums) {
        long ans = 0;
        int n = nums.length;
        boolean[] vis = new boolean[n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        for(int i = 0; i<n; i++) {
            pq.add(new int[] {nums[i], i});
        }

        while(!pq.isEmpty()) {
            int[] curr = pq.remove();
            int num = curr[0], ind = curr[1];
            if(!vis[ind]) {
                ans += num;
                vis[ind] = true;
                if(ind - 1 >= 0) vis[ind - 1] = true;
                if(ind + 1 < n) vis[ind + 1] = true;
            }
        }

        return ans;
    }
}