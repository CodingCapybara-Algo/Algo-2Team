package week_7.heogeonho;

public class PGS_정수삼각형 {
	
	/*
	꼭대기부터 내려올 것
	2차원 배열에 삼각형을 어떻게 저장할지 고민
	변수를 활용하여 삼각형에 해당하는 자리를 처리
	양쪽 맨 끝과 관련된 case 처리
	 */

	static int solution(int[][] triangle) {
		int n = triangle.length; // 삼각형의 높이를 변수 n으로 저장

		for (int i = 1; i < n; i++) { // 높이
			for (int j = 0; j <= i; j++) { // 가로 순회
				if (j == 0) {
					// 맨 왼쪽 경로의 경우
					triangle[i][j] += triangle[i-1][j];
				} else if (j == i) {
					// 맨 오른쪽 경로의 경우
					triangle[i][j] += triangle[i-1][j-1];
				} else {
					// 나머지 경우는 위의 두 경로 중 더 큰 값을 선택
					triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
				}
			}
		}

		// 마지막 행의 최대값이 정답 (메모이제이션 결과)
		int maxSum = 0;
		for (int i = 0; i < n; i++) {
			maxSum = Math.max(maxSum, triangle[n - 1][i]);
		}
		return maxSum;
	}

	public static void main(String[] args) {
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		System.out.println(solution(triangle));
	}
}

/*
정확성  테스트
테스트 1 〉	통과 (0.03ms, 74MB)
테스트 2 〉	통과 (0.03ms, 73.4MB)
테스트 3 〉	통과 (0.06ms, 73.9MB)
테스트 4 〉	통과 (0.08ms, 79.2MB)
테스트 5 〉	통과 (0.33ms, 74MB)
테스트 6 〉	통과 (0.09ms, 73.4MB)
테스트 7 〉	통과 (0.24ms, 71.2MB)
테스트 8 〉	통과 (0.07ms, 76.2MB)
테스트 9 〉	통과 (0.03ms, 72.6MB)
테스트 10 〉	통과 (0.05ms, 78.9MB)
효율성  테스트
테스트 1 〉	통과 (6.76ms, 60.6MB)
테스트 2 〉	통과 (8.36ms, 59MB)
테스트 3 〉	통과 (7.09ms, 64MB)
테스트 4 〉	통과 (7.50ms, 66.4MB)
테스트 5 〉	통과 (7.90ms, 59.7MB)
테스트 6 〉	통과 (9.32ms, 60.6MB)
테스트 7 〉	통과 (9.09ms, 61.5MB)
테스트 8 〉	통과 (9.46ms, 59.9MB)
테스트 9 〉	통과 (7.06ms, 61.5MB)
테스트 10 〉	통과 (7.00ms, 60.1MB)
*/
