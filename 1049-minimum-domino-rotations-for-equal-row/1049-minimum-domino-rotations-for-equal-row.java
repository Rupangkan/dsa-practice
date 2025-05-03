class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length, ans = Integer.MAX_VALUE;
        int[] arr = new int[7];
        for(int i=0;i<n;i++) {
            arr[tops[i]]++;
            if(bottoms[i] != tops[i]) arr[bottoms[i]]++;
        }
        for(int i=1;i<=6;i++) {
            if(arr[i]<n) continue;
            int mt = 0, mb = 0;
            boolean valid = true;
            for(int j=0;j<n;j++) {
                if(tops[j] != i && bottoms[j] != i) {
                    valid = false;
                    break;
                }
                if(tops[j] != i) mt++;
                if(bottoms[j] != i) mb++;
            }
            if(valid) ans = Math.min(ans, Math.min(mb, mt));
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}