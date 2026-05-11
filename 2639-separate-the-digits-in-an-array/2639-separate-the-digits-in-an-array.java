class Solution {

    public int[] separateDigits(int[] nums) {
        List<Integer> a = new ArrayList<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            int x = nums[i];

            while (x > 0) {
                a.add(x % 10);
                x /= 10;
            }
        }

        Collections.reverse(a);

        int[] ans = new int[a.size()];
        for (int i = 0; i < a.size(); i++) {
            ans[i] = a.get(i);
        }

        return ans;
    }
}