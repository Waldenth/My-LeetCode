class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> reverseGraph=new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            reverseGraph.add(new ArrayList<Integer>());
        }
        
        int[] inDegree=new int[graph.length];

        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++){
                reverseGraph.get(graph[i][j]).add(i);
            }
            inDegree[i]=graph[i].length;
            //System.out.println(i+" "+inDegree[i]);
        }
        Deque<Integer>safeNodes=new ArrayDeque<>();
        
        for(int i=0;i<graph.length;i++){
            if(inDegree[i]==0){
                safeNodes.offer(i);
                //System.out.println("init "+i);
            }
        }
        
        while(!safeNodes.isEmpty()){
            int tmp=safeNodes.poll();
            //System.out.println("tmp="+tmp);
            for(int canReachNode:reverseGraph.get(tmp)){
                inDegree[canReachNode]--;
                //System.out.println(canReachNode+" "+inDegree[canReachNode]);
                if(inDegree[canReachNode]==0){
                    safeNodes.offer(canReachNode);
                    //System.out.println("! "+canReachNode);
                }
            }
        }

        List<Integer>ans=new ArrayList<>();

        for(int i=0;i<graph.length;i++){
            //System.out.println(inDegree[i]);
            if(inDegree[i]==0)
                ans.add(i);
        }

        return ans;
    }
}