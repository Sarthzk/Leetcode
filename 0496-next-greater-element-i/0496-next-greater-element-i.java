class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums2){
            while(!stack.isEmpty() && num > stack.peek()){
                map.put(stack.pop(), num);

            }
            stack.push(num);
        }

        int n = nums1.length;
        int[] ans = new int[n];

        for(int i = 0; i < n; i++){
            ans[i] = map.getOrDefault(nums1[i], -1);
        }

        return ans;
    }
}