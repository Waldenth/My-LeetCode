class Solution {
    public int clumsy(int N) {
        if(N==1)
            return 1;
        else if(N==2)
            return 2;
        else if(N==3)
            return 6;
        else if(N==4)
            return 7;
        else if((N-3)%4==0){
            return (N+1)-2;
        }
        else if((N-3)%4==1){
            return (N+1)-1+1;
        }
        else if((N-3)%4==2){
            return (N+1)+2-1;
        }else{//(N-3)%4==3
            return (N+1) +3-2*1;
        }
    }
}