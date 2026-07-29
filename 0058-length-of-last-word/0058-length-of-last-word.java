class Solution {
    public int lengthOfLastWord(String s) {
        
        String t = s.trim();
        int count = 0;

        for (int i = t.length() - 1; i >= 0; i-- ){
            if(t.charAt(i) != ' '){
                count++;
            }else{
                break;
            }

        }
        return count;
    }
}