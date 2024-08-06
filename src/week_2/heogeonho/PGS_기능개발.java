package week_2.heogeonho;

import java.util.*;
import java.io.*;

/*
큐를 사용하는 아이디어까지는 생각했지만

처음엔 큐에 작업 진도를 바로 넣고 로직을 작성하느라 구현에 어려움을 겪었다.
	자료구조를 활용하기 전에 값에 대한 처리를 미리 하는 아이디어를 고려할 것!
 */

public class PGS_기능개발 {
	public static int[] solution(int[] progresses, int[] speeds) {
		ArrayDeque<Integer> q=new ArrayDeque<>();
		ArrayList<Integer> list=new ArrayList<>();
		
		// task 소요일자를 큐에 삽입 (나머지 있으면 +1 추가)
		for(int i=0; i<progresses.length; i++) {
			if((100-progresses[i])%speeds[i]==0) {
				q.offer((100-progresses[i])/speeds[i]);
			}
			else {
				q.offer((100-progresses[i])/speeds[i]+1);
			}
		}
//			System.out.println(q.toString());
		
		
		int task=q.poll();
		int count=1; //결과 배열에 배포 task 넣기 위한 변수
		
		// 반복 큐가 빌때까지
		// 테스크 꺼내고 peek 비교
		// 테스크 소요일이 peek보다 길면 cnt++, 꺼내
		while (true) {
			if(q.isEmpty()) break;
//				System.out.println(task);
			if(q.peek()<=task) {
				q.poll();
				count++;
			} else if(q.peek()>task) {
				list.add(count);
				task=q.poll();
				count=1;
			}
		}
		list.add(count);
		
		int[] answer=new int[list.size()];
		for(int i=0; i<list.size(); i++) answer[i]=list.get(i);
		return answer;
		
	}


	public static void main(String[] args) {
		int[] prog=new int[]{95, 90, 99, 99, 80, 99};
		int[] sp={1, 1, 1, 1, 1, 1};
		System.out.println(Arrays.toString(solution(prog,sp)));
	}

}
