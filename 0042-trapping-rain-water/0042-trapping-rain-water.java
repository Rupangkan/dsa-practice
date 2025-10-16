class Solution {
    // O3N
    // O2N or use ON just take the back and for front just keep a max value while iterating
    private int better(int[] h) {
        int n = h.length;
        int[] back = new int[n];
        int[] front = new int[n];

        front[0] = h[0];
        back[n-1] = h[n-1];

        for(int i = 1; i<n; i++) {
            front[i] = Math.max(h[i], front[i-1]);
        }

        for(int i = n-2; i>=0; i--) {
            back[i] = Math.max(h[i], back[i+1]);
        }
        
        int count = 0;
        for(int i = 0; i<n; i++) {
            if(h[i] < back[i] && h[i] < front[i]) {
                int min = Math.min(back[i], front[i]);
                count += min - h[i];
            }
        }

        return count;
    }

    private int optimal(int[] h) {
        int n = h.length;
        int low = 0, high = n-1, leftMax = 0, rightMax = 0;
        int count = 0;

        while(low < high) {
            if(h[low] <= h[high]) {
                if(leftMax > h[low]) {
                    count += leftMax - h[low]; 
                } else {
                    leftMax = h[low];
                }
                low++;
            } else {
                if(rightMax > h[high]) {
                    count += rightMax - h[high];
                } else {
                    rightMax = h[high];
                }
                high--;
            }
        }
        return count;
    }

    public int trap(int[] height) {
        // return better(height);
        return optimal(height);
    }
}