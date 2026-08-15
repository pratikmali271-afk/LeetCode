// Using BFS
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

        for(int[] edges : prerequisites){
            int course = edges[0];
            int prerequesite = edges[1];
            adj.get(prerequesite).add(course);
        }

        int[] indeg = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            for(int it : adj.get(i)) indeg[it]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indeg[i] == 0) q.add(i);
        }

        int[] topoSort = new int[numCourses];
        int i = 0;
        while(!q.isEmpty()){
            int node = q.remove();
            topoSort[i++] = node;

            for(int it : adj.get(node)){
                indeg[it]--;
                if(indeg[it] == 0) q.add(it);
            }
        }
        if(i != numCourses) {
            return new int[0];
        }
        return topoSort;    
    }
}