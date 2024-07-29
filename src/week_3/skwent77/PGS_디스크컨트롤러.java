package week_3.skwent77;

import java.util.*;

public class PGS_디스크컨트롤러 {

    public int solution(int[][] jobs) {
        int answer = 0;
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

        answer = totalTime / jobCount;
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
/*
테스트 1 〉	통과 (7.09ms, 83.5MB)
테스트 2 〉	통과 (9.98ms, 74.6MB)
테스트 3 〉	통과 (5.18ms, 82.5MB)
테스트 4 〉	통과 (5.37ms, 77.9MB)
테스트 5 〉	통과 (6.91ms, 80.1MB)
테스트 6 〉	통과 (4.41ms, 77.8MB)
테스트 7 〉	통과 (4.85ms, 68.4MB)
테스트 8 〉	통과 (4.11ms, 77.1MB)
테스트 9 〉	통과 (4.14ms, 71MB)
테스트 10 〉	통과 (4.06ms, 71.7MB)
테스트 11 〉	통과 (2.38ms, 70.3MB)
테스트 12 〉	통과 (2.16ms, 77.6MB)
테스트 13 〉	통과 (2.30ms, 77.2MB)
테스트 14 〉	통과 (2.10ms, 77.3MB)
테스트 15 〉	통과 (2.16ms, 76.2MB)
테스트 16 〉	통과 (2.13ms, 76.5MB)
테스트 17 〉	통과 (2.65ms, 77MB)
테스트 18 〉	통과 (2.95ms, 78.5MB)
테스트 19 〉	통과 (2.12ms, 74.3MB)
테스트 20 〉	통과 (2.14ms, 77.5MB)
 */