class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        LinkedList<Integer>result=new LinkedList<>();
        if(matrix.length==0||matrix[0].length==0||matrix==null)
            return result;
        int left=0,right=matrix[0].length-1;
        int top=0,bottom=matrix.length-1;

        int matrixElementNum=matrix.length*matrix[0].length;

        while(matrixElementNum>=1){
            for(int i=left;i<=right&&matrixElementNum>=1;i++){
                result.addLast(matrix[top][i]);
                matrixElementNum--;
            }
            top++;
            for(int i=top;i<=bottom&&matrixElementNum>=1;i++){
                result.addLast(matrix[i][right]);
                matrixElementNum--;
            }
            right--;
            for(int i=right;i>=left&&matrixElementNum>=1;i--){
                result.addLast(matrix[bottom][i]);
                matrixElementNum--;
            }    
            bottom--;
            for(int i=bottom;i>=top&&matrixElementNum>=1;i--){
                result.addLast(matrix[i][left]);
                matrixElementNum--;
            }
            left++;
        }
        return result;
    }
}
