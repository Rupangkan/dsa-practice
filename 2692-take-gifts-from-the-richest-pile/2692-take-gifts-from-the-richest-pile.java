class Solution {
    public long pickGifts(int[] gifts, int k) {
        int n = gifts.length;
        int x = 0;
        Arrays.sort(gifts);

        while(x<k) {
            gifts[n-1] = (int) Math.floor(Math.sqrt(gifts[n-1]));
            Arrays.sort(gifts);
            x++;
        }

        long sum = 0;

        for(int i = 0; i<n; i++) {
            sum += gifts[i];
        }
        return sum;
    }
}