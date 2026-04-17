class Solution {

    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length, res = n + 1;
        Map<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int v = nums[i];
            if (mp.containsKey(v)) {
                res = Math.min(res, i - mp.get(v));
            }
            mp.put(rev(v), i);
        }

        return res == n + 1 ? -1 : res;
    }

    private int rev(int x) {
        int y = 0;
        while (x > 0) {
            y = y * 10 + x % 10;
            x /= 10;
        }
        return y;
    }
}