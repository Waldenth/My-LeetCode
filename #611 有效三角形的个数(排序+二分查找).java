class Solution {
    private int binarySearch(int[]nums,int target,int beginIndex){//寻找比target小的最大元素的序号
        int left=beginIndex,right=nums.length-1;
        //System.out.println("sea "+left+" "+right+" "+target);
        int mid;
        while(left<right){
            mid=(left+right)/2;
            if(nums[mid]>=target){
                right=mid-1;
            }else{
                if(nums[mid+1]>=target)
                    return mid;
                left=mid+1;
            }
            //System.out.println(mid);
        }
        //System.out.println("done");
        if(nums[left]<target)
            return left;
        return beginIndex-1;
    }

    public int triangleNumber(int[] nums) {
        int ans=0;
        if(nums.length<3)
            return ans;
        Arrays.sort(nums);
        int a,b,c;
        for(int i=1;i<=nums.length-2;i++){
            b=nums[i];
            for(int j=0;j<=i-1;j++){
                a=nums[j];
                int cIndex=binarySearch(nums,a+b,i+1);
                ans=ans+(cIndex-i);
                //System.out.println("IN "+cIndex+" "+(nums.length-cIndex));
            }
        }
        return ans;
    }
}