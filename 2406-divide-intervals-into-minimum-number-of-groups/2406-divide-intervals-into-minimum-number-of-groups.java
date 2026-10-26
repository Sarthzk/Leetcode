class Solution {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> ends = new PriorityQueue<>();

        for(int[] m : intervals){
            if(!ends.isEmpty() && ends.peek() < m[0]){
                ends.poll();
            }
            ends.offer(m[1]);
        }
        return ends.size();
    }
}