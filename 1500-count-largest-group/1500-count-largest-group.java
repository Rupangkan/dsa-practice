class Solution {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0, c = 0;

        for(int i = 1; i<=n; i++) {
            int k = 0, m = i;
            while(m != 0) {
                k += m % 10;
                m /= 10;
            }
            map.put(k, map.getOrDefault(k, 0) + 1);
            max = Math.max(max, map.get(k));
        }
        for (Map.Entry<Integer, Integer> p : map.entrySet()) {
            if (p.getValue() == max) {
                ++c;
            }
        }
        return c;
    }
}