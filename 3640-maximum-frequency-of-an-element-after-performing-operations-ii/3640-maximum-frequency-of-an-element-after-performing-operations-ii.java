public class Solution {

    public int maxFrequency(int[] nums, int k, int numOps) {
        Arrays.sort(nums);
        int best = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        TreeSet<Integer> modes = new TreeSet<>();

        for (int i = 0, j; i < nums.length; i = j) {
            for (j = i; j < nums.length && nums[j] == nums[i]; j++);
            freq.put(nums[i], j - i);
            best = Math.max(best, j - i);
            modes.add(nums[i]);
            if (nums[i] - k >= nums[0]) modes.add(nums[i] - k);
            if (nums[i] + k <= nums[nums.length - 1]) modes.add(nums[i] + k);
        }

        for (int mode : modes) {
            int l = lower(nums, mode - k);
            int r = upper(nums, mode + k);
            int count = r - l + 1;
            int have = freq.getOrDefault(mode, 0);
            best = Math.max(best, Math.min(count, have + numOps));
        }

        return best;
    }

    private int lower(int[] a, int x) {
        int lo = 0, hi = a.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (a[mid] < x) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    private int upper(int[] a, int x) {
        int lo = 0, hi = a.length - 1;
        while (lo < hi) {
            int mid = (lo + hi + 1) >>> 1;
            if (a[mid] > x) hi = mid - 1;
            else lo = mid;
        }
        return lo;
    }
}