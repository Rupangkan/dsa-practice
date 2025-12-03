class Solution {
    public int countTrapezoids(int[][] pts) {
        final double INF = 1e9 + 7;
        int n = pts.length;

        Map<Double, List<Double>> slopeMap = new HashMap<>();
        Map<Integer, List<Double>> midMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int x1 = pts[i][0], y1 = pts[i][1];
            for (int j = i + 1; j < n; j++) {
                int x2 = pts[j][0], y2 = pts[j][1];

                double k, b;
                if (x1 == x2) {
                    k = INF;
                    b = x1;
                } else {
                    k = (double)(y2 - y1) / (x2 - x1);
                    b = (double)(y1 * (x1 - x2) - x1 * (y1 - y2)) / (x1 - x2);
                }

                if (k == -0.0) k = 0.0;
                if (b == -0.0) b = 0.0;

                int mid = (x1 + x2) * 10000 + (y1 + y2);
                slopeMap.computeIfAbsent(k, z -> new ArrayList<>()).add(b);
                midMap.computeIfAbsent(mid, z -> new ArrayList<>()).add(k);
            }
        }

        int res = 0;

        for (List<Double> list : slopeMap.values()) {
            if (list.size() < 2) continue;
            Map<Double, Integer> freq = new TreeMap<>();
            for (double b : list) freq.put(b, freq.getOrDefault(b, 0) + 1);

            int pref = 0;
            for (int c : freq.values()) {
                res += pref * c;
                pref += c;
            }
        }

        for (List<Double> list : midMap.values()) {
            if (list.size() < 2) continue;
            Map<Double, Integer> freq = new TreeMap<>();
            for (double k : list) freq.put(k, freq.getOrDefault(k, 0) + 1);

            int pref = 0;
            for (int c : freq.values()) {
                res -= pref * c;
                pref += c;
            }
        }

        return res;
    }
}
