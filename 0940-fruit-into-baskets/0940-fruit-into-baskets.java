class Solution {
    public int totalFruit(int[] a) {
        int l = 0, r = 0, n = a.length, ans = 0;
        Map<Integer, Integer> f = new HashMap<>();
        while (r < n) {
            f.put(a[r], f.getOrDefault(a[r], 0) + 1);
            while (f.size() > 2) {
                f.put(a[l], f.get(a[l]) - 1);
                if (f.get(a[l]) == 0) f.remove(a[l]);
                l++;
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
}
