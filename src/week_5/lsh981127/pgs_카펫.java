package week_5.lsh981127;

import java.util.*;
public class pgs_카펫 {
    public int[] solution(int brown, int yellow) {
        /**
         * 지문에서 테두리 1줄이라고 했으니 다른 경우 생각할 필요없이 둘레만 고려하면 되는 문제
         * 노란색 영역의 세로 : x, 가로 : y
         * 그러면, 갈색 격자의 갯수 : 2 * (x + (y + 2))
         * return 해야하는 값은 {y + 2, x + 2}
         *
         * 방법
         * 1. 노란색 격자 수로 나올 수 있는 (가로, 세로) 조합 전부 찾고
         * 2. 해당 가로, 세로 값으로 연산했을 때, 갈색과 일치하는 경우가 정답!
         */

        Set<int[]> set = new HashSet<>();      // HashSet을 통해 가로, 세로 조합 기록

        for(int i = 1; i <= yellow; i++) {     // 1부터 yellow 값까지 증가시키면서 나눠지는 경우 기록
            if(i > yellow / i) break;          // 절반 넘어가면 중복 발생하므로 반복문 중단
            if(yellow % i == 0) {
                set.add(new int[]{i, yellow / i});
            }
        }

        int result_x = 0, result_y = 0;        // 결과용 변수
        for(int[] i : set) {
            int x = i[0], y = i[1];
            if((y+2+x) * 2 == brown) {         // 공식을 통해 갈색 격자 갯수와 일치하는지 검사
                result_x = x;
                result_y = y;
                break;
            }

        }
        int[] answer = {result_y+2, result_x + 2};

        return answer;
    }
}

/**
 * 테스트 1 〉	통과 (0.04ms, 77.7MB)
 * 테스트 2 〉	통과 (0.04ms, 73.1MB)
 * 테스트 3 〉	통과 (0.06ms, 75.6MB)
 * 테스트 4 〉	통과 (0.04ms, 78.3MB)
 * 테스트 5 〉	통과 (0.04ms, 70.8MB)
 * 테스트 6 〉	통과 (0.06ms, 77.2MB)
 * 테스트 7 〉	통과 (0.08ms, 77.3MB)
 * 테스트 8 〉	통과 (0.12ms, 75MB)
 * 테스트 9 〉	통과 (0.07ms, 75.3MB)
 * 테스트 10 〉	통과 (0.09ms, 77MB)
 * 테스트 11 〉	통과 (0.04ms, 75.1MB)
 * 테스트 12 〉	통과 (0.03ms, 77.8MB)
 * 테스트 13 〉	통과 (0.04ms, 78.7MB)
 */
