class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> hash = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            hash.put(arr[i], hash.getOrDefault(arr[i], 0) + 1);
        }
        
        Set<Integer> s = new HashSet<>();
        for(int x : hash.values()){
            s.add(x);
        }
        return hash.size() == s.size();    
    }
}