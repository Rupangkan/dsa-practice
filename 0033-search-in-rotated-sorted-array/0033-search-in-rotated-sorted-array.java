class Solution {
    public int search(int[] arr, int target) {
        // 8, 9, 10, 0, 1, 2, 3, 4, 5, 6, 7 --> 10
        int n = arr.length;
        int low = 0, high = n - 1;

        while(low <= high) {
            int mid = (low + high)/2;
            
            if(arr[mid] == target) return mid;
            if(arr[low] <= arr[mid]) {
                if(target >= arr[low] && target <= arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
                
            } else {
                if(target >= arr[mid] && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}