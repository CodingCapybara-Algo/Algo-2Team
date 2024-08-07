package week_5.heogeonho;

import java.util.*;
import java.io.*;

public class PGS_모음사전 {
	
	/*
		그래프 탐색 탐색 경로에서 전역 cnt변수 +1 반복해서 사전 순서 체크
		
		DFS 활용
		중복 허용 -> 방문처리 X
		문자열처리
		
		
		DFS(depth, str)
			-> 이건 고민중인건데 find 변수 하나 해줘서 재귀를 종료해야 하나 고민.
		
			IF 깊이 5글자 리턴 (우린 전역 cnt변수만 고려하기 때문에 리턴만 해줘도 ok)
			for (i -> 0~4) //알파벳 순회
			str + arr[i] (다음 dfs에 전달)
			cnt++;
			dfs(depth+1,str + arr[i],   )
	 */
	
	static String[] arr=new String[] {"A", "E", "I", "O", "U"};
	static int cnt=0;
	static boolean isFind=false;
	
    static int solution(String word) {
    	
    	dfs(0, "", word);
    	
        int answer = cnt;
        return answer;
    }
    

	// 모든 길이의 순열 구하기?
    // 매번 set에 저장하는 방식
    // 끝 자리까지 보면 종료
    static void dfs(int depth, String str, String word) {
    	if(str.length()==5 || isFind) return;

    	for(int i=0; i<5; i++) {
    		
    		System.out.println("depth "+depth+" ___str="+(str+arr[i])+" / cnt="+cnt);
    		if(word.equals(str+arr[i])) {
    			isFind=true;
    			cnt++;
    		}
    		if(isFind) return;
    		cnt++;
    		dfs(depth+1, str+arr[i], word);
    	}
    }


	public static void main(String[] args) {
		String word="EIO";
		System.out.println(solution(word));
	}

}

/*
 테스트 1 〉	통과 (1.45ms, 73.8MB)
테스트 2 〉	통과 (1.56ms, 76.7MB)
테스트 3 〉	통과 (3.24ms, 71.9MB)
테스트 4 〉	통과 (3.49ms, 76.4MB)
테스트 5 〉	통과 (3.44ms, 77.4MB)
테스트 6 〉	통과 (3.13ms, 71.4MB)
테스트 7 〉	통과 (3.97ms, 78.6MB)
테스트 8 〉	통과 (2.31ms, 76.9MB)
테스트 9 〉	통과 (2.56ms, 73.6MB)
테스트 10 〉	통과 (1.96ms, 75.3MB)
테스트 11 〉	통과 (2.90ms, 71MB)
테스트 12 〉	통과 (1.85ms, 74.6MB)
테스트 13 〉	통과 (2.71ms, 76.6MB)
테스트 14 〉	통과 (2.90ms, 77.9MB)
테스트 15 〉	통과 (3.13ms, 78.5MB)
테스트 16 〉	통과 (2.41ms, 76.2MB)
테스트 17 〉	통과 (3.08ms, 80.4MB)
테스트 18 〉	통과 (2.61ms, 74.7MB)
테스트 19 〉	통과 (4.89ms, 81MB)
테스트 20 〉	통과 (2.96ms, 74.2MB)
테스트 21 〉	통과 (1.32ms, 78.6MB)
테스트 22 〉	통과 (2.29ms, 78.8MB)
테스트 23 〉	통과 (1.55ms, 75.6MB)
테스트 24 〉	통과 (2.73ms, 73.5MB)
테스트 25 〉	통과 (1.59ms, 73.9MB)
테스트 26 〉	통과 (2.20ms, 72.8MB)
테스트 27 〉	통과 (2.72ms, 73.7MB)
테스트 28 〉	통과 (5.28ms, 77.9MB)
테스트 29 〉	통과 (1.38ms, 77MB)
테스트 30 〉	통과 (2.22ms, 76.6MB)
테스트 31 〉	통과 (3.24ms, 71.6MB)
테스트 32 〉	통과 (3.17ms, 74.2MB)
테스트 33 〉	통과 (3.99ms, 78.2MB)
테스트 34 〉	통과 (3.04ms, 67.8MB)
테스트 35 〉	통과 (4.09ms, 70.2MB)
테스트 36 〉	통과 (4.10ms, 74.8MB)
테스트 37 〉	통과 (2.40ms, 84MB)
테스트 38 〉	통과 (5.38ms, 71.5MB)
테스트 39 〉	통과 (4.05ms, 78.6MB)
테스트 40 〉	통과 (3.12ms, 78.3MB)
*/
