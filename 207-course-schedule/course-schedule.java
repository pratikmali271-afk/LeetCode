class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

        for(int[] edges : prerequisites){
            int course = edges[0];
            int prerequesite = edges[1];
            adj.get(prerequesite).add(course);
        }

        int[] indegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0) q.add(i);
        }

        int i = 0;
        //int[] topoSort = new int[numCourses];
        List<Integer> topoSort = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.remove();
            topoSort.add(node);

            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0) q.add(it);
            }
        }

        if(topoSort.size() < numCourses) return false;
        else return true;
    }
}
