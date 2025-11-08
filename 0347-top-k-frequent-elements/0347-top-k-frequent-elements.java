class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num: nums) {
            if(map.containsKey(num)) {
                int val = map.get(num) + 1;
                map.put(num, val);
            } else {
                map.put(num, 1);
            }
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            pq.add(entry);
            if(pq.size() > k) pq.poll();
        }

        int[] ans = new int[k];

        for(int i = 0; i<k; i++) {
            ans[i] = pq.poll().getKey();
        }
        
        return ans;
    }
}