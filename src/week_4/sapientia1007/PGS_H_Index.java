package week_4.sapientia1007;

/*
논문 n편중 h번 이상 인용된 논문이 h편 이상
나머지 논문이 h번 이하 인용
=> h의 최대값 = H-Index

citations.length = 논문의 수 = n
citations 배열 중 인용된 최대 논문 수?
 */

import java.util.*;
public class PGS_H_Index {

    static class Solution {
        public int solution(int[] citations) {
            int answer = 0;

            // 배열 정렬
            Arrays.sort(citations);

            int n = citations.length;

            // 각 논문에 대해 h 계산
            for (int i=0; i<n; i++) {
                int h = n-i; // 현재 논문에서의 h 후보

                if (citations[i] >= h) { // 현재 인용 횟수가 h 이상인지 확인 -> 맞다면 h-index 업데이트
                    answer = h;
                    break;
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[] {3,0,6,1,5})); // 3
    }
}
