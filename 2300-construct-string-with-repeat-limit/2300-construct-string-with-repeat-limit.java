class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> Character.compare(b, a));
        StringBuilder ans = new StringBuilder();

        for(char c: s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        for(char c: charCount.keySet()) {
            pq.offer(c);
        }

        while(!pq.isEmpty()) {
            char c = pq.poll();
            int count = charCount.get(c);
            int curr = Math.min(count, repeatLimit);

            for(int i = 0; i<curr; i++) {
                ans.append(c);
            }
            
            charCount.put(c, count - curr);

            if(charCount.get(c) > 0 && !pq.isEmpty()) {
                char nextC = pq.poll();
                ans.append(nextC);
                charCount.put(nextC, charCount.get(nextC) - 1);
                if(charCount.get(nextC) > 0) pq.offer(nextC);
                pq.offer(c);
            }
        }

        return ans.toString();
    }
}