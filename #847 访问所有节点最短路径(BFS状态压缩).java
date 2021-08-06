class Solution {
    public int shortestPathLength(int[][] graph) {
        Deque<int[]>queue = new ArrayDeque<>();
        int n=graph.length;
        boolean hasSeen[][]=new boolean[n][1<<n];
        for(int i=0;i<n;i++){
            queue.addLast(new int[]{i,1<<i,0});//每个点都视作起点，各自进行BFS
            hasSeen[i][1<<i]=true;
        }
        while(queue.size()!=0){
            int [] tmpState=queue.poll();
            if(tmpState[1]==(1<<n)-1){
                return tmpState[2];
            }
            for(int adjacent:graph[tmpState[0]]){
                int curSeenState=tmpState[1]|(1<<adjacent);
                if(!hasSeen[adjacent][curSeenState]){
                    queue.addLast(new int[]{adjacent,curSeenState,tmpState[2]+1});
                    hasSeen[adjacent][curSeenState]=true;
                }
            }
        }
        return -1;
    }
}