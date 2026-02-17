class Solution {

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();

        for (int mask = 0; mask < (1 << 10); mask++) {
            if (Integer.bitCount(mask) != turnedOn) continue;

            int h = mask >> 6;
            int m = mask & 63;

            if (h < 12 && m < 60) {
                String time = h + ":" + (m < 10 ? "0" + m : String.valueOf(m));
                res.add(time);
            }
        }

        return res;
    }
}
