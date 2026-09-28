class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        int[] prereqCount = new int[numCourses];

        for(int[] e : prerequisites){
            adj.get(e[1]).add(e[0]);
            prereqCount[e[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses; i++){
            if(prereqCount[i] == 0){
                q.offer(i);
            }
        }

        int taken = 0;

        while(!q.isEmpty()){
            int course = q.poll();
            taken++;

            for(int i : adj.get(course)){
                prereqCount[i]--;

                if(prereqCount[i] == 0){
                    q.offer(i);
                }
            } 
        }
        return taken == numCourses;
    }
}