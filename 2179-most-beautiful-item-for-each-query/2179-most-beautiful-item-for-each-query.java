class Solution {
    int binarySearch(int[][] items, int max) {
        int l = 0, h = items.length-1, maxBeauty = 0;

        while(l<=h) {
            int mid = l + (h - l)/2;
            if(items[mid][0] > max) {
                h = mid - 1;
            } else {
                maxBeauty = Math.max(maxBeauty, items[mid][1]);
                l = mid + 1;
            }
        }
        return maxBeauty;

    }
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int n = items.length, m = queries.length, max = 0;
        int[] ans = new int[m];
        Arrays.sort(items, (a, b) -> a[0] - b[0]);

        for(int i = 0; i<n; i++) {
            max = Math.max(max, items[i][1]);
            items[i][1] = max;
        }

        for(int i = 0; i<m; i++) {
            ans[i] = binarySearch(items, queries[i]);
        }
        return ans;
    }
}