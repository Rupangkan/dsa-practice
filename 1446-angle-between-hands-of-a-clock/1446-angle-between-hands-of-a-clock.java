class Solution {

    public double angleClock(int hour, int minutes) {

        double time = hour + minutes / 60.0;

        double diff = (11 * time) % 12;

        return Math.min(diff, 12 - diff) * 30;
    }
}