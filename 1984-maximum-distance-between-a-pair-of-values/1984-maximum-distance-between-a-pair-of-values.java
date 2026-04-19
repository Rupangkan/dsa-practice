class Solution {

    public int maxDistance(int[] A, int[] B) {
        int i = 0, j = 0;

        while (i < A.length && j < B.length) {
            if (A[i] > B[j]) i++;
            j++;
        }

        int res = j - i - 1;
        return res > 0 ? res : 0;
    }
}