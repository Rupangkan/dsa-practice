class Solution {
    boolean isPrime(int num) {
        for(int i = 2; i*i<=num; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }

    void setPrimes(ArrayList<Integer> primes, int max) {
        for(int i = 2; i<=max; i++) {
            if(isPrime(i)) primes.add(i);
        }
    }

    void setLower(int[] nums, ArrayList<Integer> primes, int next) {
        for(int i = 0; i<primes.size(); i++) {
            int diff = nums[next-1] - primes.get(i);
            if(diff > 0 && diff < nums[next]) {
                nums[next-1] = diff;
                break;
            }
        }
    }

    public boolean primeSubOperation(int[] nums) {
        int n = nums.length, max = 0;
        ArrayList<Integer> primes = new ArrayList<>();

        for(int i = 0; i<n; i++) {
            max = Math.max(max, nums[i]);
        }

        setPrimes(primes, max);

        for(int i = n-2; i>=0; i--) {
            if(nums[i]>=nums[i+1]) {
                setLower(nums, primes, i+1);
            }
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(primes);
        for(int i = 0; i<n-1; i++) {
            if(nums[i]>=nums[i+1]) return false;
        }
        return true;
    }
}