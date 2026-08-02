class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) return false;

        HashMap<Character, Integer> count = new HashMap<>();

        for(int i = 0; i < s.length(); i++){

            count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0) + 1);

        }

        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            count.put(c, count.getOrDefault(c, 0) - 1);
            if(count.get(c) < 0) return false;
            
        }
        return true; 
        
        
    }
}