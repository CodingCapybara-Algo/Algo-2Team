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
