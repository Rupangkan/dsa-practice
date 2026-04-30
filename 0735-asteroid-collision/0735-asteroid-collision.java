class Solution {
    public int[] asteroidCollision(int[] ast) {
        List<Integer> stack = new ArrayList<>();
        int n = ast.length;

        for(int i = 0; i<n; i++) {
            if(ast[i] > 0) {
                stack.add(ast[i]);
            } else {
                while(!stack.isEmpty() && stack.get(stack.size()-1) > 0 && stack.get(stack.size()-1) < Math.abs(ast[i])) stack.remove(stack.size()-1);
                if(!stack.isEmpty() && stack.get(stack.size()-1) > 0 && stack.get(stack.size()-1) == Math.abs(ast[i])) stack.remove(stack.size()-1);
                else if(stack.isEmpty() || stack.get(stack.size()-1) < 0) stack.add(ast[i]);
            }
        }

        int[] ans = new int[stack.size()];

        for(int i = 0; i<stack.size(); i++) {
            ans[i] = stack.get(i);
        }

        return ans;
    }
}