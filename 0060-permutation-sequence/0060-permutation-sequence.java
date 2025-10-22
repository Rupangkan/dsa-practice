class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> temp = new ArrayList<>();
        int fact = 1;

        for(int i = 1; i<n; i++) {
            fact *= i;
            temp.add(i);
        }
        temp.add(n);

        k = k-1;
        String ans = "";

        while(true) {
            ans += temp.get(k / fact);
            temp.remove(k / fact);
            if(temp.size() == 0) break;
            k = k % fact;
            fact = fact / temp.size();
        }

        return ans;
    }
}