class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while(start <= end){
            char first = Character.toLowerCase(s.charAt(start));
            char last = Character.toLowerCase(s.charAt(end));

            if(!Character.isLetterOrDigit(first)){
                start ++;
                continue;
            }
            if(!Character.isLetterOrDigit(last)){
                end --;
                continue;
            }
            if(first != last){
                return false;
            }
            start ++;
            end --;
        }
        return true;
        
    }
}