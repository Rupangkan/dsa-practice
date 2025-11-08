class MedianFinder {

    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;

    public MedianFinder() {
        small = new PriorityQueue<>((a, b) -> b - a);
        large = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        small.offer(num);

        if((!small.isEmpty() && !large.isEmpty()) && (small.peek() > large.peek())) {
            int val = small.poll();
            large.add(val);
        }

        if(small.size() > large.size() + 1) {
            int val = small.poll();
            large.add(val);
        }

        if(large.size() > small.size() + 1) {
            int val = large.poll();
            small.add(val);
        }
    }
    
    public double findMedian() {
        int n = small.size() + large.size();
        if(n % 2 == 0) {
            return (double) (small.peek() + large.peek()) / 2.0;
        } else {
            return (small.size() > large.size()) ? small.peek() : large.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */