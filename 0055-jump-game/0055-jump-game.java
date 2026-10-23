class Solution {
    public boolean canJump(int[] nums) {
        int farthest = nums[0];

        for(int i = 1; i < nums.length; i++){
            if(i > farthest) return false;
            farthest = Math.max(farthest, i + nums[i]);
        }
        return true;
    }
}