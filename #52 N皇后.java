class Solution {
    public int totalNQueens(int n) {
        Set<Integer> columns = new HashSet<Integer>();//有皇后的列集合
        Set<Integer> leftDiagonal=new HashSet<Integer>();//有皇后的左对角线
        Set<Integer> rigthDiagonal=new HashSet<Integer>();//有皇后的右对角线
        return Backtrack(n,0,columns,leftDiagonal,rigthDiagonal);
    }
    public int Backtrack(int n,int curRow,Set<Integer>columns,Set<Integer>leftDiagonal,Set<Integer>rigthDiagonal){
        if(curRow==n)//0-n-1行都摆上了皇后,找到了一个解
            return 1;
        int count=0;    //当前0解
        for(int i=0;i<n;i++){
            if(columns.contains(i)) //如果第i列有皇后了
                continue;           //找下一列
            int curLeftDiagonal=curRow-i;  //左对角线的标识符号
            if(leftDiagonal.contains(curLeftDiagonal))
                continue;
            int curRightDiagonal=curRow+i; //右对角线的标识符号
            if(rigthDiagonal.contains(curRightDiagonal))
                continue;
            //满足当前前置条件的一个皇后点
            columns.add(i);
            leftDiagonal.add(curLeftDiagonal);
            rigthDiagonal.add(curRightDiagonal);

            //以此为前置条件找解
            count+=Backtrack(n,curRow+1,columns,leftDiagonal,rigthDiagonal);
            //找完回退
            columns.remove(i);
            leftDiagonal.remove(curLeftDiagonal);
            rigthDiagonal.remove(curRightDiagonal);

        }
        return count;
    }
}