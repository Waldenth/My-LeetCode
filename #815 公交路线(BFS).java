class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source==target)
            return 0;
        int n=routes.length; //公交线路数量
        boolean[][] edge=new boolean[n][n];//哪些公交线路是联通的,联通的线路彼此节点可达,次数+1
        Map<Integer,List<Integer>>routesMap=new HashMap<>();//<车站,所属线路的序号的列表>
        for(int i=0;i<n;i++){
            for(int site:routes[i]){
                List<Integer>connectedLine=routesMap.getOrDefault(site,new ArrayList<Integer>());
                for(int j:connectedLine){
                    edge[i][j]=edge[j][i]=true;//第i和j号线路彼此可达
                }
                connectedLine.add(i);
                routesMap.put(site,connectedLine);
            }
        }
        int[] distance=new int[n];
        Arrays.fill(distance,-1);
        Deque<Integer>queue =new ArrayDeque<>();
        for(int lineNumber:routesMap.getOrDefault(source,new ArrayList<Integer>())){
            distance[lineNumber]=1;
            queue.addLast(lineNumber);
        }
        while(queue.size()>0){
            int curLineNumber=queue.pollFirst();
            for(int i=0;i<n;i++){
                if(edge[curLineNumber][i]&&distance[i]==-1){
                    distance[i]=distance[curLineNumber]+1;
                    queue.addLast(i);
                }
            }
        }

        int res=Integer.MAX_VALUE;
        for(int site:routesMap.getOrDefault(target,new ArrayList<Integer>())){
            if(distance[site]!=-1)
                res=Math.min(res,distance[site]);
        }
        return res==Integer.MAX_VALUE?-1:res;   
    }
}