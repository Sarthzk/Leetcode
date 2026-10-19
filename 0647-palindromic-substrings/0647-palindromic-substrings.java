class Solution {
    public int countSubstrings(String s) {
        int total = 0;
        for(int i = 0; i < s.length(); i++){
            total += expand(s, i, i) + expand(s, i, i + 1);
        }
        return total;
    }

    int expand(String s, int l, int r){
        int count = 0;
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            count++;
            l--;
            r++;
        }
        return count;
    }
}