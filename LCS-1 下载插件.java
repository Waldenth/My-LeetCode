import java.util.Deque;

class Solution {

    class State {
        int curBandwidth;
        int curDownload;
        int curTime;

        public State(int bandwidth, int download, int time) {
            this.curBandwidth = bandwidth;
            this.curDownload = download;
            this.curTime = time;
        }
    }

    public int leastMinutes(int n) {
        int bandwidth = 1;
        int curDownload = 0;
        Deque<State> queue = new ArrayDeque<State>();
        queue.addLast(new State(1, 1, 1));
        queue.addLast(new State(2, 0, 1));
        while (queue.size() > 0) {
            State curState = queue.pollFirst();
            if (curState.curDownload >= n) {
                return curState.curTime;
            }
            queue.addLast(new State(curState.curBandwidth, curState.curDownload + curState.curBandwidth,
                    curState.curTime + 1));
            queue.addLast(new State(curState.curBandwidth * 2, curState.curDownload, curState.curTime + 1));
        }
        return -1;
    }
}