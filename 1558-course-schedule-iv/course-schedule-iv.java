class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] isPrereq = new boolean[numCourses][numCourses];

        for(int[] p : prerequisites){
            isPrereq[p[0]][p[1]] = true;
        }

        // Floyd-Warshall
        for(int k = 0; k < numCourses; k++){
            for(int i = 0; i < numCourses; i++){
                for(int j = 0; j < numCourses; j++){
                    isPrereq[i][j] = isPrereq[i][j] || (isPrereq[i][k] && isPrereq[k][j]);
                }
            }
        }

        List<Boolean> ans = new ArrayList<>();
        for(int[] query : queries){
            int u = query[0];
            int v = query[1];
            ans.add(isPrereq[u][v]);
        }

        return ans;
    }
}