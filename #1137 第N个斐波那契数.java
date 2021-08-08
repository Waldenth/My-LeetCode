class Solution {
    public int tribonacci(int n) {
        int[] t=new int[]{0,1,1};
        if(n<3)
            return t[n];
        int ans=0;
        int t3=0;
        for(int i=3;i<=n;i++){
            t3=t[0]+t[1]+t[2];
            t[0]=t[1];
            t[1]=t[2];
            t[2]=t3;
        }
        return t3;
    }
}