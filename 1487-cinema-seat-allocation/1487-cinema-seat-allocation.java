class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int left = 0b11110000;
        int mid = 0b11000011;
        int right = 0b00001111;

        Map<Integer, Integer> rows = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int col = seat[1];
            if (col >= 2 && col <= 9)
                rows.merge(seat[0], 1 << (col - 2), (a, b) -> a | b);
        }

        int ans = (n - rows.size()) * 2;

        for (int mask : rows.values()) {
            if ((mask | left) == left ||
                (mask | mid) == mid ||
                (mask | right) == right) {
                ans++;
            }
        }

        return ans;
    }
}