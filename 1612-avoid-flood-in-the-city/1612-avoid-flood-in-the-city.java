class Solution {
    public int[] avoidFlood(int[] r) {
        int n = r.length;
        int[] res = new int[n];
        Arrays.fill(res, 1);
        TreeSet<Integer> dry = new TreeSet<>();
        Map<Integer, Integer> last = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (r[i] == 0) dry.add(i);
            else {
                res[i] = -1;
                if (last.containsKey(r[i])) {
                    Integer d = dry.ceiling(last.get(r[i]));
                    if (d == null) return new int[0];
                    res[d] = r[i];
                    dry.remove(d);
                }
                last.put(r[i], i);
            }
        }
        return res;
    }
}
