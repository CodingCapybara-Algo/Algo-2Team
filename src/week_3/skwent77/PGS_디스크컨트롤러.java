package week_3.skwent77;

import java.util.*;

public class PGS_디스크컨트롤러 {
    public int solution(int[][] jobs) {
        int answer =0;
        PriorityQueue<Job> jobQueue = new PriorityQueue<>();
        for (int[] job : jobs) {
            jobQueue.offer(new Job(job[0], job[1]));
        }

        // 작업을 처리하는 우선순위 큐 (작업의 소요 시간을 기준으로 정렬)
        PriorityQueue<Job> processQueue = new PriorityQueue<>(Comparator.comparingInt(job -> job.duration));

        int currentTime = 0; // 현재 시간
        int totalTime = 0;   // 총 소요 시간
        int jobCount = jobs.length; // 작업의 총 개수

        while (!jobQueue.isEmpty() || !processQueue.isEmpty()) {
            // 현재 시간 이전에 요청된 모든 작업을 processQueue에 추가
            while (!jobQueue.isEmpty() && jobQueue.peek().requestTime <= currentTime) {
                processQueue.offer(jobQueue.poll());
            }

            // processQueue에서 작업을 꺼내서 처리
            if (!processQueue.isEmpty()) {
                Job currentJob = processQueue.poll();
                currentTime += currentJob.duration;
                totalTime += currentTime - currentJob.requestTime;
            } else {
                // 처리할 작업이 없으면 현재 시간을 증가
                currentTime++;
            }
        }
        answer =  totalTime / jobCount;
        return answer;
    }

    class Job implements Comparable<Job> {
        int requestTime;
        int duration;

        public Job(int requestTime, int duration) {
            this.requestTime = requestTime;
            this.duration = duration;
        }

        @Override
        public int compareTo(Job other) {
            return this.requestTime - other.requestTime;
        }
    }
}