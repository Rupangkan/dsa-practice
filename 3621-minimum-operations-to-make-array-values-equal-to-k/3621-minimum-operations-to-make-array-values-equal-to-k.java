class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int x: nums) {
            if(x < k) {
                return -1;
            } 
            map.put(x, 1);
        }
        return map.containsKey(k) ?  map.size()-1: map.size();
    }
}