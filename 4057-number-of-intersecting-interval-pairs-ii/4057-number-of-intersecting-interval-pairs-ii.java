class Solution {
    public long countIntersectingIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int n = intervals.length;
        long count = 0;

        for(int i = 0; i < n; i++){
            int end = intervals[i][1];
            int low = i + 1;
            int high = n - 1;
            int last = i;

            while(low <= high){
                int mid = low + (high - low) / 2;

                if(intervals[mid][0] <= end){
                    last = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            count += last - i;
        }
        return count;
    }
}