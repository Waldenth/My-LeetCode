import java.util.HashMap;

class Solution {
    public int halfQuestions(int[] questions) {
        int N = questions.length / 2;
        HashMap<Integer, Integer> questionMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < questions.length; i++) {
            Integer v = questionMap.get(questions[i]);
            if (v == null)
                questionMap.put(questions[i], 1);
            else
                questionMap.put(questions[i], v + 1);
        }
        Set<Map.Entry<Integer, Integer>> questionSet = questionMap.entrySet();
        List<Map.Entry<Integer, Integer>> questionSetSorted = new ArrayList<Map.Entry<Integer, Integer>>(
                questionMap.entrySet());
        Collections.sort(questionSetSorted, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> q1, Map.Entry<Integer, Integer> q2) {
                // java sort从"小"到"大"排序,"大"的放到后面,我们需要从大到小排序
                if (q2.getValue() > q1.getValue()) {
                    return 1;// 让java认为q1大于q2,把q1放到后面
                } else if (q1.getValue() > q2.getValue()) {
                    return -1;
                }
                return 0;
            }
        });

        int typeNum = 0;
        for (int i = 0; i < questionSetSorted.size(); i++) {
            int value = questionSetSorted.get(i).getValue();
            N = N - value;
            typeNum++;
            if (N <= 0)
                return typeNum;
        }

        return typeNum;
    }
}