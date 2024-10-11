class Solution {
    
    public boolean checkIfPossible(long x, int mountainHeight, int[] workerTimes) {
        int total = 0;
        for(int time: workerTimes) {
            long reduced = 0;
            long counter = 1;
            long currTime = 0;

            while(currTime + time * counter <= x) {
                currTime += time * counter;
                reduced++;
                counter++;
                if(total + reduced >= mountainHeight) return true;
            }
            total += reduced;
        }
        return total >= mountainHeight;
    }

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long l = 0, h = Long.MAX_VALUE >> 1;
        long res = -1;
        while(l<=h) {
            long mid = l+(h-l)/2;
            if(checkIfPossible(mid, mountainHeight, workerTimes)) {
                res = mid;
                h = mid - 1;
                System.out.println("Mid: " + mid + " H: " + h);
            } else {
                l = mid + 1;
                System.out.println("Mid: " + mid + " L: " + l);
            }
        }
        return res;
    }
}