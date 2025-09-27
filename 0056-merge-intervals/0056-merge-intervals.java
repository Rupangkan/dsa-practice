class Solution {
    // O(nlogn) + O(2N)
    private int[][] better(int[][] arr) {
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        int n = arr.length;
        List<int[]> ans = new ArrayList<>();
        for(int i = 0; i<n; i++) {
            int start = arr[i][0];
            int end = arr[i][1];
            if(!ans.isEmpty() && end <= ans.get(ans.size()-1)[1]) continue;

            for(int j = i+1; j<n; j++) {
                if(arr[j][0] <= end) {
                    end = Math.max(end, arr[j][1]);
                } else break;
            }
            ans.add(new int[] {start, end});
        }
        return ans.toArray(new int[ans.size()][2]);
    }

    private int[][] optimal(int[][] arr) {
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        int n = arr.length;
        List<int[]> ans = new ArrayList<>();

        for(int i = 0; i<n; i++) {
            int start = arr[i][0];
            int end = arr[i][1];

            if(ans.isEmpty() || ans.get(ans.size() - 1)[1] < start) {
                ans.add(new int[] { start, end });
            } else {
                end = Math.max(end, ans.get(ans.size() - 1)[1]);
                ans.get(ans.size()-1)[1] = end;
            }
        }
        return ans.toArray(new int[ans.size()][2]);
    }

    public int[][] merge(int[][] arr) {
       return optimal(arr);
    }
}