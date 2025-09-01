class Solution {

    private double gain(int p, int t) {
        return (double)(p + 1) / (t + 1) - (double)p / t;
    }
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        for (int[] c : classes) {
            pq.offer(new double[]{gain(c[0], c[1]), c[0], c[1]});
        }
        while (extraStudents-- > 0) {
            double[] cur = pq.poll();
            int p = (int) cur[1], t = (int) cur[2];
            p++; t++;
            pq.offer(new double[]{gain(p, t), p, t});
        }
        double ans = 0;
        while (!pq.isEmpty()) {
            double[] cur = pq.poll();
            ans += (double) cur[1] / cur[2];
        }
        return ans / classes.length;
    }
}
