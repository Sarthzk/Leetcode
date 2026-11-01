class Solution {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtrack(s, 0, new ArrayList<>());
        return res;
    }

    void backtrack(String s, int start, List<String> path){
        if(start == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = start; i < s.length(); i++){
            if (isPal(s, start, i)) {
                path.add(s.substring(start, i+1));
                backtrack(s, i + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }

    boolean isPal(String s, int l, int r){
        while(l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}