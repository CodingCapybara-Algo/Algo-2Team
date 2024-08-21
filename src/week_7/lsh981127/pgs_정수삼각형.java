package week_7.lsh981127;

import java.util.*;
public class pgs_정수삼각형 {
    // 근데 이 방법이 되네;;
    // dp 다운업 방식
    // 그냥 반복문 돌면서 왼쪽 위, 오른쪽 위 중 더 큰 값과 더하는 방식
    // 제일 마지막번째 배열에서 가장 큰 값을 구하면 되는 거야

    public int solution(int[][] triangle) {
        for(int i = 1; i < triangle.length; i++) {
            int[] temp = triangle[i];
            int len = temp.length;
            for(int j = 0; j < len; j++) {
                // index 본인과, 본인 index - 1 애들의 합
                int left = 0, right = 0;
                if(j-1 >= 0) left = triangle[i-1][j-1];     // 왼쪽 위 구할 수 있는 경우

                if(j < len - 1) right = triangle[i-1][j];   // 오른쪽 위 구할 수 있는 경우

                // 더 큰 것과 더해서 저장
                triangle[i][j] += Math.max(left, right);    // 왼쪽 위, 오른쪽 위 비교해서 더 큰 값과 합쳐서 기록
            }
        }

        // 제일 마지막째 줄의 최댓값만 구하면 돼.

        int answer = 0;
        for(int i: triangle[triangle.length-1]) {
            if(i > answer) answer = i;
        }

        return answer;
    }
}

/**
 * 정확성  테스트
 * 테스트 1 〉	통과 (0.04ms, 79.9MB)
 * 테스트 2 〉	통과 (0.04ms, 74.6MB)
 * 테스트 3 〉	통과 (0.06ms, 72.9MB)
 * 테스트 4 〉	통과 (0.10ms, 76.4MB)
 * 테스트 5 〉	통과 (0.38ms, 80.9MB)
 * 테스트 6 〉	통과 (0.13ms, 75.9MB)
 * 테스트 7 〉	통과 (0.27ms, 75.7MB)
 * 테스트 8 〉	통과 (0.13ms, 82.5MB)
 * 테스트 9 〉	통과 (0.04ms, 73.3MB)
 * 테스트 10 〉	통과 (0.07ms, 78.5MB)
 * 효율성  테스트
 * 테스트 1 〉	통과 (7.22ms, 60.9MB)
 * 테스트 2 〉	통과 (6.36ms, 58.7MB)
 * 테스트 3 〉	통과 (15.38ms, 64.1MB)
 * 테스트 4 〉	통과 (8.54ms, 60.4MB)
 * 테스트 5 〉	통과 (7.14ms, 60.9MB)
 * 테스트 6 〉	통과 (6.76ms, 58.5MB)
 * 테스트 7 〉	통과 (7.94ms, 60.4MB)
 * 테스트 8 〉	통과 (7.43ms, 59.8MB)
 * 테스트 9 〉	통과 (8.68ms, 56.9MB)
 * 테스트 10 〉	통과 (10.56ms, 62.3MB)
 */