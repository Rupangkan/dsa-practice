class Solution {
    public int[] lexicographicallySmallestArray(int[] a, int lim) {
        int[] b = a.clone();
        Arrays.sort(b);

        int g = 0;
        HashMap<Integer, Integer> numToGrp = new HashMap<>();
        HashMap<Integer, LinkedList<Integer>> grpToList = new HashMap<>();
        numToGrp.put(b[0], g);
        grpToList.put(g, new LinkedList<>(Arrays.asList(b[0])));

        for (int i = 1; i < a.length; i++) {
            if (Math.abs(b[i] - b[i - 1]) > lim) g++;
            numToGrp.put(b[i], g);
            grpToList.computeIfAbsent(g, k -> new LinkedList<>()).add(b[i]);
        }

        for (int i = 0; i < a.length; i++) 
            a[i] = grpToList.get(numToGrp.get(a[i])).pop();

        return a;
    }
}