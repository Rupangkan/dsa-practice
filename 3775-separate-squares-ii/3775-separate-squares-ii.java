class SegmentTree {
    int[] cnt, cover, xs;
    int n;

    SegmentTree(int[] xs) {
        this.xs = xs;
        n = xs.length - 1;
        cnt = new int[4 * n];
        cover = new int[4 * n];
    }

    void update(int l, int r, int v) {
        update(l, r, v, 0, n - 1, 0);
    }

    void update(int ql, int qr, int v, int l, int r, int idx) {
        if (xs[r + 1] <= ql || xs[l] >= qr) return;

        if (ql <= xs[l] && xs[r + 1] <= qr) {
            cnt[idx] += v;
        } else {
            int m = (l + r) >> 1;
            update(ql, qr, v, l, m, idx * 2 + 1);
            update(ql, qr, v, m + 1, r, idx * 2 + 2);
        }

        if (cnt[idx] > 0) {
            cover[idx] = xs[r + 1] - xs[l];
        } else if (l == r) {
            cover[idx] = 0;
        } else {
            cover[idx] = cover[idx * 2 + 1] + cover[idx * 2 + 2];
        }
    }

    int query() {
        return cover[0];
    }
}

class Solution {
    public double separateSquares(int[][] squares) {
        List<int[]> events = new ArrayList<>();
        TreeSet<Integer> set = new TreeSet<>();

        for (int[] s : squares) {
            int x = s[0], y = s[1], l = s[2];
            events.add(new int[]{y, 1, x, x + l});
            events.add(new int[]{y + l, -1, x, x + l});
            set.add(x);
            set.add(x + l);
        }

        events.sort(Comparator.comparingInt(a -> a[0]));
        int[] xs = set.stream().mapToInt(i -> i).toArray();
        SegmentTree st = new SegmentTree(xs);

        List<Long> pref = new ArrayList<>();
        List<Integer> widths = new ArrayList<>();

        long area = 0;
        int prevY = events.get(0)[0];

        for (int[] e : events) {
            int y = e[0];
            area += (long) st.query() * (y - prevY);
            st.update(e[2], e[3], e[1]);
            pref.add(area);
            widths.add(st.query());
            prevY = y;
        }

        long half = (area + 1) / 2;
        int i = lowerBound(pref, half);

        long before = pref.get(i);
        int w = widths.get(i);
        int y = events.get(i)[0];

        return y + (area - before * 2) / (2.0 * w);
    }

    private int lowerBound(List<Long> a, long t) {
        int l = 0, r = a.size() - 1, ans = 0;
        while (l <= r) {
            int m = (l + r) >>> 1;
            if (a.get(m) < t) {
                ans = m;
                l = m + 1;
            } else r = m - 1;
        }
        return ans;
    }
}
