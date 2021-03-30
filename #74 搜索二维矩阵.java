class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0)
            return false;
        for(int i=0;i<matrix.length;i++){
            int index=Arrays.binarySearch(matrix[i],target);
            if(index<matrix[0].length&&index>=0){
                return true;
            }
        }
        return false;
    }
}