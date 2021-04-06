class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0)
            return 0;
        int leftPointer=0;
        int rightPointer=leftPointer;
        for(rightPointer=1;rightPointer<nums.length;rightPointer++){
            if(nums[leftPointer]==nums[rightPointer]){
                continue;
            }else{
               leftPointer++;
               nums[leftPointer]=nums[rightPointer]; 
            }
        }
        return leftPointer+1;
    }
}