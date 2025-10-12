class Solution {
    private List<Integer> generateRows(int idx, int n, List<List<Integer>> ans) {
        List<Integer> arr = new ArrayList<>();
        if(idx == 0) {
            arr.add(1);
            return arr;
        }

        for(int i = 0; i<=idx; i++) {
            if(i == 0 || i == idx) {
                arr.add(1);
            } else {
                int right = ans.get(idx - 1).get(i);
                int left = ans.get(idx - 1).get(i-1);
                int sum = right + left;
                arr.add(sum);
            }
        }
        return arr;
    }

    public List<List<Integer>> generate(int n) {
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i<n; i++) {
            List<Integer> temp = new ArrayList<>();
            temp = generateRows(i, n, ans);
            ans.add(temp);
        }

        return ans;
    }
}