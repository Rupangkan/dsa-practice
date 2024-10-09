class Solution {
    class Pair {
        int ar;
        int de;
        int i;

        Pair(int x, int y, int z) {
            ar = x;
            de = y;
            i = z;
        }
    }

    public int smallestChair(int[][] times, int targetFriend) {
        PriorityQueue<Integer> avail = new PriorityQueue<>(); // Just the chair index
        int[] target = times[targetFriend];
        for(int i = 0; i<times.length; i++) {
            avail.add(i);
        }
        Arrays.sort(times, (a,b) -> a[0] - b[0]);
        PriorityQueue<int[]> used = new PriorityQueue<>((a,b) -> a[0] - b[0]); // Leaving and the chair index
        for(int i = 0; i<times.length; i++) {
            while(!used.isEmpty() && used.peek()[0] <= times[i][0]) {
                avail.offer(used.poll()[1]);
            }
            if(times[i][0] == target[0]) break;

            used.offer(new int[] {times[i][1], avail.poll()});
        }
        return avail.peek();
        
    }
}