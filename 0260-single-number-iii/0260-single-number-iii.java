class Solution {
    public int[] singleNumber(int[] nums) {
        int xorAll = 0;
        for(int i = 0; i < nums.length; i++){
            xorAll ^= nums[i];
        }
        int lowestBit = xorAll & -xorAll;
        int a = 0;
        int b = 0;
        for(int num : nums){
            if((num & lowestBit) != 0) a ^= num;
            else b ^= num;
        }
        return new int[] {a, b};
    }
}