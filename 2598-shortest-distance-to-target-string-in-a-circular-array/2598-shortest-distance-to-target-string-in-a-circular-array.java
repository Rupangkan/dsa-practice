class Solution {

    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int res = n;

        for (int i = 0; i < n; i++) {
            if (!words[i].equals(target)) continue;

            int d = i - startIndex;
            if (d < 0) d = -d;
            res = Math.min(res, Math.min(d, n - d));
        }

        return res == n ? -1 : res;
    }
}