class Solution {
    public boolean circularArrayLoop(int[] nums) {
        Deque<int[]> queue = new ArrayDeque<>();
        int n = nums.length;

        boolean[] isLength1 = new boolean[n];

        for (int i = 0; i < n; i++) {
            queue.addLast(new int[] { i, i, 0, nums[i] });
        }
        while (queue.size() != 0) {
            int[] curState = queue.poll();
            if ((curState[3] ^ nums[curState[1]]) < 0) {
                continue;
            }
            curState[1] = (n + (curState[1] + nums[curState[1]]) % n) % n;
            if (isLength1[curState[1]])
                continue;
            curState[2]++;
            if (curState[1] == curState[0]) {
                if (curState[2] > 1)
                    return true;
                isLength1[curState[0]] = true;
                continue;
            }
            // for(int i=0;i<4;i++){
            // System.out.print(curState[i]+" ");
            // }
            // System.out.println("");
            queue.addLast(curState);
        }
        return false;
    }
}