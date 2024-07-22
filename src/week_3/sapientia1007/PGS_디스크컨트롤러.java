package week_3.sapientia1007;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class PGS_디스크컨트롤러 {
    static class Solution {
        public int solution(int[][] jobs) {
            int answer = 0;
            int currentTime = 0; // 현재시간

            // 작업 요청 순으로 일단 jobs 정렬
            Arrays.sort(jobs, Comparator.comparingInt(job-> job[0]));

            // 우선순위 큐에 작업시간 기준으로 정렬
            PriorityQueue<int[]> pq = new PriorityQueue<>(
                    Comparator.comparingInt(o -> o[1])
            );

            int jobIdx = 0; // 현재 확인중인 job 인덱스
            int completedJobs = 0; // 완료된 작업 수

            while (completedJobs < jobs.length) {
                // 현재 시간까지 요청된 모든 작업을 우선순위 큐에 추가 + 확인 idx++
                while (jobIdx < jobs.length && jobs[jobIdx][0] <= currentTime) {
                    pq.offer(jobs[jobIdx]);
                    jobIdx++;
                }

                if (pq.isEmpty()) { // 큐가 비어있으면, 다음작업으로
                    currentTime = jobs[jobIdx][0];
                } else {
                    // 가장 짧은 작업을 꺼내어 처리
                    int[] task = pq.poll();
                    currentTime += task[1]; // 현재 시간 update
                    answer += (currentTime - task[0]);
                    completedJobs++;
                }
            }
            return answer / jobs.length;
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
