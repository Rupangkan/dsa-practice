class Solution {
    public long repairCars(int[] ranks, int cars) {
        long l = 1, h = 1L * ranks[0] * cars * cars;

        while(l < h) {
            long mid = (l + h)/2, cr = 0;
            for(int r: ranks) cr += (long) (Math.sqrt((1.0 * mid)/r));
            if(cr < cars) l = mid + 1;
            else h = mid;
        }

        return l;
    }
}