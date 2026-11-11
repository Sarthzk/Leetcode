class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int n = nums.length;

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int number = entry.getKey();
            int count = entry.getValue();

            if(count > n/2) return number; 
        }
        return -1;
    }
}