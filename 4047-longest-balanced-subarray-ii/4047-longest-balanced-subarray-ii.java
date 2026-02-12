class LazyTag {
    int add;
    LazyTag() { }
    void merge(LazyTag o) { add += o.add; }
    boolean active() { return add != 0; }
    void reset() { add = 0; }
}

class Node {
    int mn, mx;
    LazyTag lz = new LazyTag();
}

class SegmentTree {
    int n;
    Node[] tr;

    SegmentTree(int[] a) {
        n = a.length;
        tr = new Node[n << 2];
        for (int i = 0; i < tr.length; i++) tr[i] = new Node();
        build(a, 1, n, 1);
    }

    void rangeAdd(int l, int r, int v) {
        LazyTag t = new LazyTag();
        t.add = v;
        update(l, r, t, 1, n, 1);
    }

    int lastPos(int l, int v) {
        if (l > n) return -1;
        return query(l, n, v, 1, n, 1);
    }

    void apply(int i, LazyTag t) {
        tr[i].mn += t.add;
        tr[i].mx += t.add;
        tr[i].lz.merge(t);
    }

    void push(int i) {
        if (tr[i].lz.active()) {
            LazyTag t = new LazyTag();
            t.add = tr[i].lz.add;
            apply(i << 1, t);
            apply(i << 1 | 1, t);
            tr[i].lz.reset();
        }
    }

    void pull(int i) {
        tr[i].mn = Math.min(tr[i << 1].mn, tr[i << 1 | 1].mn);
        tr[i].mx = Math.max(tr[i << 1].mx, tr[i << 1 | 1].mx);
    }

    void build(int[] a, int l, int r, int i) {
        if (l == r) {
            tr[i].mn = tr[i].mx = a[l - 1];
            return;
        }
        int m = (l + r) >> 1;
        build(a, l, m, i << 1);
        build(a, m + 1, r, i << 1 | 1);
        pull(i);
    }

    void update(int L, int R, LazyTag t, int l, int r, int i) {
        if (L <= l && r <= R) {
            apply(i, t);
            return;
        }
        push(i);
        int m = (l + r) >> 1;
        if (L <= m) update(L, R, t, l, m, i << 1);
        if (R > m) update(L, R, t, m + 1, r, i << 1 | 1);
        pull(i);
    }

    int query(int L, int R, int v, int l, int r, int i) {
        if (tr[i].mn > v || tr[i].mx < v) return -1;
        if (l == r) return l;
        push(i);
        int m = (l + r) >> 1;
        if (R > m) {
            int res = query(L, R, v, m + 1, r, i << 1 | 1);
            if (res != -1) return res;
        }
        if (L <= m) return query(L, R, v, l, m, i << 1);
        return -1;
    }
}

class Solution {

    public int longestBalanced(int[] nums) {
        int n = nums.length;
        Map<Integer, Deque<Integer>> pos = new HashMap<>();

        int[] pref = new int[n];
        pref[0] = sign(nums[0]);
        pos.computeIfAbsent(nums[0], k -> new ArrayDeque<>()).add(1);

        for (int i = 1; i < n; i++) {
            pref[i] = pref[i - 1];
            Deque<Integer> q = pos.computeIfAbsent(nums[i], k -> new ArrayDeque<>());
            if (q.isEmpty()) pref[i] += sign(nums[i]);
            q.add(i + 1);
        }

        SegmentTree st = new SegmentTree(pref);
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int idx = st.lastPos(i + ans, 0);
            if (idx != -1) ans = Math.max(ans, idx - i);

            Deque<Integer> q = pos.get(nums[i]);
            q.pollFirst();
            int nxt = q.isEmpty() ? n + 1 : q.peekFirst();
            st.rangeAdd(i + 1, nxt - 1, -sign(nums[i]));
        }
        return ans;
    }

    int sign(int x) {
        return (x & 1) == 0 ? 1 : -1;
    }
}
