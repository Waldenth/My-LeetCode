class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length<=2)
            return nums.length;
        int leftPointer=2;
        int rightPointer=2;
        for(;rightPointer<nums.length;rightPointer++){
            if(nums[leftPointer-2]!=nums[rightPointer]){
                nums[leftPointer]=nums[rightPointer];
                leftPointer+=1;
            }
        }
        return leftPointer;
    }
}