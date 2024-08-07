package week_5.skwent77;

import java.util.*;

public class PGS_최소직사각형 {

    static int min;

    public int solution(int[][] numbers) {
        int len = numbers.length;
        int[] sizeGaro = new int[len];
        int[] sizeSero = new int[len];

        // 명함의 가로와 세로 길이를 비교하여 큰 값과 작은 값을 각각 저장
        for (int i = 0; i < len; i++) {
            sizeGaro[i] = Math.max(numbers[i][0], numbers[i][1]);
            sizeSero[i] = Math.min(numbers[i][0], numbers[i][1]);
        }

        // 최댓값 계산
        int maxGaro = Arrays.stream(sizeGaro).max().getAsInt();
        int maxSero = Arrays.stream(sizeSero).max().getAsInt();

        // 지갑의 크기를 계산하여 반환
        min = maxGaro * maxSero;
        return min;
    }
}

/* 접근법
접근 방식
1. 명함의 가로와 세로를 비교하여 정리:

 -> 각 명함의 가로와 세로 중 큰 값을 가로(sizeGaro), 작은 값을 세로(sizeSero)로 정리합니다. 이렇게 하면 모든 명함이 가로로 수납될 때와 세로로 수납될 때를 고려할 필요가 없습니다. 즉, 각 명함을 회전시켜서라도 가장 긴 면을 가로로, 짧은 면을 세로로 놓도록 정리합니다.
2. 최대값 찾기:
 -> 모든 명함의 가로와 세로 값 중 최대값을 찾습니다. 이는 모든 명함을 수납할 수 있는 최소 크기의 지갑을 결정하는 데 필요합니다.


테스트 1 〉	통과 (0.84ms, 75.6MB)
테스트 2 〉	통과 (1.83ms, 73.1MB)
테스트 3 〉	통과 (2.19ms, 73.5MB)
테스트 4 〉	통과 (0.76ms, 75.3MB)
테스트 5 〉	통과 (1.09ms, 77.3MB)
테스트 6 〉	통과 (0.75ms, 77.8MB)
테스트 7 〉	통과 (0.79ms, 70.2MB)
테스트 8 〉	통과 (1.08ms, 78.5MB)
테스트 9 〉	통과 (0.91ms, 76.8MB)
테스트 10 〉	통과 (0.82ms, 79MB)
테스트 11 〉	통과 (1.37ms, 77.5MB)
테스트 12 〉	통과 (1.62ms, 78.1MB)
테스트 13 〉	통과 (1.53ms, 75.9MB)
테스트 14 〉	통과 (1.46ms, 80.5MB)
테스트 15 〉	통과 (1.81ms, 71.1MB)
테스트 16 〉	통과 (3.46ms, 87.3MB)
테스트 17 〉	통과 (2.43ms, 86.4MB)
테스트 18 〉	통과 (2.55ms, 89.4MB)
테스트 19 〉	통과 (2.89ms, 87MB)
테스트 20 〉	통과 (3.51ms, 88.1MB)
*/