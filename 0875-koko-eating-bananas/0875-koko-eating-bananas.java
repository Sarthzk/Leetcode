class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;

        for(int i = 0; i < piles.length; i++){
            high = Math.max(high, piles[i]);
        }
        int ans = high;

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(canFinish(piles, h, mid)){
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }

    boolean canFinish(int[] piles, int h, int k){
        long hours = 0;
        for(int p : piles) hours += (p + k - 1) / k;
        return hours <= h;
    }
}