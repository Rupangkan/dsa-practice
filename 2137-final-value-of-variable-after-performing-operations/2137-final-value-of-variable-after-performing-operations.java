public class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int val = 0;
        for (String op : operations) {
            val += (op.charAt(1) == '+') ? 1 : -1;
        }
        return val;
    }
}
