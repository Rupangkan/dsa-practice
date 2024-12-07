class Solution {
    boolean binarySearch(int[] banned, int x) {
        int l = 0, r = banned.length - 1;

        while(l<=r) {
            int mid = (r+l)/2;
            if(banned[mid] == x) return true;
            if(banned[mid] > x) r = mid - 1;
            else l = mid + 1;
        }
        return false;
    }

    public int maxCount(int[] banned, int n, int maxSum) {
        Arrays.sort(banned);

        int count = 0;

        for(int i = 1; i<=n; i++) {
            if(binarySearch(banned, i)) continue;
            maxSum -= i;
            if(maxSum < 0) break;
            count++;
        }
        return count;
    }
}