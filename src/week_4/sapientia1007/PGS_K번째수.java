package week_4.sapientia1007;

import java.util.*;

public class PGS_K번째수 {
    /*
    array
    command => command.length동안 수행
    command [i,j,k] => i번째부터 j까지 잘라서 정렬 후 k번째 숫자 리턴하여 결과 배열 추가
     */
    static class Solution {
        public int[] solution(int[] array, int[][] commands) {
            int[] answer = {};
            answer = new int[commands.length];


            for (int q=0; q<commands.length; q++){
                int[] singleCmd = commands[q];
                int i = singleCmd[0]; int j = singleCmd[1]; int k = singleCmd[2];

                // 인덱스로 copy slice
                int[] resList = Arrays.copyOfRange(array, i-1, j);
                Arrays.sort(resList);
                answer[q] = resList[k-1];
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[] {1,5,2,6,3,7,4}, new int[][] {{2,5,3}, {4,4,1}, {1,7,3} }));
    }
}

/*
정확성 테스트
테스트 1 〉	통과 (0.46ms, 75.5MB)
테스트 2 〉	통과 (0.33ms, 71.7MB)
테스트 3 〉	통과 (0.38ms, 77.7MB)
테스트 4 〉	통과 (0.30ms, 75.7MB)
테스트 5 〉	통과 (0.56ms, 77MB)
테스트 6 〉	통과 (0.54ms, 74.6MB)
테스트 7 〉	통과 (0.33ms, 75.6MB)
 */