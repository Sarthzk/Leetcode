class KthLargest {
    private int k;
    private PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>(k);

        for(int num : nums){
            if(pq.size() < k){
                pq.offer(num);
            }
            else if(num > pq.peek()){
                pq.offer(num);
                if(pq.size() > k){
                    pq.poll();
                }
            }
        }
    }
    
    public int add(int val) {
        if(pq.size() < k){
            pq.offer(val);
        }
        else if(val > pq.peek()){
            pq.offer(val);
            pq.poll();
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */