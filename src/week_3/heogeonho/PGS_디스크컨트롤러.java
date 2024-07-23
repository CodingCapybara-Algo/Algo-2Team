package a0000.geon;

import java.util.*;
import java.io.*;

public class PGS_디스크컨트롤러 {
	public static void main(String[] args) throws Exception{

		int[][] jobs= {{0, 3}, {1, 9}, {2, 6}};
		System.out.println(solution(jobs));
	}
	
	/*
	jobs[-][0] 작업이 주어지는 시점을 기준으로 요청 전 작업 pq생성 jobsPQ
	jobs[-][1] 작업 소요 시점을 기준으로 디스크 대기 리스트 pq생성 diskPQ
	
	두 PQ가 빌때까지 반복하도록
	
	첫 작업 미리 넣고 반복하기
	
	꺼낸 다음에
	끝나는 시간 계산 최신화 (끝나는시간 이전에 요청되는 작업 poll & 디스크에 offer)
	
	 */
	

    static int solution(int[][] jobs) {
    	PriorityQueue<int[]> jobsPQ=new PriorityQueue<>((o1, o2) -> Integer.compare(o1[0],o2[0]));
    	PriorityQueue<int[]> diskPQ=new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1],o2[1]));

    	for(int[] jl: jobs) jobsPQ.offer(jl);
    	
    	diskPQ.offer(jobsPQ.poll());
    	
        int endTime=diskPQ.peek()[0]+diskPQ.peek()[1];  // 제일 빨리 들어오는 작업의 종료시간 계산 -> endTime
        int totalTime=endTime-diskPQ.peek()[0];              // & 토탈 타임에 종료시간-요청시간 더하기
        
        int answer = 0;
        int time = 0;
        // 소요시간 우선순위 큐 또는 작업 요청 시점 우선순위 큐가 비어있지 않을 때
        while(!jobsPQ.isEmpty() || !diskPQ.isEmpty()){
            // 현재 시간에 수행 가능한 작업을 모두 소요시간 우선순위 큐에 넣음
            while(!jobsPQ.isEmpty() && jobsPQ.peek()[0] <= time){
            	diskPQ.offer(jobsPQ.poll());
            }

            if(diskPQ.isEmpty()){ // 소요시간 우선순위 큐가 비었다면 현재 시간에 수행 가능항 작업이 없다는 뜻이므로 현재 시간을 최소 요청시간으로 변경
                time = jobsPQ.peek()[0];
            }else{ // 소요시간 우선순위 큐에서 작업시간이 가장 적은 것을 꺼내서 먼저 계산
                int[] j = diskPQ.poll();
                answer += time + j[1] - j[0];
                time += j[1];
            }
            // 다시 현재 시간을 기준으로 수행 가능한 작업을 소요시간 우선순위 큐에 넣음
        }

        answer /= jobs.length;

        return answer;
    }
}
