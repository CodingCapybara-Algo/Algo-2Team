package week_8.heogeonho;

import java.util.*;

public class PGS_여행경로 {

	/*
	간선정보
	2차원 배열을 어떻게 활용해야 할 것인지?

	-> 시작 지역 저장
	다음 지역 탐색
	현재 지역의 다음 지역 tickets[i][1] == 시작 자역 tickets[i][0]인 것 찾아서 탐색 돌리기

	*** 알파벳 순으로 앞서는 것을 찾으려면...? ***
	-> 아이디어 찾아본 결과 문자열 하나로 만들어 버리면 되는 방법이 있었는데
		다른 방법이 있는지 알아볼 것!
	 */

	public static void main(String[] args) {
		String[][] tickets = new String[][] {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		System.out.println(solution(tickets));
	}

	static ArrayList<String> results = new ArrayList<>();
	static boolean v[];

	static String[] solution(String[][] tickets) {
		v = new boolean[tickets.length];
		dfs(0, "ICN", "ICN", tickets);
		Collections.sort(results);

		return results.get(0).split(" ");
	}

	// 문자열로 path를 만들어내는 idea (단어와 관련된 dfs 문제랑 비슷하게 풀면 되는 문제)
	static void dfs(int depth, String now, String path, String[][] tickets){
		if (depth == tickets.length) {
			results.add(path);
			return;
		}
		for (int i = 0; i < v.length; i++) {
			// 현재 지역의 다음 지역 tickets[i][1] == 시작 자역 tickets[i][0]인 것 찾아서 탐색 돌리기, 방문처리도 고려
			if (now.equals(tickets[i][0]) && !v[i]) {
				v[i] = true;
				dfs(depth+1, tickets[i][1], path + " " +tickets[i][1], tickets);
				v[i] = false;
			}
		}
	}
}

/*
테스트 1 〉	통과 (84.41ms, 101MB)
테스트 2 〉	통과 (10.40ms, 74.8MB)
테스트 3 〉	통과 (11.92ms, 80.7MB)
테스트 4 〉	통과 (12.47ms, 73MB)
*/
