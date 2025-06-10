class Solution {
    public int maxDifference(String s) {
        Map<Character, Integer> ch = new HashMap<>();
        int maxO = 1, minE = s.length();
        for(char c: s.toCharArray()) ch.put(c, ch.getOrDefault(c, 0) + 1);

        for(int v: ch.values()) {
            if(v % 2 == 1) {
                maxO = Math.max(maxO, v);
            } else {
                minE = Math.min(minE, v);
            }
        }
        return maxO - minE;
    }
}