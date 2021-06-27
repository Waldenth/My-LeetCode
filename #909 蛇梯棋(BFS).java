class Solution {
    class State{
        int index;
        int times;
        public State(int index,int times){
            this.index=index;
            this.times=times;
        }
    }
    int N=1;
    public int snakesAndLadders(int[][] board) {
        N=board.length;
        int target=N*N;
        if(N<=1)
            return 0;
         boolean[][] visited=new boolean[N][N];
        Deque<State>queue=new ArrayDeque<>();
        State start=new State(1,0);
        queue.addLast(start);
        while(queue.size()>0){
            State curState=queue.pollFirst();

            if(curState.index+6>=target)
                return curState.times+1;
            for(int i=1;i<=6;i++){
                int nextIndex=curState.index+i;
                int[] coordination=getRowAndColumn(nextIndex);
                if(!visited[coordination[0]][coordination[1]]){
                    visited[coordination[0]][coordination[1]]=true;
                    if(board[coordination[0]][coordination[1]]!=-1){
                        nextIndex=board[coordination[0]][coordination[1]];
                    }
                    if(nextIndex==target)
                        return curState.times+1;
                    queue.addLast(new State(nextIndex,curState.times+1));
                }
            }
        }

        return -1;
    }
    private int[] getRowAndColumn(int index){
        index=index-1;
        int[] coordination=new int[2];
        int row=index/N;
        int column=index%N;
        if(row%2==1){//从右至左方
            column=N-column-1;
        }else{
            column=column;
        }
        row=N-row-1;
        coordination[0]=row;
        coordination[1]=column;
        return coordination;
    }
}