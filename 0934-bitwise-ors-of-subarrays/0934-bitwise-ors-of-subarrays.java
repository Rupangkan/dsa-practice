class Solution {
    public int subarrayBitwiseORs(int[] a) {
        Set<Integer> res = new HashSet<>();
        Set<Integer> cur = new HashSet<>();
        cur.add(0);
        for (int x : a) {
            Set<Integer> tmp = new HashSet<>();
            for (int y : cur) tmp.add(x | y);
            tmp.add(x);
            cur = tmp;
            res.addAll(cur);
        }
        return res.size();  
    }
}