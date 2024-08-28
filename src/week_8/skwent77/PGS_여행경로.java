package week_8.skwent77;
//참고링크: https://skorea6.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%97%AC%ED%96%89-%EA%B2%BD%EB%A1%9C-%EB%AC%B8%EC%A0%9C-Java-DFS-%ED%92%80%EC%9D%B4
// : 문자열 탐색에 어려움이 있다기보다는 백트랙킹 문제 구현의 어려움 때문
import java.util.List;
import java.util.ArrayList;

public class PGS_여행경로 {

    List<String> currentRoute = new ArrayList<>(); //현재 들어 있는 경로들이 ArrayList 형태
    boolean[] visited;
    List<String> answer;

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        currentRoute.add("ICN");

        dfs(tickets, "ICN");
        // answer 변수의 용도: 현재 들어있는 경로들 중 알파벳 순서가 가장 앞서는 것 저장
        return answer.toArray(new String[0]);
    }

    private void dfs( String[][] tickets, String target) {
        if (currentRoute.size() - 1 == tickets.length) {
            if (answer == null) {
                answer = new ArrayList<>(currentRoute);
            } else {
                // 문자열을 하나로 합쳐서 비교
                String currentRouteStr = String.join("", currentRoute);
                String answerStr =  String.join("", answer);
                //문자열 비교: String.join("", currentRoute)를 사용하여 currentRoute와 answer를 문자열로 결합하여 비교
                // 사전순 비교
                if (currentRouteStr.compareTo(answerStr) < 0) {
                    answer = new ArrayList<>(currentRoute);
                }
            }
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(target)) {
                visited[i] = true;
                currentRoute.add(tickets[i][1]);

                dfs(tickets, tickets[i][1]);

                visited[i] = false;
                currentRoute.remove(currentRoute.size() - 1);
            }
        }
    }
}

/*
테스트 1 〉	통과 (107.73ms, 110MB)
테스트 2 〉	통과 (0.05ms, 89MB)
테스트 3 〉	통과 (0.04ms, 72.7MB)
테스트 4 〉	통과 (0.06ms, 78.1MB)
정확성: 100.0
합계: 100.0 / 100.0
 */