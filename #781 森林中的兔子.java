class Solution {
    public int numRabbits(int[] answers) {
        //K：兔子声称的和自己同色兔子数量，V：声称的数量是K的兔子数量
        Map<Integer,Integer>count=new HashMap<Integer,Integer>();
        for(int cur:answers){
            count.put(cur,count.getOrDefault(cur,0)+1);
        }
        int ans=0;
        for(Map.Entry<Integer,Integer>entry:count.entrySet()){
            int x=entry.getValue();
            int y=entry.getKey();
            ans+=(x+y+1-1)/(y+1)*(y+1);
        }
        return ans;

    }
}
