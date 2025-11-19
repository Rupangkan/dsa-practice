class Solution {
    public int findFinalValue(int[] a, int x) {
        HashSet<Integer> st = new HashSet<>();
        for (int v : a) st.add(v);
        while (st.contains(x)) x <<= 1;
        return x;
    }
}
