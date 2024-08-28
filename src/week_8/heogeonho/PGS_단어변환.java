package week_8.heogeonho;

import java.util.*;

public class PGS_단어변환 {

	/*
	단어 처리 탐색 활용하기
	최단 경로 찾는 느낌의 문제
	bfs 를 활용하고 결과 값 찾으면 최종 값이 될 것으로 판단!

	다음 queue에 넣을 값은 단어 각 자리 비교해서 하나만 다른 값을 넣기

	begin -> dq.offer
	while(!dq.isEmpty)
		dq.꺼내기
		for 순회
			if v[]==false, 자리수 하나만 다른 경우
				방문처리
				dq.offer
				결과값 업데이트 이전 값 + 1
				(이렇게 가능할 것이라는 것을 가정한 이유는
					항상 그 자리에 처음 도착한 수치가 그 자리까지 가는데 최소 값이기 때문에
					이렇게 해도 최적의 값만 나오는 것으로 생각)
	 */

	public static void main(String[] args) {
		String begin = "hot";
		String target = "lot";
		String[] words = {"hot", "dot", "dog", "lot", "log"} ;
		System.out.println(solution(begin, target, words));
	}

	static ArrayDeque<Integer> dq=new ArrayDeque<>();
	static boolean[] v;
	static int[] route;
	static int solution(String begin, String target, String[] words) {
		v=new boolean[words.length];
		route=new int[words.length];

		// target 값이 없으면 무조건 0
		if(!Arrays.asList(words).contains(target)) {
			return 0;
		}
		// 첫 탐색은 먼저 dq에 넣고 시작 [index]
		for (int k=0; k<words.length; k++) {
			if(!v[k] && canConvert(begin, words[k])) {
				v[k]=true;
				route[k]=1;
				if(words[k].equals(target)) {
					return route[k];
				}
				dq.offer(k);
			}
		}
		return bfs(target, words);
	}

	static int bfs(String target, String[] words) {

		while(!dq.isEmpty()) {
			int now = dq.poll();
			for (int k=0; k<words.length; k++) {
				if(!v[k] && canConvert(words[now], words[k])) {
					v[k]=true;
					route[k]=route[now]+1;
					if(words[k].equals(target)) {
						return route[k];
					}
					dq.offer(k);
				}
			}
		}
		return 0;
	}

	static boolean canConvert(String word1, String word2){
		int diffCnt = 0;
		for (int i = 0; i<word1.length(); i++){
			if (word1.charAt(i) != word2.charAt(i)){
				diffCnt++;
			}
		}
		return diffCnt ==1;
	}
}

/*
테스트 1 〉	통과 (0.10ms, 75.5MB)
테스트 2 〉	통과 (0.12ms, 75.7MB)
테스트 3 〉	통과 (0.51ms, 75.9MB)
테스트 4 〉	통과 (0.11ms, 76MB)
테스트 5 〉	통과 (0.06ms, 75.9MB)
*/