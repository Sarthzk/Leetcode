class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] need = new int[26];
        int[] window = new int[26];
        int left = 0;

        if(s1.length() > s2.length()) return false;

        for(int i = 0; i < s1.length(); i++){
            need[s1.charAt(i) - 'a']++;
        }

        for(int right = 0; right < s2.length(); right++){
            window[s2.charAt(right) - 'a']++;

            if(right - left + 1 == s1.length()){
                if (Arrays.equals(need, window)) return true;
                window[s2.charAt(left) - 'a']--;
                left++;
            }
        }
        return false;
    }
}