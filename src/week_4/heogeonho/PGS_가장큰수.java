package week_4.heogeonho;

import java.util.*;
import java.io.*;

public class PGS_가장큰수 {
	
	/*
	-> 	기존 아이디어는 각 숫자들의 자리 하나하나 비교해서 해보려고 했으나 로직이 매우 복잡해짐
		좀 더 코드의 단순화 및 로직의 간편화를 위해 다른 아이디어 모색
		
	-> 	변경된 아이디어 직접 각 2개의 수를 합쳐 문자열을 2개 만들고 
		문자열이 숫자일 경우 더 큰걸 선택하도록 로직 구성
		
		비교를 위한 람다 식 활용하면 간편해짐
		o1, o2 숫자를 문자열로 변경 후 + 연산
		형성된 문자열을 숫자로 변경 후 비교 연산
		더 큰 값이 나올 때를 우선으로 정렬
		
	새롭게 알아봐야 할 부분
	int[] 배열에서는 Arrays.sort 못쓰는 것인가?
	 */
	
	
	static String solution(int[] numbers) {
		int len=numbers.length;
		
		// String 배열 생성
		String[] strings=new String[len];
		for(int i=0; i<len; i++) {
			strings[i]=String.valueOf(numbers[i]);
		}
		
		// Stirng 배열에 대한 정렬
		Arrays.sort(strings, (o1, o2)-> (o2 + o1).compareTo(o1 + o2));
		// 아래 방법으로 하면 런타임 에러가 나더라구요
//		Arrays.sort(strings, (o1, o2)->{
//			String str1=o1+o2;
//			String str2=o2+o1;	
//			
//			// 내림차순을 위한 리턴값
//			if(Integer.parseInt(str1)>Integer.parseInt(str2)) return -1; 
//			else return 1;
//		});
		
		String answer="";
		if(strings[0].equals("0")) return "0";
		
		for(int i=0; i<len; i++) {
			answer+=strings[i];
		}
		
        return answer;
    }

	public static void main(String[] args) {
		int[] numbers = {3, 30, 34, 5, 9};
		System.out.println(solution(numbers));
	}
}

/*
테스트 1 〉	통과 (1907.75ms, 383MB)
테스트 2 〉	통과 (757.74ms, 399MB)
테스트 3 〉	통과 (2889.67ms, 393MB)
테스트 4 〉	통과 (14.44ms, 84MB)
테스트 5 〉	통과 (1418.29ms, 402MB)
테스트 6 〉	통과 (1151.01ms, 384MB)
테스트 7 〉	통과 (2.88ms, 72.7MB)
테스트 8 〉	통과 (2.28ms, 69MB)
테스트 9 〉	통과 (1.99ms, 71.5MB)
테스트 10 〉	통과 (2.47ms, 84.2MB)
테스트 11 〉	통과 (2.44ms, 73.7MB)
테스트 12 〉	통과 (1.82ms, 78.8MB)
테스트 13 〉	통과 (3.68ms, 73.3MB)
테스트 14 〉	통과 (2.40ms, 82.5MB)
테스트 15 〉	통과 (1.76ms, 76MB)
*/
