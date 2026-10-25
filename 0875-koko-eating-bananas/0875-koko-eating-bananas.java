class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1;
        int hi = 0;
        for(int p : piles) hi = Math.max(hi, p);
        int res = hi;

        while(lo <= hi){
            int mid = lo + (hi-lo) / 2;

            if(canFinish(piles, h, mid)){
                res = mid;
                hi = mid - 1;
            }
            else {
                lo = mid + 1;
            }
        }
        return res;
    }

    boolean canFinish(int[] piles, int h, int k){
        long hours = 0;
        for(int p : piles) hours += (p + k - 1)/k;
        return hours <= h;
    }
}