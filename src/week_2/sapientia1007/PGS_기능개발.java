package week_2.sapientia1007;

import java.util.*;

public class PGS_기능개발 {

    static class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            int[] answer = {};
            // 결과를 담을 arrayList
            ArrayList<Integer> answerLst = new ArrayList<>();
            ArrayDeque<Integer> q = new ArrayDeque<>();

            // 남은 일수 계산 - 속도로 몇일나오는지 계산 (큐)
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

            int cnt = 1;
            int num = q.pollFirst(); // 일단 첫번째 값 기준 정하기 위해 q에서 poll -> 첫번째 남은 일 수

            // 비교
            while (true) {
                if (q.isEmpty()) break;
                if (num>=q.peekFirst()) { // 현재 작업의 남은 일수가 이전 작업의 남은 일수보다 작거나 같으면 같이 배포
                    q.pollFirst();
                    cnt +=1 ;
                } else if (q.peekFirst()>num){ // 현재 작업의 남은 일수가 이전 작업의 남은 일수보다 크면 배포 처리 => 새로운 기준 + cnt초기화
                    answerLst.add(cnt);
                    num = q.pollFirst();
                    cnt=1;
                }
            }
            answerLst.add(cnt); // 마지막으로 남은 작업 수

            // arrayList를 배열로 변환
            answer = new int[answerLst.size()];
            for (int i=0; i<answerLst.size(); i++) {
                answer[i] = answerLst.get(i);
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(new int[] {93, 30, 55}, new int[] {1, 30, 5}))); // [2,1]
        System.out.println(Arrays.toString(s.solution(new int[] {95, 90, 99, 99, 80, 99}, new int[] {1, 1, 1, 1, 1, 1}))); //[1,3,2]
    }

}
