class Solution {
    static final int MOD = 1_000_000_007;

    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        Set<Integer> h = edges(hFences, m);
        Set<Integer> v = edges(vFences, n);

        long best = 0;
        for (int x : h) if (v.contains(x)) best = Math.max(best, x);

        return best == 0 ? -1 : (int) ((best * best) % MOD);
    }

    private Set<Integer> edges(int[] a, int lim) {
        List<Integer> l = new ArrayList<>();
        for (int x : a) l.add(x);
        l.add(1);
        l.add(lim);
        Collections.sort(l);

        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < l.size(); i++)
            for (int j = i + 1; j < l.size(); j++)
                s.add(l.get(j) - l.get(i));
        return s;
    }
}
