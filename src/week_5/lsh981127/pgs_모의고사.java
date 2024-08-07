package week_5.lsh981127;

import java.util.Arrays;

public class pgs_모의고사 {
    public int[] solution(int[] answers) {
        int c1 = 0, c2 = 0, c3 = 0;         // 각 수포자들이 맞춘 값 변수
        int[] a1 = {1,2,3,4,5}, a2 = {2,1,2,3,2,4,2,5}, a3 = {3,3,1,1,2,2,4,4,5,5};
        int s1 = a1.length, s2 = a2.length, s3 = a3.length;

        for(int i = 0; i < answers.length; i++) {
            // 주어진 답들에 대해 나머지 연산을 활용해 수포자와 답을 비교하고 일치하면 카운트해준다.
            if(a1[i % s1] == answers[i]) c1++;
            if(a2[i % s2] == answers[i]) c2++;
            if(a3[i % s3] == answers[i]) c3++;
        }

        /**
         * 사실, 완전 탐색하는 것 보다, 최댓값 비교 및 답을 어떻게 return할지가 더 어려웠던 문제...
         * 단순하고 비효율적인 방법으로 답을 return한 거라 다른 사람들은 어떻게 했는지 궁금
         */

        int count = 0;
        int[] result = {c1,c2,c3};          // index 혼동 방지용

        int[] temp = {c1,c2,c3};            // 최댓값 찾기용
        Arrays.sort(temp);
        int max = temp[2];                  // 최댓값 찾고

        for(int i =0; i<3;i++) {
            // 최댓값과 일치하는 애들의 갯수를 찾고
            if(result[i] == max) {
                count++;
            }
        }

        int[] answer = new int[count];
        int j = 0;

        for(int i =0; i<3;i++) {
            if(result[i] == max) {
                // result의 index에 맞춰서 일치하는 경우 index를 answer에 넣어주기
                answer[j] = i+1;
                j++;
            }
        }
        return answer;
    }
}

/**
 * 테스트 1 〉	통과 (0.33ms, 77.4MB)
 * 테스트 2 〉	통과 (0.32ms, 72.3MB)
 * 테스트 3 〉	통과 (0.32ms, 71MB)
 * 테스트 4 〉	통과 (0.39ms, 73.2MB)
 * 테스트 5 〉	통과 (0.49ms, 73.9MB)
 * 테스트 6 〉	통과 (0.35ms, 73MB)
 * 테스트 7 〉	통과 (1.02ms, 79.3MB)
 * 테스트 8 〉	통과 (0.42ms, 73MB)
 * 테스트 9 〉	통과 (1.37ms, 76.7MB)
 * 테스트 10 〉	통과 (0.58ms, 77.6MB)
 * 테스트 11 〉	통과 (1.36ms, 79.7MB)
 * 테스트 12 〉	통과 (1.28ms, 77.9MB)
 * 테스트 13 〉	통과 (0.49ms, 80.8MB)
 * 테스트 14 〉	통과 (0.93ms, 75.1MB)
 */