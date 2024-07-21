package week_3.sapientia1007;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class PGS_디스크컨트롤러 {
    static class Solution {
        public int solution(int[][] jobs) {
            int answer = 0;
            int currentTime = 0; // 현재시간
            // 두번째 값 기준으로 오름차순 정렬 -> 두번째 값이 동일하면 첫번째값 기준 오름차순 정렬
            PriorityQueue<int[]> pq = new PriorityQueue<>(
                    (o1, o2) ->  o1[1] == o2[1] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1])
            );

            // 현재 시간 기준으로 요청이 가능한 작업이고, 짧은 작업 시간 순
            int pqData = 0; // pq에 들어가 있는 데이터의 수 (jobs.length와 같을때까지)
            int jobIdx = 0; // 현재 확인중인 job 인덱스
            while (pqData < jobs.length){
                while (jobIdx<jobs.length && jobs[jobIdx][0]<=currentTime){
                    pq.offer(jobs[jobIdx]);
                    jobIdx++; currentTime++;
                }
            }

            int endTime = 0;

            while (!pq.isEmpty()){
                int[] task = pq.poll();
                System.out.println("현재 일 : " + Arrays.toString(task));
                endTime += task[1]; // 일 끝난 시간
                answer += Math.abs(endTime - task[0]); // 요청부터 종료까지의 총 작업 시간 누적
                System.out.println("끝난 시간 : " + endTime +" 작업 시간 : "+answer);
            }

            answer = answer/(jobs.length);
            System.out.println("----------");

            return answer;
        }
    }

    public static void main(String[] args) throws Exception {
        Solution s = new Solution();
        System.out.println(s.solution(new int[][] {{0, 3}, {1, 9}, {2, 6}})); // 9

        System.out.println(s.solution(new int[][] {{5, 10}, {6, 8}, {14, 2}, {11, 5}, {100, 7}})); // 11
        System.out.println(s.solution(new int[][] {{0, 1}, {2, 2}, {2, 3}})); // 2
        System.out.println(s.solution(new int[][] {{0, 3}, {4, 4}, {5, 3}, {7, 1}})); // 4

    }
}
