class Solution {
    public int pivotIndex(int[] nums) {
        int j = nums.length;
        int [] prefix = new int[j];
        int [] suffix = new int[j];
        
        prefix[0] = 0;
        suffix[j - 1] = 0;

        for (int i = 1; i < j; i++){
            prefix[i] = prefix[i-1] + nums[i-1];
        }

        for(int i = j - 2; i >= 0; i--){
            suffix[i] = suffix[i+1] + nums[i+1];  
        }

        for(int i = 0; i < j; i++){
            if(prefix[i] == suffix[i]){
                return i;
            }
            
        }
        return -1;
    }
}