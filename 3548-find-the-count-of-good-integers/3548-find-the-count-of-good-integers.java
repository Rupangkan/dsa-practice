class Solution {
    public long countGoodIntegers(int n, int k) {
        Set<String> set = new HashSet<>();
        int start = (int) Math.pow(10, (n - 1) / 2);
        int odd = n & 1;

        for (int i = start; i < start * 10; i++) {
            String t = Integer.toString(i);
            t += new StringBuilder(t).reverse().substring(odd);
            long val = Long.parseLong(t);
            if (val % k == 0) {
                char[] ch = t.toCharArray();
                Arrays.sort(ch);
                set.add(new String(ch));
            }
        }

        long[] fact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) fact[i] = fact[i - 1] * i;

        long res = 0;
        for (String s : set) {
            int[] freq = new int[10];
            for (char c : s.toCharArray()) freq[c - '0']++;
            long total = (n - freq[0]) * fact[n - 1];
            for (int f : freq) total /= fact[f];
            res += total;
        }

        return res;
    }
}