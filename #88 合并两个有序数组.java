class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int arrayTail=m+n-1;
        int p1=m-1,p2=n-1;
        int curElement;
        while(p1>=0||p2>=0){
            if(p1==-1){
                curElement=nums2[p2--];
            }else if(p2==-1){
                curElement=nums1[p1--];
            }else{
                if(nums1[p1]>=nums2[p2]){
                    curElement=nums1[p1--];
                }else{
                    curElement=nums2[p2--];
                }
            }
            nums1[arrayTail--]=curElement;
        }
    }
}
