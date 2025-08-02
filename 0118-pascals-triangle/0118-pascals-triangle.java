class Solution {
    private List<List<Integer>> solve(int n) {
        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < n; r++) {
            List<Integer> layer = new ArrayList<>();
            for (int i = 0; i <= r; i++) {
                if (i == 0 || i == r) layer.add(1);
                else {
                    int x = res.get(r - 1).get(i - 1);
                    int y = res.get(r - 1).get(i);
                    layer.add(x + y);
                }
            }
            res.add(layer);
        }
        return res;
    }

    public List<List<Integer>> generate(int numRows) {
        return solve(numRows);
    }
}