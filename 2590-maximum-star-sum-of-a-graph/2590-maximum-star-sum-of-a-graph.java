class Solution {

    public boolean edgesGreaterEqualK(int i, int k, ArrayList<ArrayList<Integer>> edges) {
        if(edges.get(i).size() >= k) return true;
        return false;
    }

    public int maxSumOfEdges(int edge, ArrayList<ArrayList<Integer>> edges, int k, int[] vals) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i: edges.get(edge)) {
            pq.add(vals[i]);
        }
        int sum = vals[edge];
        for(int i = 0; i<k; i++) {
            if(pq.peek() == null || pq.peek() < 0) break;
            sum += pq.poll();
        }
        return sum;
    }

    public int maxStarSum(int[] vals, int[][] edges, int k) {
        int n = vals.length;
        ArrayList<Integer> edgesGEK = new ArrayList<>();

        ArrayList<ArrayList<Integer>> newEdges = new ArrayList<>();

        for(int i = 0; i<n; i++) {
            newEdges.add(new ArrayList<Integer>());
        }

        for(int[] arr: edges) {
            int x = arr[0];
            int y = arr[1];
            newEdges.get(x).add(y);
            newEdges.get(y).add(x);
        }

        System.out.println(newEdges.size());

        if(edges.length == 0) {
            int sum = Integer.MIN_VALUE;
            for(int val: vals) {
                sum = Math.max(val, sum);
            }
            return sum;
        }

        int ans = Integer.MIN_VALUE;

        for(int i = 0; i<n; i++) {
            int maxSum = maxSumOfEdges(i, newEdges, k, vals);
            ans = Math.max(ans, maxSum);
        }

        return ans;
    }
}