class Solution {
    public int minOperations(int[] target, int[] arr) {
        Map<Integer,Integer>targetDict=new HashMap<Integer,Integer>();
        for(int i=0;i<target.length;i++){
            targetDict.put(target[i],i);
        }
        List<Integer> subSequenceASC=new ArrayList<>();
        for(int val:arr){
            if(targetDict.containsKey(val)){
                int targetIndex=targetDict.get(val);
                int nearBiggerIndex=binarySearch(subSequenceASC,targetIndex);
                if(nearBiggerIndex!=subSequenceASC.size()){
                    subSequenceASC.set(nearBiggerIndex,targetIndex);
                }else{
                    subSequenceASC.add(targetIndex);
                }
            }
        }
        return target.length-subSequenceASC.size();
    }
    private int binarySearch(List<Integer> seqList, int target){//查找array中第一个大于等于target的索引,由于target[]互不相同,只可能大于
        int size=seqList.size();
        if(size==0||seqList.get(size-1)<target){
            return size;
        }
        int low=0;int high=size-1;
        while(low<high){
            int mid=low+(high-low)/2;
            if(seqList.get(mid)<target){
                low=mid+1;
            }else{
                high=mid;
            }
        }
        return low;
    }
}