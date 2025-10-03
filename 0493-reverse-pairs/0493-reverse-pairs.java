class Solution {
    private int brute(int[] nums) {
        int n = nums.length;
        int count = 0;
        for(int i = 0; i<n; i++) {
            for(int j = i+1; j<n; j++) {
                if((long)nums[i] > (long)nums[j] * 2) count++;
            }
        }
        return count;
    }

    private void merge(int[] nums, int low, int high, int mid) {
        int left = low;
        int right = mid + 1;

        ArrayList<Integer> arr = new ArrayList<>();

        while(left <= mid && right <= high) {
            if(nums[left] > nums[right]) {
                arr.add(nums[right]);
                right++;
            } else {
                arr.add(nums[left]);
                left++;
            }
        }

        while(left <= mid) {
            arr.add(nums[left++]);
        }

        while(right <= high) {
            arr.add(nums[right++]);
        }

        for(int i = low; i<=high; i++) {
            nums[i] = arr.get(i-low);
        }
    }

    private int countPairs(int[] arr, int low, int high, int mid) {
        int count = 0;
        int right = mid + 1;
        for(int i = low; i<=mid; i++) {
            while(right <= high && (long)arr[i]>(long)2*arr[right]) right++;
            count = count + (right - (mid + 1));
        }
        return count;
    }

    private int optimal(int[] nums, int low, int high) {
        int count = 0;
        if(low >= high) return count;
        int mid = (high + low)/2;
        count += optimal(nums, low, mid);
        count += optimal(nums, mid + 1, high);
        count += countPairs(nums, low, high, mid);
        merge(nums, low, high, mid);
        return count;
    }

    public int reversePairs(int[] nums) {
        // return brute(nums);
        int n = nums.length;
        return optimal(nums, 0, n-1);
    }
}