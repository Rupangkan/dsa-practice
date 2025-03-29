class Solution {
    final int MOD = 1_000_000_007;

    private long modPow(long base, long exp) {
        long res = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return res;
    }

    private int countPrimeFactors(int num) {
        int count = 0;
        for (int factor = 2; factor * factor <= num; factor++) {
            if (num % factor == 0) {
                count++;
                while (num % factor == 0) num /= factor;
            }
        }
        if (num > 1) count++;
        return count;
    }
    

    public int maximumScore(List<Integer> nums, int k) {
        int n = nums.size();
        int[] primeScores = new int[n];
        
        for (int i = 0; i < n; i++) {
            int num = nums.get(i);
            primeScores[i] = countPrimeFactors(num);
        }
        
        int[] next = new int[n], prev = new int[n];
        Arrays.fill(next, n);
        Arrays.fill(prev, -1);
        
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && primeScores[stack.peek()] < primeScores[i]) {
                next[stack.pop()] = i;
            }
            if (!stack.isEmpty()) prev[i] = stack.peek();
            stack.push(i);
        }
        
        long[] subarrayCount = new long[n];
        for (int i = 0; i < n; i++) {
            subarrayCount[i] = (long) (next[i] - i) * (i - prev[i]);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] == a[0] ? Integer.compare(a[1], b[1]) : Integer.compare(b[0], a[0]));
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{nums.get(i), i});
        }
        
        long score = 1;
        while (k > 0 && !pq.isEmpty()) {
            int[] top = pq.poll();
            int num = top[0], idx = top[1];
            long ops = Math.min(k, subarrayCount[idx]);
            
            score = (score * modPow(num, ops)) % MOD;
            k -= ops;
        }
        
        return (int) score;
    }
}