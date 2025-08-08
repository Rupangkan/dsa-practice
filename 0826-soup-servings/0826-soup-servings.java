class Solution {
    public double soupServings(int n) {
        int m = (n + 24) / 25;
        if (m >= 500) return 1.0;
        return solve(m, m, new HashMap<>());
    }

    private double solve(int a, int b, Map<Integer, Map<Integer, Double>> memo) {
        if (a <= 0 && b <= 0) return 0.5;
        if (a <= 0) return 1.0;
        if (b <= 0) return 0.0;
        if (memo.containsKey(a) && memo.get(a).containsKey(b)) return memo.get(a).get(b);
        double ans = (
            solve(a - 4, b, memo) +
            solve(a - 3, b - 1, memo) +
            solve(a - 2, b - 2, memo) +
            solve(a - 1, b - 3, memo)
        ) * 0.25;
        memo.computeIfAbsent(a, x -> new HashMap<>()).put(b, ans);
        return ans;
    }
}

