class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length, ans = 0;
        List<Integer> factors = new ArrayList<>();

        for (int d = 1; d * d <= n; d++) {
            if (n % d == 0) {
                factors.add(d);
                if (d != n / d) factors.add(n / d);
            }
        }

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        for (int d : factors) {
            boolean valid = true;

            for (int l = 0; l < n; l += d) {
                int[] a = Arrays.copyOfRange(nums, l, l + d);
                int[] b = Arrays.copyOfRange(sorted, l, l + d);

                if (!check(a, b)) {
                    valid = false;
                    break;
                }
            }

            if (valid) ans += d;
        }

        return ans;
    }

    private boolean check(int[] nums, int[] target) {
        int n = nums.length;
        int[] doubled = new int[2 * n];

        System.arraycopy(nums, 0, doubled, 0, n);
        System.arraycopy(nums, 0, doubled, n, n);

        return kmp(doubled, target);
    }

    private boolean kmp(int[] text, int[] pattern) {
        int n = text.length, m = pattern.length;
        int[] pi = new int[m];

        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && pattern[i] != pattern[j])
                j = pi[j - 1];

            if (pattern[i] == pattern[j]) j++;
            pi[i] = j;
        }

        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && text[i] != pattern[j])
                j = pi[j - 1];

            if (text[i] == pattern[j]) j++;
            if (j == m) return true;
        }

        return false;
    }
}