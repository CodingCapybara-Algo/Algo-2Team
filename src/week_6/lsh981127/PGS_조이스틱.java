package week_6.lsh981127;
import java.util.*;
public class PGS_조이스틱 {
    // 참조 링크 : https://velog.io/@ji-jjang/Programmers-%EC%A1%B0%EC%9D%B4%EC%8A%A4%ED%8B%B1-C-Java

    /**
     *
     * 핵심은, 좌우 이동을 어떻게 판단할 것인가였다!
     * 0의 존재 유무와 0이 있는 경우를 비교해서 이동하면 되겠지 막연히 생각하다가 구현 실패..
     *
     *  과정
     * 1. 각 자리별로 위, 아래 회전 수 작은 걸로 선택
     * 2. A가 존재한다면, Min(-> 방향 이동 횟수, <- 이동 횟수)로 카운트
     *  - 이때, while문으로 A까지의 거리 탐색
     *  - 이후, ㅜㄷㅌㅅ 값
     */
    public int solution(String name) {
        int ans = 0;
        int n = name.length();
        int move = n - 1;
        for (int i = 0; i < n; ++i) {
            ans += Math.min(name.charAt(i)- 'A', 'Z' - name.charAt(i) + 1);
            // 위, 아래 비교 코드

            int next = i + 1;
            while (next < n && name.charAt(next) == 'A')
                // 다음 A가 있는 곳의 index(우로 -> 이동)
                ++next;
            move = Math.min(move, Math.min(i, n - next) + i + n - next);

            // A가 연속으로 있는 구간을 건너뛰기 위한 최소 이동 거리
            // i : 현재 인덱스
            // next : 가장 먼저 나타나는 A의 인덱스
            // n - next : i 에서 next까지의 거리
            // Math.min(i, n - next) : i에서 왼쪽으로 이동 vs 문자열 끝에서 next까지 이동하는 것중 작은 거
            // Math.min(move, Math.min(i, n - next) + i + n - next)
            //    왼쪽으로 이동하거나, 오른쪽이로 이동하는 경우를 모두 고려해 전체 이동 거리 계산


        }
        ans += move;
        return ans;


    }
}

/**
 * 테스트 1 〉	통과 (0.03ms, 73.7MB)
 * 테스트 2 〉	통과 (0.03ms, 72.6MB)
 * 테스트 3 〉	통과 (0.08ms, 76.8MB)
 * 테스트 4 〉	통과 (0.04ms, 70.8MB)
 * 테스트 5 〉	통과 (0.05ms, 70.4MB)
 * 테스트 6 〉	통과 (0.06ms, 76.1MB)
 * 테스트 7 〉	통과 (0.06ms, 71.2MB)
 * 테스트 8 〉	통과 (0.04ms, 74.3MB)
 * 테스트 9 〉	통과 (0.04ms, 72.9MB)
 * 테스트 10 〉	통과 (0.05ms, 79.9MB)
 * 테스트 11 〉	통과 (0.05ms, 73.7MB)
 * 테스트 12 〉	통과 (0.04ms, 74.8MB)
 * 테스트 13 〉	통과 (0.05ms, 74.6MB)
 * 테스트 14 〉	통과 (0.05ms, 74.4MB)
 * 테스트 15 〉	통과 (0.04ms, 66.5MB)
 * 테스트 16 〉	통과 (0.04ms, 84MB)
 * 테스트 17 〉	통과 (0.04ms, 72.2MB)
 * 테스트 18 〉	통과 (0.05ms, 75MB)
 * 테스트 19 〉	통과 (0.05ms, 80.5MB)
 * 테스트 20 〉	통과 (0.05ms, 68.1MB)
 * 테스트 21 〉	통과 (0.04ms, 74.3MB)
 * 테스트 22 〉	통과 (0.05ms, 78.4MB)
 * 테스트 23 〉	통과 (0.04ms, 77.4MB)
 * 테스트 24 〉	통과 (0.06ms, 76.2MB)
 * 테스트 25 〉	통과 (0.05ms, 75.7MB)
 * 테스트 26 〉	통과 (0.09ms, 73.6MB)
 * 테스트 27 〉	통과 (0.04ms, 80.7MB)
 */
