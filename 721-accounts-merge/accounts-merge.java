class DisjointSet{
    int[] parent;
    int[] rank;

    DisjointSet(int n){
        parent = new int[n];
        rank = new int[n];

        for(int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 0;
        }
    }

    int findPar(int u){
        if(parent[u] == u) return u;
        int up = findPar(parent[u]);
        parent[u] = up;
        return up;
    }

    void unionByrank(int u, int v){ // 3 and 0
        int pu = findPar(u);
        int pv = findPar(v);

        if(pu == pv) return;

        if(rank[pu] > rank[pv]){
            parent[pv] = pu;
        }
        else if(rank[pv] > rank[pu]){
            parent[pu] = pv;
        }
        else{
            parent[pv] = pu;
            rank[pu]++;
        }
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            for(int j = 1; j < accounts.get(i).size(); j++){
                String mail = accounts.get(i).get(j);
                if(!map.containsKey(mail)){
                    map.put(mail, i);
                } else{
                    ds.unionByrank(i, map.get(mail));
                }
            }
        }

        ArrayList<String>[] mergeMail = new ArrayList[n];
        for(int i = 0; i < n; i++){
            mergeMail[i] = new ArrayList<>();
        }
        for(String mail : map.keySet()){
            int node = ds.findPar(map.get(mail));
            mergeMail[node].add(mail);
        }

        List<List<String>> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(mergeMail[i].size() == 0) continue;
            Collections.sort(mergeMail[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String it : mergeMail[i]){
                temp.add(it);
            }
            ans.add(temp);
        }
        return ans;
    }
}