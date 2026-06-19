class Solution {
    public int largestAltitude(int[] gain) {
        int currA = 0;
        int h = currA;

        for(int alt: gain) {
            currA += alt;
            h = Math.max(h, currA);
        }

        return h;
    }
}