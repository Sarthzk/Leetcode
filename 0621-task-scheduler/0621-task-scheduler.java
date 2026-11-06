class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int[] arr = new int[26];

        for(char c : tasks){
            arr[c - 'A']++;
        }

        for(int i = 0; i < 26; i++){
            if(arr[i] != 0) pq.offer(arr[i]);
        }

        Queue<int[]> q = new LinkedList<>();
        int time = 0;

        while(!pq.isEmpty() || !q.isEmpty()){
            time++;

            while(!q.isEmpty() && q.peek()[1] <= time){
                pq.offer(q.poll()[0]);
            }

            if(!pq.isEmpty()){
                int count = pq.poll() - 1;
                if(count > 0) q.offer(new int[]{count, time + n + 1});
            }
        }
        return time;
    }
}