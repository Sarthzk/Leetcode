class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int sum = 0;
        int start = 0;
        backtrack(candidates, target, start, sum, path, res);
        return res;
    }

    void backtrack(int[] candidates, int target, int start, int sum, List<Integer> path, List<List<Integer>> res){
        if(sum == target){
            res.add(new ArrayList<>(path));
            return ;
        }
        if(sum > target) return;

        for(int i = start; i < candidates.length; i++){
            path.add(candidates[i]);
            backtrack(candidates, target, i, sum + candidates[i], path, res);
            path.remove(path.size() - 1);
        }
    }
}