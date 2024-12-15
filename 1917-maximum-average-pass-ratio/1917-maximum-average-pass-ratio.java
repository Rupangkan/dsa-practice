class Solution {
    double getProfit(int p, int t) {
        return ((double) (p + 1)/(t + 1) - (double) p / t);
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        int n = classes.length;

        for(int[] curr: classes) {
            int p = curr[0];
            int t = curr[1];
            double pro = getProfit(p, t);
            pq.offer(new double[] { pro, p, t });
        }

        while(extraStudents > 0) {
            double[] curr = pq.poll();
            double currP = curr[0];
            int p = (int) curr[1];
            int t = (int) curr[2];

            pq.offer(
                new double[] {
                    getProfit(p + 1, t + 1),
                    p + 1, t + 1
                }
            );

            extraStudents--;
        }

        double ans = 0;
        while(!pq.isEmpty()) {
            double[] curr = pq.poll();
            int p = (int) curr[1];
            int t = (int) curr[2];
            ans += (double) p / t;
        }

        return ans/n;
    }
}