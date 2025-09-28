class Solution {
    private List<List<Integer>> optimal(int num) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        for(int i = 0; i<num; i++) {
            List<Integer> curr = new ArrayList<>();
            if(i == 0) curr.add(1);
            else {
                for(int j = 0; j<=i; j++) {
                    if(j == 0 || j == i) curr.add(1);
                    else {
                        int left = ans.get(i-1).get(j-1);
                        int right = ans.get(i-1).get(j);
                        curr.add(left + right);
                    }
                } 
            }
            ans.add(curr);
        }
        return ans;
    }

    public List<List<Integer>> generate(int numRows) {
        return optimal(numRows);
    }
}