package week_8.lsh981127;

import java.util.*;

public class pgs_여행경로 {

    static boolean[] visited;
    static List<String> path;
    public static void main(String[] args) {
        String[][] ate = new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        System.out.println("solution(ate) = " + Arrays.toString(solution(ate)));
    }
    public static String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        path = new ArrayList<>();
        int count = 0;

        // 우리 조합 코드와 동일한 방식

        dfs(count, "ICN", "ICN", tickets);
        Collections.sort(path);
        String[] answer = path.get(0).split(" ");

        return answer;
    }

    static void dfs(int count, String current, String way, String [][] tickets) {
        if(count == tickets.length) {
            path.add(way);
            return;
        }

        for(int i = 0; i < tickets.length; i++) {
            if(!visited[i] && current.equals(tickets[i][0])) {
                visited[i] = true;
                dfs(count + 1, tickets[i][1],  way + " " + tickets[i][1], tickets);
                visited[i] = false;

            }

        }

    }
}

/**
 * 채점을 시작합니다.
 * 정확성  테스트
 * 테스트 1 〉	통과 (135.68ms, 100MB)
 * 테스트 2 〉	통과 (13.20ms, 74.7MB)
 * 테스트 3 〉	통과 (11.98ms, 78.9MB)
 * 테스트 4 〉	통과 (17.06ms, 89.8MB)
 */