package week_9.sapientia1007;

import java.util.*;
public class PGS_입국심사 {
    static class Solution {
        public long solution(int n, int[] times) {
            long answer = 0;

            Arrays.sort(times); // 심사 시간 정렬
            // 최소시간 - left & 최대시간 - right
            long left = 0;
            long right = times[times.length - 1] * (long) n; // 모든 사람이 가장 느리게 심사받는 경우

            while (left <= right) {
                long mid = (left + right) / 2;
                long finish = 0; // mid 시간 내에 처리 가능한 사람 수 계산

                // 각 심사관이 mid 시간 내에 몇명을 처리할 수 있는지 계산
                for (int i = 0; i < times.length; i++) {
                    finish += mid / times[i]; // mid 시간 동안 처리할 수 있는 사람 수 누적
                }
                    // mid 내에 처리할 수 있는 인원이 n보다 적으면 더 많은 시간을 줘야하므로 left 증가
                    if (finish < n) left = mid + 1;
                    else { // mid 내에 처리할 수 있는 인원이 n보다 많거나 같으면 더 적은 시간도 가능할 수 있으므로 right 감소
                        right = mid - 1;
                        answer = mid; // 가장 적은 수가 answer
                    }
                }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(6, new int[] {7,10})); //28
    }
}

/*
정확성  테스트
테스트 1 〉	통과 (0.36ms, 73.8MB)
테스트 2 〉	통과 (0.43ms, 70.1MB)
테스트 3 〉	통과 (1.68ms, 77.1MB)
테스트 4 〉	통과 (85.56ms, 96.8MB)
테스트 5 〉	통과 (79.11ms, 89MB)
테스트 6 〉	통과 (70.31ms, 96.1MB)
테스트 7 〉	통과 (97.04ms, 97.2MB)
테스트 8 〉	통과 (87.84ms, 86MB)
테스트 9 〉	통과 (0.36ms, 75.2MB)
*/