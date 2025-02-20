class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Set<Integer> st = new HashSet<>();
        int n = nums.length;

        for(String num: nums) {
            st.add(Integer.parseInt(num, 2));
        }

        for(int i = 0; i<=n; i++) {
            if(!st.contains(i)) {
                String ans = Integer.toBinaryString(i);
                while(ans.length() < n) ans = "0" + ans;
                return ans;
            }
        }
        
        return "";
    }
}