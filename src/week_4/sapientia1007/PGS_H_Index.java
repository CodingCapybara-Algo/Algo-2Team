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

/*
정확성 테스트
테스트 1 〉	통과 (1.14ms, 73.7MB)
테스트 2 〉	통과 (0.83ms, 74.9MB)
테스트 3 〉	통과 (0.76ms, 73.2MB)
테스트 4 〉	통과 (0.70ms, 74.8MB)
테스트 5 〉	통과 (0.89ms, 81.2MB)
테스트 6 〉	통과 (0.73ms, 77.2MB)
테스트 7 〉	통과 (0.67ms, 72.7MB)
테스트 8 〉	통과 (0.53ms, 74.8MB)
테스트 9 〉	통과 (0.52ms, 74.6MB)
테스트 10 〉	통과 (0.68ms, 75MB)
테스트 11 〉	통과 (0.91ms, 77.8MB)
테스트 12 〉	통과 (0.55ms, 73.4MB)
테스트 13 〉	통과 (0.85ms, 75MB)
테스트 14 〉	통과 (0.96ms, 75MB)
테스트 15 〉	통과 (5.45ms, 72.3MB)
테스트 16 〉	통과 (0.38ms, 78.7MB)
 */