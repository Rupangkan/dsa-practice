class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = 0;
        for(int i = 0; i<apple.length; i++) {
            sum += apple[i];
        }
        int times = 0;
        Arrays.sort(capacity);
        for(int i = capacity.length-1; i>=0; i--) {
            if(sum <= 0) {
                break;
            }
            sum = sum - capacity[i];
            times += 1;
        }
        return times;
    }
}