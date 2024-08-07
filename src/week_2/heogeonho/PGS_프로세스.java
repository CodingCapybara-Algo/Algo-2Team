package week_2.heogeonho;

import java.util.*;
import java.io.*;

public class PGS_프로세스 {
	
	/*
	리스트 sort 하고 해당 값 찾기로 가볼까...
	큐 활용
	원하는 숫자 나올때까지 빼고 넣고
	원하는 숫자(인덱스 찾기)이면 이후 카운트 +1
	
	인덱스 포함한 1차원 배열을 큐에 넣는 아이디어?
	 */
	
    public static int solution(int[] priorities, int location) {
    	
    	ArrayDeque<int[]> q=new ArrayDeque<>();
    	
    	// 인덱스와 해당 자리의 값을 큐에 넣는 로직
    	for(int i=0; i<priorities.length; i++) {
    		q.offer(new int[] {i, priorities[i]});
    	}
    	
    	// 우선순위별로 정렬해서 값 꺼내기 위해 배열 정렬
    	Arrays.sort(priorities);
    	
    	int cnt=0;
    	
    	// 뽑아야 하는 총 길이 반복 (값 하나하나 꺼내기 위한 반복)
    	for(int i=priorities.length-1; i>=0; i--) {
    		int find = priorities[i]; //찾아야 하는 값 (우선순위 높은 순)
    	
    		//그때그때 size 반복으로 원하는 숫자 찾아내기
    		for(int j=0; j<q.size(); j++) {
    			int[] idxVal=q.poll();
    			System.out.println(Arrays.toString(idxVal));
    			
    			if(idxVal[1]==find) { // 우선순위 맞는것 찾았으면 다음턴으로
    				cnt++;
    				if(idxVal[0]==location) { // 입력값에 해당하는 값 찾으면 리턴
    					return cnt;
    				}
    				break;
    			}
    			q.offer(idxVal);
    		}
    	}
        return 0;
    }

	public static void main(String[] args) {
		int[] priorities = {9, 9, 6};
		int location = 2;
		System.out.println(solution(priorities, location));
	}

}
