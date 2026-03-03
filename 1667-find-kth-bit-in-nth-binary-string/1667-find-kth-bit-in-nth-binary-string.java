class Solution {
    public char findKthBit(int n, int k) {
        int lb = k & -k;
        boolean inv = (((k / lb) >> 1) & 1) == 1;
        char c = (k & 1) == 0 ? '1' : '0';
        return inv ? (c == '1' ? '0' : '1') : c;
    }
}
