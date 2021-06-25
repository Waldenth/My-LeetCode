class Solution {
    boolean[] visited;
    int[][] allState;

    class ChangedState{
        int num;
        int changeNum;
        public ChangedState(int n,int m){
            this.num=n;
            this.changeNum=m;
        }
    }

    public int openLock(String[] deadends, String target) {
        visited=new boolean[10000];
        allState=new int[4][10];
        for(int i=0;i<4;i++){
            for(int j=0;j<10;j++){
                allState[i][j]=j;
            }
        }

        int[] deadNums=new int[deadends.length];
        int targetNum=Integer.valueOf(target);

        for(int i=0;i<deadends.length;i++){
            deadNums[i]=Integer.valueOf(deadends[i]);
        }
        
        Deque<ChangedState> queue=new ArrayDeque<ChangedState>();
        queue.add(new ChangedState(0,0));
        visited[0]=true;
        
        int needRollNum=0;

        if(0==targetNum)
            return needRollNum;
        if(isLocked(deadNums,0))
            return -1;

        while(queue.size()!=0){
            ChangedState curState=queue.pollFirst();
            int[] nextStates=getNextStates(curState.num);
            for(int i=0;i<8;i++){
                if(!visited[nextStates[i]]){
                    if(targetNum==nextStates[i]){
                        return curState.changeNum+1;
                    }
                    if(!isLocked(deadNums,nextStates[i])){
                        queue.addLast(new ChangedState(nextStates[i],curState.changeNum+1));
                    }
                    visited[nextStates[i]]=true;
                }
            }
        }

        return -1;
    }
    private int[]getNextStates(int n){
        int tmpN=n;
        int[] curNum=new int[4];
        int curIndex=3;
        int[]states=new int[8];
        while(tmpN!=0){
            curNum[curIndex]=tmpN%10;
            tmpN=tmpN/10;
            curIndex--;
        }
        for(;curIndex>=0;curIndex--){
            curNum[curIndex]=0;
        }

        int curChangeNum=1000;
        curIndex=0;



        for(int i=0;i<4;i++){
            if(curNum[i]==9){//正向
                states[curIndex++]=n-9*curChangeNum;
            }else{
                states[curIndex++]=n+curChangeNum;
            }
            if(curNum[i]==0){//逆向
                states[curIndex++]=n+9*curChangeNum;
            }else{
                states[curIndex++]=n-curChangeNum;
            }
            curChangeNum=curChangeNum/10;
        }
        return states;
    }

    private boolean isLocked(int []deadNums,int curNum){
        for(int i=0;i<deadNums.length;i++){
            if(curNum==deadNums[i])
                return true;
        }
        return false;
    }
}