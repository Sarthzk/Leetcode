class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;

        for(int w : weights){
            high += w;
            low = Math.max(low, w);
        }
        int res = high;
        while(low <= high){
            int mid = low + (high-low) / 2;

            if(canShip(weights, days, mid)){
                res = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return res;
    }

    boolean canShip(int[] weights, int days, int s){
        int d = 1;
        int load = 0;
        for(int w : weights){
            if(load + w > s){
                d++;
                load = 0;
            }
            load += w;
        }
        return d <= days;
    }
}