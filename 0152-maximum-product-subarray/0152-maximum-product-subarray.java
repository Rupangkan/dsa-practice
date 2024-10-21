class Solution {
    public int maxProduct(int[] arr) {
        int min = 1, max = 1, res = arr[0];

        for(int i = 0; i<arr.length; i++) {
            int temp = arr[i] * max;
            max = Math.max(arr[i], Math.max(temp, arr[i] * min));
            min = Math.min(arr[i], Math.min(temp, arr[i] * min));
            res = Math.max(max, res);
        }

        return res;
    }
}