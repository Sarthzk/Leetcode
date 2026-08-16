class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        List<Integer> ans1 = new ArrayList<>();

        for(int i : nums1){
            set.add(i);
        }

        for(int i : nums2){
            set1.add(i);
        }

        for(int i : set){
            if(!set1.contains(i)){
                ans.add(i);
            }
        }
        for(int i : set1){
            if(!set.contains(i)){
                ans1.add(i);
            }
        }
        res.add(ans);
        res.add(ans1);
        return res;
        
    }
}