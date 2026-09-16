class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] res = new String[n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for(int i = 0; i < n; i++){
            pq.offer(new int[]{score[i], i});
        }

        int rank = 1;

        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int og = current[1];

            if(rank == 1){
                res[og] = "Gold Medal";
            }
            else if(rank == 2){
                res[og] = "Silver Medal";
            }
            else if(rank == 3){
                res[og] = "Bronze Medal";
            }
            else {
                res[og] = String.valueOf(rank);
            }
            rank++;
        }
        return res;
    }
}