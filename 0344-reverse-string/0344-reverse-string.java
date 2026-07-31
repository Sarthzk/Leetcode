class Solution {
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;

        for (; start <= end; start++){

            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;

            end--;

        }

        
    }
}