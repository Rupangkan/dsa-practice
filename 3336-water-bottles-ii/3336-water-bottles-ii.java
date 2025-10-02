class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int empty = numBottles;
        int ans = numBottles;
        numBottles = 0;

        while(empty>=numExchange) {
            empty -= numExchange;
            numExchange++;
            empty++;
            ans++;
        }
        return ans;
    }
}