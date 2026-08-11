class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int a = findBound(nums, target, true);
        int b = findBound(nums, target, false);

        return new int[]{a, b};

        
    }

    int findBound(int[] nums, int target, boolean findFirst){
        int low = 0;
        int high = nums.length - 1;
        int res = -1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(nums[mid] == target){
                res = mid;
                if(findFirst){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            } else if(nums[mid] > target){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }
}