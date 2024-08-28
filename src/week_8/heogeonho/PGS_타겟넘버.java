package week_8.heogeonho;

public class PGS_타겟넘버 {
	
	/*
	정수들의 순서도 바뀌지 않고 +, - 만 처리하면 된다고 하니
	dfs를 통해서 하나하나 찾아가도 되겠다 싶었다.
	앞자리부터
	+ + + + +
	+ + + + -
	+ + + - +
	+ + + - -
	...
	이런식으로 처리해서 원하는 값이 나오면 answer + 1 을 해주는 방식

	->	index와 각 단계의 sum을 파라미터로 주어지도록 만들어 재귀 호출!
	 */
	static int answer = 0;

	public static void main(String[] args) {
		int[] numbers = {1,1,1,1,1};
		int target = 3;
		System.out.println(solution(numbers, target));
	}

	static int solution(int[] numbers, int target) {
		answer = 0;
		dfs(numbers, target, 0, 0);
		return answer;
	}

	static void dfs(int[] numbers, int target, int index, int sum) {
		if(index==numbers.length) {
			if(sum==target) answer+=1;
			return;
		}
		dfs(numbers, target, index+1, sum+numbers[index]);
		dfs(numbers, target, index+1, sum-numbers[index]);
	}
}

/*
테스트 1 〉	통과 (4.25ms, 69.8MB)
테스트 2 〉	통과 (7.55ms, 84.8MB)
테스트 3 〉	통과 (0.18ms, 77.6MB)
테스트 4 〉	통과 (0.40ms, 76.2MB)
테스트 5 〉	통과 (0.70ms, 80.7MB)
테스트 6 〉	통과 (0.26ms, 74.8MB)
테스트 7 〉	통과 (0.18ms, 75.3MB)
테스트 8 〉	통과 (0.40ms, 76.4MB)
*/
