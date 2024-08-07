package week_5.lsh981127;
import java.util.*;
public class pgs_최소직사각형 {
    public int solution(int[][] sizes) {
        /**
         *  1. 가로, 세로 중 값들을 비교해서 큰 값들을 한쪽으로 몰아둔다. (자연스럽게 다른 한쪽으로는 작은 값들이 몰리겠지)
         *  2. 큰 값들 중 가장 큰 애 * 작은 값들 중 가장 큰 값 => 정답
         *
         *  목표 : 회전시켜서 모든 크기를 용인 + 그 중 최소 크기를 가지기
         *  방법 : 각 지갑별로 가로, 세로 중 큰 값 / 작은 값 으로 구분한 뒤, 각 분야의 큰 값들을 가져오면 모든 것을 포함 가능 + 최솟값이 보장된다.
         *
         */

        int size = sizes.length;
        int[] row = new int[size];      // 큰 값 보관용
        int[] col = new int[size];      // 작은 값 보관용


        for(int i = 0; i < size; i++) {     // 큰 값, 작은 값 구분해서 넣는다
            int[] temp = sizes[i];
            if(temp[0] < temp[1]) {
                row[i] = temp[1];
                col[i] = temp[0];
            } else {
                row[i] = temp[0];
                col[i] = temp[1];
            }
        }


        // 정렬
        Arrays.sort(row);
        Arrays.sort(col);

        // 제일 뒤쪽이 큰 값이므로 값을 곱하면 끝
        int answer = row[size-1]*col[size-1];
        return answer;
    }
}

/**
 * 테스트 1 〉	통과 (0.52ms, 72.9MB)
 * 테스트 2 〉	통과 (0.46ms, 76MB)
 * 테스트 3 〉	통과 (0.38ms, 71MB)
 * 테스트 4 〉	통과 (0.59ms, 77MB)
 * 테스트 5 〉	통과 (0.48ms, 72.8MB)
 * 테스트 6 〉	통과 (0.36ms, 71.5MB)
 * 테스트 7 〉	통과 (0.37ms, 77.4MB)
 * 테스트 8 〉	통과 (0.39ms, 74.5MB)
 * 테스트 9 〉	통과 (0.51ms, 74MB)
 * 테스트 10 〉	통과 (0.56ms, 74.5MB)
 * 테스트 11 〉	통과 (0.47ms, 75.8MB)
 * 테스트 12 〉	통과 (0.82ms, 77.8MB)
 * 테스트 13 〉	통과 (1.37ms, 86.2MB)
 * 테스트 14 〉	통과 (1.99ms, 77.1MB)
 * 테스트 15 〉	통과 (3.96ms, 80.5MB)
 * 테스트 16 〉	통과 (4.28ms, 84MB)
 * 테스트 17 〉	통과 (7.00ms, 85.2MB)
 * 테스트 18 〉	통과 (7.82ms, 84.8MB)
 * 테스트 19 〉	통과 (1.66ms, 85.5MB)
 * 테스트 20 〉	통과 (6.30ms, 77.4MB)
 */