class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums.length==0)
            return null;
        Arrays.sort(nums);
        ArrayList<Integer> numsList=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            numsList.add(nums[i]);
        }
        
        Set resSet=new HashSet<List<Integer>>();
        resSet.add(new ArrayList<Integer>());
        recursion(numsList,resSet);
        
        List<List<Integer>> res=new ArrayList<List<Integer>>();

        //System.out.println(resSet.size());

        Iterator<List<Integer>>iterator=resSet.iterator();
        while(iterator.hasNext()){
            res.add(iterator.next());
        }
        return res;
    }
    private void recursion(List<Integer> numsList,Set resSet){
        if(numsList.size()<2){
            //System.out.println("---tmpList:"+numsList.size());
            resSet.add(numsList);
            return;
        }
        
        for(int i=0;i<numsList.size();i++){
            List<Integer>tmpList=new ArrayList<>();
            tmpList.addAll(numsList);
            //System.out.println("tmpList:"+tmpList.size());
            tmpList.remove(i);
            recursion(tmpList,resSet);
            resSet.add(tmpList);
            //System.out.println("done tmpList:"+tmpList.size());
        }
        resSet.add(numsList);
        return;    
    }
   
}