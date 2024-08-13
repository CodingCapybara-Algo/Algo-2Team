package week_6.lsh981127;
import java.util.*;
public class PGS_단속카메라 {
    public int solution(int[][] routes) {
        // 지문을 잘못 이해했다.
        // 전부 다 연결해야하는 방법으로 이해를 했다.

        // 만약 다음 차 진입 시점을 못찍어?(더 커서)
        // 그러면, 카메라를 다음 차 진입 시점에 한 개 더 추가

        Arrays.sort(routes, (o1, o2) ->
                o1[1] == o2[1] ? o1[0] - o2[0] : o1[1]-o2[1]);

        // 끝나는 시점 기준 오름차순 정렬

        int answer = 1;
        int end = routes[0][1];

        for(int i = 1; i < routes.length; i++) {
            if(end < routes[i][0]) {
                // 지금 끝나는 지점보다 다음 차량의 시작이 더 늦으면
                // 카메라로 찍을 수 없어서 다음 차 시작 부분에 카메라 추가 설치
                answer++;
                end = routes[i][1];
            }
        }
        return answer;
    }
}


/**
 * 테스트 1 〉	통과 (0.50ms, 75.5MB)
 * 테스트 2 〉	통과 (0.60ms, 76.6MB)
 * 테스트 3 〉	통과 (0.81ms, 76.9MB)
 * 테스트 4 〉	통과 (0.53ms, 75.2MB)
 * 테스트 5 〉	통과 (0.69ms, 76.6MB)
 * 효율성  테스트
 * 테스트 1 〉	통과 (2.71ms, 53.4MB)
 * 테스트 2 〉	통과 (2.96ms, 53.1MB)
 * 테스트 3 〉	통과 (8.17ms, 58.3MB)
 * 테스트 4 〉	통과 (0.87ms, 52.4MB)
 * 테스트 5 〉	통과 (8.75ms, 56.1MB)
 */