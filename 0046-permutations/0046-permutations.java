class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        backtrack(nums, path, res);
        return res;
        
    }

    void backtrack(int[] nums, List<Integer> path, List<List<Integer>> res){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int num : nums){
            if(path.contains(num)) continue;
            path.add(num);
            backtrack(nums, path, res);
            path.remove(path.size() - 1);
        }

    }
}