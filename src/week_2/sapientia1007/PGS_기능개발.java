package week_2.sapientia1007;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class PGS_기능개발 {

    static class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            int[] answer = {};

            ArrayList<Integer> answerLst = new ArrayList<>();
            int cnt = 0;

            ArrayDeque<Integer> q = new ArrayDeque<>();
            // 남은 일수 계산 - 속도로 몇일나오는지 계산
            for (int i=0; i<progresses.length; i++) {
                int day = 0;
                if ((100-progresses[i])%speeds[i] == 0) {
                    day = (100-progresses[i])/speeds[i];
                }
                else {
                    day = (100-progresses[i])/speeds[i] + 1;
                }
                q.offer(day);
            }
            System.out.println(q);

            while (!q.isEmpty()) {
                if (q.poll() >= q.peek()) {
                    cnt+=1;
                } else {
                    answerLst.add(cnt);
                    cnt = 0;
                }
            }

            // 앞에 있는 기능보다 뒤에 있는 기능이 먼저 개발되더라도, 뒤에 있는 기능은 아에 있는 기능이 배포될때 함께
            System.out.println(answerLst);
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(new int[] {93, 30, 55}, new int[] {1, 30, 5}))); // [2,1]
        System.out.println(Arrays.toString(s.solution(new int[] {95, 90, 99, 99, 80, 99}, new int[] {1, 1, 1, 1, 1, 1}))); //[1,3,2]
    }

}
