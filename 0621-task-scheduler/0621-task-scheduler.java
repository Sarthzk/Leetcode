class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> ready = new PriorityQueue<>(Collections.reverseOrder());
        int[] arr = new int[26];

        for(char c : tasks){
            arr[c - 'A']++;
        }

        for(int i = 0; i < 26; i++){
            if(arr[i] != 0){
                ready.offer(arr[i]);
            }
        }
        Queue<int[]> waiting = new LinkedList<>();
        int time = 0;

        while(!ready.isEmpty() || !waiting.isEmpty()){
            time++;
            
            while(!waiting.isEmpty() && waiting.peek()[1] <= time){
                ready.offer(waiting.poll()[0]);
            }

            if(!ready.isEmpty()) {
                int count = ready.poll() - 1;
                if(count > 0) waiting.offer(new int[]{count, time + n + 1});
            }
            
        }
        return time;
    }
}