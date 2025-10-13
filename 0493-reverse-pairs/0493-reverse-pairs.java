class Solution {
    private int countReverse(int[] nums, int low, int mid, int high) {
        int count = 0;
        int right = mid + 1;

        for(int i = low; i<=mid; i++) {
            while(right <= high && (long)nums[i] > (long)2*nums[right]) right++;
            count += (right - (mid + 1));
        }
        return count;
    }

    private void merge(int[] nums, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        while(left <= mid && right <= high) {
            if(nums[left] > nums[right]) {
                temp.add(nums[right++]);
            } else {
                temp.add(nums[left++]);
            }
        }

        while(left <= mid) {
            temp.add(nums[left++]);
        }

        while(right <= high) {
            temp.add(nums[right++]);
        }

        for(int i = low; i<=high; i++) {
            nums[i] = temp.get(i-low);
        }
    }

    private int sol(int[] nums, int low, int high) {
        int count = 0;
        if(low >= high) return (int)count;
        int mid = (high + low)/2;
        count += sol(nums, low, mid);
        count += sol(nums, mid + 1, high);
        count += countReverse(nums, low, mid, high);
        merge(nums, low, mid, high);
        return (int)count;
    }

    public int reversePairs(int[] nums) {
        int n = nums.length;
        int low = 0, high = n-1;
        return sol(nums, low, high);
    }
}