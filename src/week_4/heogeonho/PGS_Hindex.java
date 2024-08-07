package week_4.heogeonho;

import java.util.*;
import java.io.*;

public class PGS_Hindex {
	
	/*
	내림차순 정렬
	인덱스 0부터 탐색
	인덱스의 value값과 인덱스의 값을 비교 (value번 이상 인용된 논문이 index+1편 이상이다)
	h편 이상을 기준으로 판단하는게 좋을듯
	
	value가 index+1보다 크냐? 작으면 안됨 작으면 이전 저장 값리턴해주면 된다.
	 */
	
	
	static int solution(int[] citations) {
		
		Integer[] arr=Arrays.stream(citations).boxed().toArray(Integer[]::new);
		Arrays.sort(arr, Collections.reverseOrder());
		
		int answer = 0;
		for(int i=0; i<arr.length; i++) {
			int h=i+1;
			System.out.println(h+" /"+ arr[i]);
			if(h>arr[i]) {
				answer = h-1;
				break;
			}
			// 전체 순회를 마쳤을 때 조건문에 안걸리면 h 값이 0이 나오면 안되도록 처리
			if(i==arr.length-1) answer = h;
		}
		return answer;
    }

	public static void main(String[] args) {
		int[] citations = {3, 4};
		System.out.println(solution(citations));
	}
}

/*
테스트 1 〉	통과 (4.05ms, 80.3MB)
테스트 2 〉	통과 (3.26ms, 78.8MB)
테스트 3 〉	통과 (3.13ms, 78.1MB)
테스트 4 〉	통과 (3.27ms, 77.4MB)
테스트 5 〉	통과 (4.86ms, 78.2MB)
테스트 6 〉	통과 (5.15ms, 76.8MB)
테스트 7 〉	통과 (4.21ms, 77.6MB)
테스트 8 〉	통과 (2.76ms, 73.8MB)
테스트 9 〉	통과 (16.43ms, 71.5MB)
테스트 10 〉	통과 (7.48ms, 71.8MB)
테스트 11 〉	통과 (5.29ms, 79.7MB)
테스트 12 〉	통과 (18.76ms, 83.4MB)
테스트 13 〉	통과 (4.00ms, 75.8MB)
테스트 14 〉	통과 (5.09ms, 87.6MB)
테스트 15 〉	통과 (3.14ms, 67.5MB)
테스트 16 〉	통과 (2.03ms, 75.3MB)
*/
