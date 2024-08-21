package week_7.lsh981127;

import java.util.*;
public class pgs_등굣길 {



    public int solution(int m, int n, int[][] puddles) {
        int[][] graph = new int[n+1][m+1];
        int max = 1000000007;

        for(int[] i : puddles) {
            // 와씨... i[1] 과 i[0]을 안바꿔줘서 계속 실패

            graph[i[1]][i[0]] = -1;
        }

        graph[1][1] = 1;
        // index 처리가 까다로워서 참고한 방법
        // 그냥 n+1, m+1로 주고 하면 편하다
        // 나중에 index가 0인 경우에 대해 조건문을 넣어줄 필요가 없기 떄문
        // i-1 > 0 일때만 진행하는 등 (어차피 0을 값으로 가지고 있기 때문에 상관없다.)

        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < m+1; j++) {
                if(graph[i][j] == -1) continue;
                int left = 0, top = 0;
                if(graph[i][j-1] > 0)       // 왼쪽 위 값이 존재하면(웅덩이 : -1, 영역 밖 : 0)
                    left = graph[i][j-1] % max;
                if(graph[i-1][j] > 0)       // 왼쪽 위 값이 존재하면(웅덩이 : -1, 영역 밖 : 0)
                    top = graph[i-1][j] % max;
                graph[i][j] = (graph[i][j] + left + top) % max;

            }
        }

        // for(int[] temp : graph) System.out.println(Arrays.toString(temp));


        return graph[n][m];
    }
}

/**
 * 정확성  테스트
 * 테스트 1 〉	통과 (0.04ms, 80.3MB)
 * 테스트 2 〉	통과 (0.03ms, 77.4MB)
 * 테스트 3 〉	통과 (0.03ms, 65.3MB)
 * 테스트 4 〉	통과 (0.03ms, 68.7MB)
 * 테스트 5 〉	통과 (0.04ms, 71.6MB)
 * 테스트 6 〉	통과 (0.03ms, 78.7MB)
 * 테스트 7 〉	통과 (0.03ms, 81.7MB)
 * 테스트 8 〉	통과 (0.04ms, 73.7MB)
 * 테스트 9 〉	통과 (0.06ms, 79.6MB)
 * 테스트 10 〉	통과 (0.03ms, 77.2MB)
 * 효율성  테스트
 * 테스트 1 〉	통과 (1.00ms, 51.7MB)
 * 테스트 2 〉	통과 (0.39ms, 52.4MB)
 * 테스트 3 〉	통과 (0.54ms, 52.5MB)
 * 테스트 4 〉	통과 (0.71ms, 52.2MB)
 * 테스트 5 〉	통과 (0.61ms, 53.2MB)
 * 테스트 6 〉	통과 (0.98ms, 51.8MB)
 * 테스트 7 〉	통과 (0.51ms, 52.2MB)
 * 테스트 8 〉	통과 (0.56ms, 52.4MB)
 * 테스트 9 〉	통과 (0.80ms, 52.2MB)
 * 테스트 10 〉	통과 (0.77ms, 52MB)
 */
