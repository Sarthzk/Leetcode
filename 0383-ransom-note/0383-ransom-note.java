class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        HashMap<Character, Integer> count = new HashMap<>();

        for(int i = 0; i < magazine.length(); i++){
            char c = magazine.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);

        }

        for(int i = 0; i < ransomNote.length(); i++){
            char s = ransomNote.charAt(i);
            count.put(s, count.getOrDefault(s, 0) - 1);
            if (count.get(s)<0) return false;
        }

        return true;
        
    }
}