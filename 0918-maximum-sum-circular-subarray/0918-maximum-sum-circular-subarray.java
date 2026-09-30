class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int currMax = nums[0];
        int bestMax = nums[0];
        int currMin = nums[0];
        int bestMin = nums[0];
        int total = nums[0];

        for(int i = 1; i < nums.length; i++){
            currMax = Math.max(nums[i], currMax + nums[i]);
            bestMax = Math.max(bestMax, currMax);

            currMin = Math.min(nums[i], currMin + nums[i]);
            bestMin = Math.min(bestMin, currMin);
            total += nums[i];
        }
        int wrap = total - bestMin;
        
        if (bestMax < 0) return bestMax;

        return Math.max(bestMax, wrap);
    }
}