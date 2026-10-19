class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int less = 0, equal = 0;

        for (int num : nums) {
            if (num < target) less++;
            else if (num == target) equal++;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = less; i < less + equal; i++)
            res.add(i);

        return res;
    }
}