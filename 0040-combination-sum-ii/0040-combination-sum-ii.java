class Solution {
    private void test(int[] can, int t, int idx, List<List<Integer>> ans, List<Integer> temp) {
        // if(idx == can.length) return;
        if(t == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
  
        for(int i = idx; i<can.length; i++) {
            if(i > idx && can[i] == can[i-1]) continue;
            // if(can[i] > t) break; 
            if(t - can[i] >= 0) {
                temp.add(can[i]);
                test(can, t - can[i], i + 1, ans, temp);
                temp.remove(temp.size()-1);
            } else {
                break;
            }
    
        }
    }

    public List<List<Integer>> combinationSum2(int[] can, int t) {
        Arrays.sort(can);
        List<List<Integer>> ans = new ArrayList<>();
        test(can, t, 0, ans, new ArrayList<>());
        return ans;
    }
}