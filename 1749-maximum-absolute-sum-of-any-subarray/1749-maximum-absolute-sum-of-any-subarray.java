class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int curr = nums[0];
        int best = nums[0];
        int curr1 = nums[0];
        int best1 = nums[0];

        for(int i = 1; i < nums.length; i++){
            curr = Math.max(nums[i], curr + nums[i]);
            best = Math.max(best, curr);
            curr1 = Math.min(nums[i], curr1 + nums[i]);
            best1 = Math.min(best1, curr1);
        }
        return Math.max(best, Math.abs(best1));
    }
}