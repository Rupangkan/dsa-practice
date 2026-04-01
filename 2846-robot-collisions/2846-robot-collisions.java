class Solution {

    public List<Integer> survivedRobotsHealths(
        int[] positions,
        int[] healths,
        String directions
    ) {
        int n = positions.length;
        Integer[] ord = new Integer[n];
        for (int i = 0; i < n; i++) ord[i] = i;

        Arrays.sort(ord, (a, b) -> positions[a] - positions[b]);

        Deque<Integer> st = new ArrayDeque<>();

        for (int id : ord) {
            if (directions.charAt(id) == 'R') {
                st.push(id);
            } else {
                while (!st.isEmpty() && healths[id] > 0) {
                    int j = st.pop();
                    if (healths[j] > healths[id]) {
                        healths[j]--;
                        healths[id] = 0;
                        st.push(j);
                    } else if (healths[j] < healths[id]) {
                        healths[id]--;
                        healths[j] = 0;
                    } else {
                        healths[id] = 0;
                        healths[j] = 0;
                    }
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (healths[i] > 0) ans.add(healths[i]);
        }
        return ans;
    }
}