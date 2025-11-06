class Helper {

    private int x;
    private long result;
    private TreeSet<Pair> large, small;
    private Map<Integer, Integer> occ;

    private static class Pair implements Comparable<Pair> {
        int first, second;
        Pair(int first, int second) { this.first = first; this.second = second; }
        public int compareTo(Pair other) {
            if (this.first != other.first) return Integer.compare(this.first, other.first);
            return Integer.compare(this.second, other.second);
        }
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pair pair = (Pair) obj;
            return first == pair.first && second == pair.second;
        }
        public int hashCode() { return Objects.hash(first, second); }
    }

    public Helper(int x) {
        this.x = x;
        result = 0;
        large = new TreeSet<>();
        small = new TreeSet<>();
        occ = new HashMap<>();
    }

    public void insert(int num) {
        if (occ.containsKey(num) && occ.get(num) > 0) internalRemove(new Pair(occ.get(num), num));
        occ.put(num, occ.getOrDefault(num, 0) + 1);
        internalInsert(new Pair(occ.get(num), num));
    }

    public void remove(int num) {
        internalRemove(new Pair(occ.get(num), num));
        occ.put(num, occ.get(num) - 1);
        if (occ.get(num) > 0) internalInsert(new Pair(occ.get(num), num));
    }

    public long get() { return result; }

    private void internalInsert(Pair p) {
        if (large.size() < x || p.compareTo(large.first()) > 0) {
            result += (long)p.first * p.second;
            large.add(p);
            if (large.size() > x) {
                Pair t = large.first();
                result -= (long)t.first * t.second;
                large.remove(t);
                small.add(t);
            }
        } else small.add(p);
    }

    private void internalRemove(Pair p) {
        if (p.compareTo(large.first()) >= 0) {
            result -= (long)p.first * p.second;
            large.remove(p);
            if (!small.isEmpty()) {
                Pair t = small.last();
                result += (long)t.first * t.second;
                small.remove(t);
                large.add(t);
            }
        } else small.remove(p);
    }
}

class Solution {
    public long[] findXSum(int[] nums, int k, int x) {
        Helper helper = new Helper(x);
        List<Long> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            helper.insert(nums[i]);
            if (i >= k) helper.remove(nums[i - k]);
            if (i >= k - 1) ans.add(helper.get());
        }
        return ans.stream().mapToLong(Long::longValue).toArray();
    }
}
