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

    //  O(N3*log(M)), where N = size of the array, M = no. of elements in the set.
    //  O(2 * no. of the quadruplets)+O(N)
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

    public List<List<Integer>> optimal(int[] nums, int t) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        // Set<List<Integer>> ans = new HashSet<>();
        for(int i = 0; i<n; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j<n; j++) {
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                int k = j+1;
                int l = n-1;

                while(k < l) {
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];
                    if(sum == t) {
                        ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[k], nums[j], nums[l])));
                        l--;
                        k++;
                        while(k<l && nums[k] == nums[k-1]) k++;
                        while(k<l && nums[l] == nums[l+1]) l--;
                    } else if(sum > t) {
                        l--;
                    } else {
                        k++;
                    }
                }
            }
        }
        return ans;
    }


    public List<List<Integer>> fourSum(int[] nums, int target) {
        // return brute(nums, target);
        // return better(nums, target);
        return optimal(nums, target);
    }
}