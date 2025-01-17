class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int sum = 0;
        for(int i: derived) sum += i;
        return sum % 2 == 0;
    }
}