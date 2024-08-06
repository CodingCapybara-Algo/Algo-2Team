package week_5.heogeonho;

public class PGS_최소직사각형 {
	
	/*
	 */

	public int solution(int[][] sizes) {
		for(int[] sl: sizes) {
			if(sl[0]<sl[1]) {
				int temp=sl[0];
				sl[0]=sl[1];
				sl[1]=temp;
			}
		}

		int maxX=Integer.MIN_VALUE;
		int maxY=Integer.MIN_VALUE;

		for(int[] sl: sizes) {
			if(maxX<sl[0]) maxX=sl[0];
			if(maxY<sl[1]) maxY=sl[1];
		}
		return maxX*maxY;
	}

	public static void main(String[] args) {
	}
}

/*
테스트 1 〉	통과 (0.02ms, 73.4MB)
테스트 2 〉	통과 (0.02ms, 74.8MB)
테스트 3 〉	통과 (0.03ms, 72.1MB)
테스트 4 〉	통과 (0.02ms, 79.1MB)
테스트 5 〉	통과 (0.03ms, 73.8MB)
테스트 6 〉	통과 (0.02ms, 71.4MB)
테스트 7 〉	통과 (0.03ms, 68.7MB)
테스트 8 〉	통과 (0.02ms, 74MB)
테스트 9 〉	통과 (0.02ms, 74.5MB)
테스트 10 〉	통과 (0.03ms, 81.1MB)
테스트 11 〉	통과 (0.04ms, 73.4MB)
테스트 12 〉	통과 (0.04ms, 75.5MB)
테스트 13 〉	통과 (0.10ms, 75.2MB)
테스트 14 〉	통과 (0.32ms, 81.1MB)
테스트 15 〉	통과 (0.50ms, 83.5MB)
테스트 16 〉	통과 (0.70ms, 94MB)
테스트 17 〉	통과 (0.91ms, 84.5MB)
테스트 18 〉	통과 (1.09ms, 74.1MB)
테스트 19 〉	통과 (0.96ms, 87.2MB)
테스트 20 〉	통과 (1.59ms, 78MB)
*/
