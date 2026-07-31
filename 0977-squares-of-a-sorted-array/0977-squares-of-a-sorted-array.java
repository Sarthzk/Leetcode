class Solution {
    public int[] sortedSquares(int[] nums) {
        int [] result = new  int[nums.length];
        int pos = nums.length - 1;
        int right = nums.length - 1;
        int left = 0;

        while(left <= right){
            if(Math.abs(nums[left]) > Math.abs(nums[right])){
                result[pos] = nums[left]*nums[left];
                left ++;
            }else{
                result[pos] = nums[right]*nums[right];
                right --;
            }
            pos --;
        }
        return result;
    }
}