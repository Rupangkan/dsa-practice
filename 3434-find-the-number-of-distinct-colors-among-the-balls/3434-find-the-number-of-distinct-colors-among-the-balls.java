class Solution {
    public int[] queryResults(int limit, int[][] q) {
        int n = q.length;
        int[] ans = new int[n];
        HashMap<Integer, Integer> color = new HashMap<>();
        HashMap<Integer, Integer> ball = new HashMap<>();

        for(int i = 0; i<n; i++) {
            int b = q[i][0];
            int c = q[i][1];

            if(ball.containsKey(b)) {
                int prev = ball.get(b);
                color.put(prev, color.get(prev) - 1);

                if(color.get(prev) == 0) color.remove(prev);
            }
            ball.put(b, c);
            color.put(c, color.getOrDefault(c, 0) + 1);

            ans[i] = color.size();
        }

        return ans;
    }
}