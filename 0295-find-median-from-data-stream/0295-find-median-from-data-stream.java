class MedianFinder {
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;

    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(small.isEmpty() || num <= small.peek()) small.offer(num);
        else large.offer(num);

        while(small.size() != large.size() && small.size() != large.size() + 1){
            if(small.size() < large.size()){
                int s = large.poll();
                small.offer(s);
            }
            else {
                int l = small.poll();
                large.offer(l);
            }
        }
    }
    
    public double findMedian() {
        if(small.size() == large.size()) {
            return (small.peek() + large.peek()) / 2.0;
        }
        else return small.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */