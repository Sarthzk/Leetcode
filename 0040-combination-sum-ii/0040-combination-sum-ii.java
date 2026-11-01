class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>());
        return res;
    }

    void backtrack(int[] c, int remaining, int start, List<Integer> path){
        if(remaining == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        if(remaining < 0) return;

        for(int i = start; i < c.length; i++){
            if (i > start && c[i] == c[i - 1]) continue;
            path.add(c[i]);
            backtrack(c, remaining - c[i], i + 1, path);
            path.remove(path.size() - 1);
        }
    }
}