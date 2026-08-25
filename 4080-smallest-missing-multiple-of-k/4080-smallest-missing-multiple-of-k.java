class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> seen = new HashSet<>();

        for (int x : nums)
            seen.add(x);

        for (int x = k; ; x += k)
            if (!seen.contains(x))
                return x;
    }
}