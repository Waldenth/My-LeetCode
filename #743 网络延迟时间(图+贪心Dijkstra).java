class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        final int INF = Integer.MAX_VALUE / 2;// INF+INF不可溢出
        int[][] edgeLength = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(edgeLength[i], INF);
        }
        for (int[] tmp : times) {
            int beginPoint = tmp[0] - 1, endPoint = tmp[1] - 1;
            edgeLength[beginPoint][endPoint] = tmp[2];
        }
        int[] distance = new int[n];
        Arrays.fill(distance, INF);
        distance[k - 1] = 0;
        boolean[] checked = new boolean[n];
        for (int i = 0; i < n; i++) {
            int nextStepPoint = -1;
            for (int curPoint = 0; curPoint < n; curPoint++) {
                if (!checked[curPoint] && (nextStepPoint == -1 || distance[curPoint] < distance[nextStepPoint])) {
                    nextStepPoint = curPoint;
                }
            }
            checked[nextStepPoint] = true;
            for (int curPoint = 0; curPoint < n; curPoint++) {
                distance[curPoint] = Math.min(distance[curPoint],
                        distance[nextStepPoint] + edgeLength[nextStepPoint][curPoint]);
            }
        }
        int ans = Arrays.stream(distance).max().getAsInt();
        if (ans >= INF)
            return -1;
        return ans;
    }
}