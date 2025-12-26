class Solution {
    public int bestClosingTime(String customers) {
        int minPenalty = 0, curPenalty = 0, res = 0;
        for (int i = 0; i < customers.length(); i++) {
            curPenalty += customers.charAt(i) == 'Y' ? -1 : 1;
            if (curPenalty < minPenalty) {
                minPenalty = curPenalty;
                res = i + 1;
            }
        }
        return res;
    }
}
