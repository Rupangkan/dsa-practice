class Solution {

    public int calculateSum(HashMap<Integer, Integer> map, int x) {
        List<Map.Entry<Integer, Integer>> sortList = new ArrayList<>(map.entrySet());
        sortList.sort((a, b) -> {
            if(a.getValue().equals(b.getValue())) {
                return b.getKey() - a.getKey();
            }
            return b.getValue() - a.getValue();
        });

        int sum = 0, count = 0;
        for(Map.Entry<Integer, Integer> entry: sortList) {
            int value = entry.getKey();
            int freq = entry.getValue();

            for(int i = 0; i<freq; i++) {
                sum += value;
                count++;
                if(count == x) break;
            }
            if(count == x) break;
        }

        return sum;
    }

    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int w = n - k + 1;
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i<w; i++) {
            int arrSum = 0;
            int sum = 0;
            int left = i;
            int right = i + k - 1;

            Map<Integer, Integer> map = new HashMap<>();

            for(int j = left; j<=right; j++) {
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
                arrSum += nums[j];
            }

            if(map.size() < x) {
                ans.add(arrSum);
                continue;
            }

            PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (a, b) -> {
                    if(a.getValue().equals(b.getValue())) {
                        return b.getKey() - a.getKey();
                    }
                    return b.getValue() - a.getValue();
                }
            );

            pq.addAll(map.entrySet());

            for(int kVal = 0; kVal < x; kVal++) {
                if(pq.isEmpty()) break;
                Map.Entry<Integer, Integer> temp = pq.poll();
                sum += temp.getKey() * temp.getValue();
            }
            ans.add(sum);
        }
        int[] res = new int[n-k+1];
        for(int i = 0; i<ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}