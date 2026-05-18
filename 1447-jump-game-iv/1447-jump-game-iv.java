class Solution {

    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n <= 1) return 0;

        Map<Integer, List<Integer>> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            mp.computeIfAbsent(arr[i], z -> new ArrayList<>()).add(i);
        }

        List<Integer> q = new ArrayList<>();
        q.add(0);

        Set<Integer> vis = new HashSet<>();
        vis.add(0);

        int step = 0;

        while (!q.isEmpty()) {
            List<Integer> nq = new ArrayList<>();

            for (int x : q) {
                if (x == n - 1) return step;

                for (int y : mp.get(arr[x])) {
                    if (vis.add(y)) nq.add(y);
                }

                mp.get(arr[x]).clear();

                if (x + 1 < n && vis.add(x + 1)) {
                    nq.add(x + 1);
                }

                if (x - 1 >= 0 && vis.add(x - 1)) {
                    nq.add(x - 1);
                }
            }

            q = nq;
            step++;
        }

        return -1;
    }
}