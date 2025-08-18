class Solution {

    private boolean solve(List<Double> v) {
        if (v.size() == 1) return Math.abs(v.get(0) - 24) < 1e-6;
        int n = v.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                List<Double> nxt = new ArrayList<>();
                for (int k = 0; k < n; k++) if (k != i && k != j) nxt.add(v.get(k));
                double a = v.get(i), b = v.get(j);
                double[] ops = {a+b, a-b, b-a, a*b};
                for (double x : ops) {
                    nxt.add(x);
                    if (solve(nxt)) return true;
                    nxt.remove(nxt.size()-1);
                }
                if (Math.abs(b) > 1e-6) {
                    nxt.add(a/b);
                    if (solve(nxt)) return true;
                    nxt.remove(nxt.size()-1);
                }
                if (Math.abs(a) > 1e-6) {
                    nxt.add(b/a);
                    if (solve(nxt)) return true;
                    nxt.remove(nxt.size()-1);
                }
            }
        }
        return false;
    }

    public boolean judgePoint24(int[] cards) {
        List<Double> vals = new ArrayList<>();
        for (int c : cards) vals.add((double)c);
        return solve(vals);
    }

}
