class Solution {
    public long maxValue(int[] nums) {
        int n = nums.length;
        long pulse = 0;
        long[] w = new long[n];

        for(int i = 0; i < n; i++){
            if(i%2 == 0){
                w[i] = nums[i];
            } else {
                w[i] = -nums[i];
            }
            pulse += w[i];
        }

        long minBlock = Long.MAX_VALUE;
        
        for(int start = 0; start <= 1; start++){
            long minCurr = 0;

            for(int i = start; i + 1 < n; i += 2){
                long pair = w[i] + w[i+1];
                minCurr = (i == start) ? pair : Math.min(pair, minCurr + pair);
                minBlock = Math.min(minBlock, minCurr);
            }
        }

        if(minBlock == Long.MAX_VALUE) return pulse;

        return pulse + Math.max(0, -2 * minBlock);
    }
}