package week_8.sapientia1007;

import java.util.*;
// https://m.blog.naver.com/sosow0212/222961687890
public class PGS_여행경로 {
    static class Solution {
        boolean[] v;
        ArrayList<String> allRoute;
        public String[] solution(String[][] tickets) {
            String[] answer = {};
            v = new boolean[tickets.length]; // 사용 처리 배열
            allRoute = new ArrayList<>();

            dfs("ICN", "ICN", tickets, 0); // 출발지 설정 -> 모든 가능한 경로를 사전순으로 정렬
            Collections.sort(allRoute);

            // 사전순으로 가장 앞서는 경로를 선택하여 공백을 기준으로 분할하여 배열로 반환
            answer = allRoute.get(0).split(" ");

            return answer;
        }
        public void dfs(String start, String route, String[][] tickets, int cnt){
            // 모든 항공권을 사용한 경우(탐색 완료)
            if (cnt == tickets.length){
                allRoute.add(route); // 현재 경로 추가
                return; // 재귀 호출 종료
            }
            // 주어진 항공권들을 순회하며 경로 탐색
            for (int i=0; i<tickets.length; i++){
                // 현재 출발지가 항공권의 출발지와 같고, 해당 항공권을 아직 사용하지 않은 경우
                if (start.equals(tickets[i][0]) && !v[i]) {
                    v[i] = true; // 해당 항공권 사용 처리

                    // 다음 경로로 이동 + 현재까지의 경로와 항공권 사용 횟수를 재귀
                    dfs(tickets[i][1], route+ " " +tickets[i][1], tickets, cnt+1);
                    v[i] = false; // 사용 초기화
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new String[][] {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}}));
        System.out.println(s.solution(new String[][] {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}}));
    }
}

/*
정확성  테스트
테스트 1 〉	통과 (98.93ms, 100MB)
테스트 2 〉	통과 (11.84ms, 80.8MB)
테스트 3 〉	통과 (8.84ms, 75.8MB)
테스트 4 〉	통과 (9.70ms, 79.8MB)
*/