class Solution {
    public List<Integer> lexicalOrder(int n) {
        int curr = 1;
        List<Integer> lex = new ArrayList<>();

        for(int i = 0; i<n; i++) {
            lex.add(curr);
            if(curr * 10 <= n) curr *= 10;
            else {
                while(curr % 10 == 9 || curr >= n) curr /= 10;
                curr += 1;
            }
        }

        return lex;
    }
}