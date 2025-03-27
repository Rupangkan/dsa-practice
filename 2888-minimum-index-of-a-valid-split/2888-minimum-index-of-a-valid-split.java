class Solution {
    public int minimumIndex(List<Integer> nums) {
        Map<Integer, Integer> fm = new HashMap<>();
        Map<Integer, Integer> sm = new HashMap<>();
        int n = nums.size();

        for(int i: nums) sm.put(i, sm.getOrDefault(i, 0) + 1);

        for(int i = 0; i<n; i++){
            int curr = nums.get(i);
            fm.put(curr, fm.getOrDefault(curr, 0) + 1);
            sm.put(curr, sm.get(curr) - 1);

            if(fm.get(curr) * 2 > i + 1 && sm.get(curr)* 2 > n - i - 1) return i;
        }

        return -1;
    }
}