class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> hm = new HashMap<>();
        int ans = 0;

        for(int i: answers) hm.put(i, hm.getOrDefault(i, 0) + 1);
        
        for(Map.Entry<Integer, Integer> e: hm.entrySet()) {
            ans += Math.ceil((double) e.getValue() / (e.getKey() + 1)) * (e.getKey() + 1);
        }
        return ans;
    }
}