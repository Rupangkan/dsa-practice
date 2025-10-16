class Solution {
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

        for(int i = 0; i<n; i++) {
            System.out.print(back[i]);
        }

        System.out.println();
        for(int i = 0; i<n; i++) {
            System.out.print(front[i]);
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

    public int trap(int[] height) {
        return better(height);
    }
}