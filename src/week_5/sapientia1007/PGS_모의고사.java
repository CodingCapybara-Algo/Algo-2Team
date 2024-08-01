package week_5.sapientia1007;

import java.util.ArrayList;
import java.util.Arrays;

/*
* answer : 정답 배열
* return : 가장 많은 문제를 맞힌 사람 배열
*
*
* 1번 수포자 : 1,2,3,4,5, ..
* 2번 수포자 : 2,1,2,3,2,4,2,5, ..
* 3번 수포자 : 3,3,1,1,2,2,4,4,5,5, ..
* */
public class PGS_모의고사 {
    static class Solution {
        public int[] solution(int[] answers) {
            int[] answer = {};
            int[] st1 = {1, 2, 3, 4, 5}; // 5개씩 반복
            int[] st2 = {2, 1, 2, 3, 2, 4, 2, 5}; // 8개씩 반복
            int[] st3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 10개씩 반복

            int[] resArr = new int[3];

            // 1번 수포자
            int cnt1 = 0;
            for (int i = 0; i < answers.length; i++) {
                if (answers[i] == st1[i % st1.length]) {
                    cnt1++;
                }
            }
            resArr[0] = cnt1;

            // 2번 수포자
            int cnt2 = 0;
            for (int i = 0; i < answers.length; i++) {
                if (answers[i] == st2[i % st2.length]) {
                    cnt2++;
                }
            }
            resArr[1] = cnt2;

            // 3번 수포자
            int cnt3 = 0;
            for (int i = 0; i < answers.length; i++) {
                if (answers[i] == st3[i % st3.length]) {
                    cnt3++;
                }
            }
            resArr[2] = cnt3;

            // 가장 많은 정답을 맞힌 수포자를 찾기
            int maxVal = Arrays.stream(resArr).max().getAsInt();
            ArrayList<Integer> answerLst = new ArrayList<>();

            for (int i = 0; i < resArr.length; i++) {
                if (resArr[i] == maxVal) {
                    answerLst.add(i + 1);
                }
            }

            // 배열로 변환
            answer = new int[answerLst.size()];
            for (int i = 0; i < answerLst.size(); i++) {
                answer[i] = answerLst.get(i);
            }
            return answer;
        }
    }


    public static void main(String[] args) throws Exception {
        Solution s = new Solution();
        System.out.println(s.solution(new int[] {1,2,3,4,5})); // [1]
        System.out.println(s.solution(new int[] {1,3,2,4,2})); // [1.2.3]
    }
}

/*
정확성 테스트
테스트 1 〉	통과 (1.14ms, 72.3MB)
테스트 2 〉	통과 (3.82ms, 75.5MB)
테스트 3 〉	통과 (0.96ms, 66.2MB)
테스트 4 〉	통과 (1.11ms, 79MB)
테스트 5 〉	통과 (0.66ms, 71.1MB)
테스트 6 〉	통과 (1.10ms, 79.1MB)
테스트 7 〉	통과 (1.52ms, 66.4MB)
테스트 8 〉	통과 (0.80ms, 74.7MB)
테스트 9 〉	통과 (1.89ms, 79.6MB)
테스트 10 〉	통과 (1.19ms, 79.5MB)
테스트 11 〉	통과 (1.42ms, 76.3MB)
테스트 12 〉	통과 (1.80ms, 74.5MB)
테스트 13 〉	통과 (1.16ms, 74.4MB)
테스트 14 〉	통과 (1.53ms, 79.8MB)
*/