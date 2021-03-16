class Solution {
    public int[][] generateMatrix(int n) {
        int [][]result=new int [n][n];
        int left=0,right=n-1,top=0,bottom=n-1;
        int elementNum=n*n;
        int cur=1;
        while(elementNum>=1){
            for(int i=left;i<=right&&elementNum>=1;i++){
                result[top][i]=cur;
                cur++;
                elementNum--;
            }
            top++;
            for(int i=top;i<=bottom&&elementNum>=1;i++){
                result[i][right]=cur;
                cur++;
                elementNum--;
            }
            right--;
            for(int i=right;i>=left&&elementNum>=1;i--){
                result[bottom][i]=cur;
                cur++;
                elementNum--;
            }
            bottom--;
            for(int i=bottom;i>=top&&elementNum>=1;i--){
                result[i][left]=cur;
                cur++;
                elementNum--;
            }
            left++;
        }
        return result;
    }
}