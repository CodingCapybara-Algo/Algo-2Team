package week_2.heogeonho;

import java.util.*;
import java.io.*;

public class PGS_주식가격 {
	
	/*
	스택에 1차원 배열을 넣는다
	인덱스와 value
	
	peek을 이용해 다음 넣을 것과 비교
	
		만약 해당 peek 숫자보다 다음 숫자가 작으면 해당 숫자 꺼내고
		꺼낸 숫자의 인덱스와 다음 숫자 인덱스 비교하여 차이값을 꺼낸 인덱스의 결과 리스트에 넣는다
		
		위 반복은 다음 숫자가 클 때까지 반복한다.
		
	다 끝나면 마지막 인덱스 값과 나머지 스택 값을 비어있을 때까지 처리 후 마무리한다.
	
	 */
	
    public static int[] solution(int[] prices) {
    	Stack<int[]> stack=new Stack<>();
    	int len=prices.length;
    	int[] answer = new int[len];
    	
    	for(int i=0; i<len; i++) {	// 전체 prices 순회를 위한 반복문
    		
    		if(stack.isEmpty()) { 				// 비어있으면 값 넣고 다음 인덱스 처리
    			stack.push(new int[] {i, prices[i]});
    			continue;
    		}
    				
			while(stack.peek()[1]>prices[i]) { // 스택이 안비어있을때만 수행
				int[] tmp=stack.pop();
				answer[tmp[0]]=i-tmp[0];
				if(stack.isEmpty()) break;
			}
			stack.push(new int[] {i, prices[i]}); // 비교하고 결과값 산출 후 다음과정 넘어가기 전 push
    	}
   
    	int n= stack.size();
    	for (int i=0; i<n; i++) {	// push 과정 끝나고 남아있는 겂에 대한 처리
    		int[] tmp=stack.pop();
			answer[tmp[0]]=len-1-tmp[0];
    	}
        return answer;
    }

	public static void main(String[] args) {
		int[] prices = {1, 2, 3, 2, 3};
		System.out.println(Arrays.toString(solution(prices)));
	}

}
