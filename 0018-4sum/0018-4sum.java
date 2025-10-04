class Solution {
    public List<List<Integer>> brute(int[] nums, int t) {
        int n = nums.length;
        Set<List<Integer>> ans = new HashSet<>();
        for(int i = 0; i<n; i++) {
            for(int j = i+1; j<n; j++) {
                for(int k = j+1; k<n; k++) {
                    for(int l = k+1; l<n; l++) {
                        long sum = (long)(nums[i] + nums[j]) + (long)(nums[k] + nums[l]);
                        if((int)sum == t) {
                            ArrayList<Integer> temp = new ArrayList<>();
                            temp.add(nums[i]);
                            temp.add(nums[j]);
                            temp.add(nums[k]);
                            temp.add(nums[l]);
                            Collections.sort(temp);
                            ans.add(temp);
                        }
                    }
                }
            }
        }
        return ans.stream().toList();
    }

    public List<List<Integer>> better(int[] nums, int t) {
        int n = nums.length;
        Set<List<Integer>> ans = new HashSet<>();
        for(int i = 0; i<n; i++) {
            for(int j = i+1; j<n; j++) {
                Set<Long> st = new HashSet<>();
                for(int k = j+1; k<n; k++) {
                    long sum = nums[i] + nums[j];
                    sum += nums[k];
                    long fourth = t - sum;

                    if(st.contains(fourth)) {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add((int)fourth);
                        Collections.sort(temp);
                        ans.add(temp);
                    }
                    st.add((long)nums[k]);
                }
            }
        }
        return ans.stream().toList();
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        // return brute(nums, target);
        return better(nums, target);
    }
}