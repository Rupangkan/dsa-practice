class Solution {
    private int countReverse(int low, int mid, int high, int[] arr) {
        int count = 0;
        int right = mid + 1;
        for(int i = low; i<=mid; i++) {
            while(right <= high && (long)arr[i]>(long)2*arr[right]) right++;
            count = count + (right - (mid + 1));
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

    private int optimal(int low, int high, int[] nums) {
        int count = 0;
        if(low >= high) return count;
        int mid = (high + low)/2;
        count += optimal(low, mid, nums);
        count += optimal(mid + 1, high, nums);
        count += countReverse(low, mid, high, nums);
        merge(nums, low, high, mid);
        return count;
    }

    public int reversePairs(int[] nums) {
        int n = nums.length;
        return optimal(0, n-1, nums);
    }
}