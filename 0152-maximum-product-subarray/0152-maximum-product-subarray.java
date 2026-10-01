class Solution {
    public int maxProduct(int[] nums) {
        int maxCurr = nums[0];
        int minCurr = nums[0];
        int best = nums[0];

        for(int i = 1; i< nums.length; i++){
            int tempMax = maxCurr;
            maxCurr = Math.max(nums[i], Math.max(tempMax * nums[i], minCurr * nums[i]));
            minCurr = Math.min(nums[i], Math.min(minCurr * nums[i], tempMax * nums[i]));
            best = Math.max(best, maxCurr);
        }
        return best;
    }
}