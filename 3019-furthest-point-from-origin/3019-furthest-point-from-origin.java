class Solution {

    public int furthestDistanceFromOrigin(String moves) {
        int l = 0, r = 0, b = 0;

        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            if (c == 'L') l++;
            else if (c == 'R') r++;
            else b++;
        }

        int d = l - r;
        if (d < 0) d = -d;
        return d + b;
    }
}