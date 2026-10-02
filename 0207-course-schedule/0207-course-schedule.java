class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        int[] prereq = new int[numCourses];

        for(int[] e : prerequisites){
            adj.get(e[1]).add(e[0]);
            prereq[e[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses; i++){
            if(prereq[i] == 0) q.offer(i);
        }

        int taken = 0;

        while(!q.isEmpty()){
            int curr = q.poll();
            taken++;

            for(int i : adj.get(curr)){
                prereq[i]--;
                if(prereq[i] == 0) q.offer(i);
            }
        }
        return numCourses == taken;
    }
}