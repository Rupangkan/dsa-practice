class Solution {

    boolean isPrime(int no) {
        if(no < 2) return false;
        if(no == 2 || no == 3) return true;
        if(no % 2 == 0) return false;
        for(int i = 3; i*i<= no; i+=2) {
            if(no % i == 0) return false;
        }
        return true;
    }

    public int[] closestPrimes(int left, int right) {
        int prev = -1, cl = -1, cb = -1, min = (int) 1e6;
        for(int i = left; i<=right; i++) {
            if(isPrime(i)) {
                if(prev != -1) {
                    int diff = i - prev;
                    if(diff < min) {
                        min = diff;
                        cl = prev;
                        cb = i;
                    }
                    if(diff == 2 || diff == 1) return new int[] {prev, i};   
                }
                prev = i;
            }
        }
        return (cl == -1) ? new int[] {-1, -1} : new int[] {cl, cb};
    }
}