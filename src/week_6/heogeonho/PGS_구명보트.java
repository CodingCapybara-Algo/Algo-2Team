package week_6.heogeonho;

import java.util.*;

public class PGS_구명보트 {
	
	/*
	2명밖에 못탄다가 큰 힌트였음

	-> 2명의 무게 합이 limit와 가장 가까운 것 찾아 넣기
	-> 50000명 이하니까 정렬하고 연산하면 시간초과 나지 않을 것으로 판단

	sort 해서 큰 수부터 비교
	두 수 합이 limit와 같거나 작으면 cnt+1
	한바퀴 돌았는데 없을 경우 숫자 하나만 삽입

	아니면 sort 후 작은 수 부터 비교
	두수 합이 limit를 넘는 순간 이전 값 넣는걸로 처리
	이걸로 선택 (큰 수는 무조건 한바퀴 돌아야 하는 경우 있을 수 있겠다 싶어서 아래 방식 선택)

	양끝 비교가 나으려남... 구현방식이 생각이 안나 위 방식 수행
	(결국 이게 정답!! 효율적이라고 생각하면 구현방식 고민 최대한 해보기)
	 */

/*
처음에 이렇게 풀었는데 시간초과에 효율성 0 나왔습니다...
	static int solution(int[] people, int limit) {
		ArrayList<Integer> arr=new ArrayList<>();
		for(int a:people) arr.add(a);

		arr.sort((o1, o2) -> Integer.compare(o1, o2));
		System.out.println(arr);

		int answer = 0;
		while(true) {
			int temp = arr.get(0);
			if(arr.size()==1) {
				answer++;
				break;
			}
			if(temp+arr.get(1)>limit) {
				arr.remove(0);
				answer++;
				continue;
			}
			for(int i=2; i<arr.size(); i++) {
				if(temp+arr.get(i)>limit) {
					arr.remove(i-1);
					arr.remove(0);
					answer++;
					break;
				}
			}
//			System.out.println(arr);
		}
		return answer;
	}
*/
	static int solution(int[] people, int limit) {
		int answer = 0;

		Arrays.sort(people);
		int min = 0;

		for (int max=people.length-1; min<=max; max--){ //이런 아이디어를 생각하지 못했습니다...
			// min<=max 요 부분 배워갑니다. 양쪽 처리 방식 외워두기
			if (people[min]+people[max]<=limit) min++;
			answer++;
		}
		return answer;
	}


	public static void main(String[] args) {
		int[] people=new int[] {70,50,80,50};
		int limit=100;
		System.out.println(solution(people, limit));
	}
}

/*

테스트 1 〉	통과 (1.60ms, 77.1MB)
테스트 2 〉	통과 (1.39ms, 77.2MB)
테스트 3 〉	통과 (1.90ms, 82.1MB)
테스트 4 〉	통과 (1.22ms, 79.3MB)
테스트 5 〉	통과 (0.83ms, 74.9MB)
테스트 6 〉	통과 (0.64ms, 75.3MB)
테스트 7 〉	통과 (1.04ms, 72.5MB)
테스트 8 〉	통과 (0.42ms, 78.2MB)
테스트 9 〉	통과 (0.80ms, 80.5MB)
테스트 10 〉	통과 (1.25ms, 73.9MB)
테스트 11 〉	통과 (1.88ms, 74.1MB)
테스트 12 〉	통과 (1.38ms, 72.4MB)
테스트 13 〉	통과 (1.08ms, 76MB)
테스트 14 〉	통과 (0.93ms, 74.9MB)
테스트 15 〉	통과 (0.49ms, 73.3MB)
테스트 16 〉	통과 (0.34ms, 73.5MB)
테스트 17 〉	통과 (0.43ms, 72.2MB)
테스트 18 〉	통과 (0.40ms, 75.2MB)
테스트 19 〉	통과 (0.57ms, 74.8MB)
테스트 20 〉	통과 (0.38ms, 81.2MB)
테스트 21 〉	통과 (0.37ms, 70.1MB)
테스트 22 〉	통과 (0.38ms, 76.2MB)
*/
