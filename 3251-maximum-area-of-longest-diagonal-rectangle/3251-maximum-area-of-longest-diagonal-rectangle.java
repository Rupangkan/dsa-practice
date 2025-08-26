class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int mx = 0, res = 0;
        for (int[] d : dimensions) {
            int a = d[0], b = d[1], dia = a * a + b * b, ar = a * b;
            if (dia > mx || (dia == mx && ar > res)) {
                mx = dia;
                res = ar;
            }
        }
        return res;
    }
}