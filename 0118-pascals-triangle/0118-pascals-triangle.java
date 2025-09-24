class Solution {
    private List<Integer> generateRow(List<List<Integer>> ans, int n, int numRows) {
        List<Integer> arr = new ArrayList<>();
        if(n == 0) {
            arr.add(1);
            return arr;
        } 

        for(int i = 0; i<=n; i++) {
            if(i == 0 || i == n) {
                arr.add(1);
                continue;
            }
            int left = ans.get(n-1).get(i-1);
            int right = ans.get(n-1).get(i);
            arr.add(left + right);
        }
        return arr;
    }

    private List<List<Integer>> optimal(int num) {
        List<List<Integer>> arr = new ArrayList<>();
        for(int i = 0; i<num; i++) {
            List<Integer> row = new ArrayList<>();
            row = generateRow(arr, i, num);
            arr.add(row);
        }
        return arr;
    }

    public List<List<Integer>> generate(int numRows) {
        return optimal(numRows);
    }
}