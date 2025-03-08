class Solution {
    public int minimumRecolors(String blocks, int k) {
        int no = 0, nor = Integer.MAX_VALUE, l = 0, n = blocks.length();

        for(int i = 0; i<n; i++) {
            if(blocks.charAt(i) == 'W') {
                no++;
            }
            if(i-l+1 == k) {
                nor = Math.min(nor, no);

                if(blocks.charAt(l) == 'W') no--;
                l++;
            }
        }

        return nor;
    }
}