class Solution {
    
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int minAbs = Integer.MAX_VALUE, negCount = 0;

        for(int[] r: matrix) {
            for(int i: r) {
                sum+=Math.abs(i);
                if(i<0){
                    negCount++;
                }
                minAbs=Math.min(minAbs,Math.abs(i));
            }
        }
        if(negCount%2!=0) sum-=2*minAbs;
        return sum;
    }
}