package week_6.heogeonho;

import java.util.*;

public class PGS_단속카메라 {
	
	/*
	차들 경로에서 카메라가 있으려면 나가는 시점에서 카메라가 있어야 최적의 로직을 짤 수 있을 것이라 생각

	끝시간 기준 정렬 sort
	정렬된 배열 순회하며 마지막에 설치된 카메라가 차량 범위에 안들면
	그 차량이 나가는 시점에 카메라 설치 (이러한 이유 때문에 나가는 시점을 기준으로 정렬)
	 */

	static int solution(int[][] routes) {
		// 이건 끝나는 시간 기준
		Arrays.sort(routes, (o1, o2) -> Integer.compare(o1[1], o2[1]));

		int answer = 0; // 필요한 카메라의 수
		int lastCamera = -30001; // 마지막 카메라 저장 (초반 값은 범위 밖 값)

		for (int[] route : routes) {
			if (lastCamera < route[0]) { // 이 경우는 시작 전에 카메라가 있었다는 것
				answer++;		// 즉 카메라 추가되어야 함
				lastCamera = route[1]; // 근데 카메라 위치는 최대한 이 차가 나갈때로 선정 해야 최적의 선택
			}
		}
		return answer;
	}


	public static void main(String[] args) {
	}
}

/*
정확성  테스트
테스트 1 〉	통과 (0.78ms, 71MB)
테스트 2 〉	통과 (0.51ms, 73MB)
테스트 3 〉	통과 (0.55ms, 76MB)
테스트 4 〉	통과 (0.90ms, 78.1MB)
테스트 5 〉	통과 (0.67ms, 73.3MB)
효율성  테스트
테스트 1 〉	통과 (5.81ms, 52.6MB)
테스트 2 〉	통과 (3.60ms, 53.7MB)
테스트 3 〉	통과 (9.37ms, 56.1MB)
테스트 4 〉	통과 (0.99ms, 52MB)
테스트 5 〉	통과 (7.95ms, 53.6MB)
*/
