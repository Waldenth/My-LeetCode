class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n=nums.length;
        if(n<3)
            return 0;
        int[] dp=new int[n];
        dp[2]=nums[2]-nums[1]==nums[1]-nums[0]?1:0;
        for(int i=3;i<n;i++){
            if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2])
                dp[i]=dp[i-1]+1;
            else
                dp[i]=0;
        }
        int ans=0;
        for(int i=2;i<n;i++)
            ans+=dp[i];
        return ans;
    }
}