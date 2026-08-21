class Solution {
    public long findKthSmallest(int[] coins, int k) {
        Arrays.sort(coins);

        List<Integer> list = new ArrayList<>();
        for (int x : coins) {
            boolean ok = true;
            for (int y : list) {
                if (x % y == 0) {
                    ok = false;
                    break;
                }
            }
            if (ok) list.add(x);
        }

        coins = list.stream().mapToInt(x -> x).toArray();
        int n = coins.length, size = 1 << n;
        int[] bits = new int[size];
        long[] lcm = new long[size];

        long lo = k, hi = (long) coins[0] * k + 1;

        for (int mask = 1; mask < size; mask++)
            bits[mask] = bits[mask >> 1] + (mask & 1);

        lcm[0] = 1;
        for (int mask = 1; mask < size; mask++) {
            int prev = mask & (mask - 1);
            int i = Integer.numberOfTrailingZeros(mask);

            long value = lcm[prev] / gcd(lcm[prev], coins[i]);
            lcm[mask] = value <= hi / coins[i]
                ? value * coins[i]
                : hi + 1;
        }

        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (count(mid, lcm, bits) >= k)
                hi = mid;
            else
                lo = mid + 1;
        }

        return lo;
    }

    private long count(long x, long[] lcm, int[] bits) {
        long res = 0;

        for (int mask = 1; mask < lcm.length; mask++) {
            if (lcm[mask] > x) continue;

            long cur = x / lcm[mask];
            res += (bits[mask] & 1) == 1 ? cur : -cur;
        }

        return res;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}