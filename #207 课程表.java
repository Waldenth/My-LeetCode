class Solution {
    List<List<Integer>>adjList;
    boolean canFinishCourses=true;
    int[] visited;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adjList=new ArrayList<List<Integer>>();
        for(int i=0;i<numCourses;i++){
            adjList.add(new ArrayList<Integer>());
        }
        for(int i=0;i<prerequisites.length;i++){
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        visited=new int[numCourses];//默认0
        for(int i=0;i<numCourses&&canFinishCourses;i++){
            if(visited[i]==0){
                dfs(i);
            }
        }
        return canFinishCourses;
    }
    private void dfs(int curVertex){
        visited[curVertex]=1;
        for(int i:adjList.get(curVertex)){
            if(visited[i]==0){
                dfs(i);
                if(!canFinishCourses)
                    return;
            }else if(visited[i]==1){
                canFinishCourses=false;
                return;
            }else
                continue;
        }
        visited[curVertex]=2;
    }
}