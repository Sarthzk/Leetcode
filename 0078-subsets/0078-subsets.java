class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int index = 0;
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        backtrack(nums, index, path, res);
        return res;
    }

    void backtrack(int[] nums, int index, List<Integer> path, List<List<Integer>> res){

        if(index == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        path.add(nums[index]);
        backtrack(nums, index+1, path, res);
        path.remove(path.size() - 1);

        backtrack(nums, index + 1, path, res);
    }
}