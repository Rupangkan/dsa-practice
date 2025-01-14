class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length, count = 0;
        int[] prefix = new int[n];
        int[] freq = new int[n+1];

        for(int i = 0; i<n; i++) {
            freq[A[i]] += 1;
            if(freq[A[i]] == 2) count++;
            freq[B[i]] += 1;
            if(freq[B[i]] == 2) count++;
            prefix[i] = count;
        }
        
        return prefix;
    }
}