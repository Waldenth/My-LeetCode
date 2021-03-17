class Solution {
    public int numDistinct(String s, String t) {
        int sLength=s.length();
        int tLength=t.length();
        if(sLength<tLength)
            return 0;
        int [][]dp=new int[sLength+1][tLength+1];
        for(int i=0;i<=sLength;i++){
            dp[i][tLength]=1;
        }
        //更明显
        for(int j=0;j<tLength;j++){
            dp[sLength][j]=0;
        }

        for(int i=sLength-1;i>=0;i--){
            char sChar=s.charAt(i);
            for(int j=tLength-1;j>=0;j--){
                char tChar=t.charAt(j);
                if(sChar==tChar){
                    dp[i][j]=dp[i+1][j+1]+dp[i+1][j];
                }else{
                    dp[i][j]=dp[i+1][j];
                }
            }
        }
        return dp[0][0];
    }
}