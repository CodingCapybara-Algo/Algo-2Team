package week_3.skwent77;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<Job> jobQueue = new PriorityQueue<>(Comparator.comparingInt(job -> job.requestTime));

        for (int[] job : jobs) {
            jobQueue.offer(new Job(job[0], job[1]));
        }

        PriorityQueue<Job> processQueue = new PriorityQueue<>(Comparator.comparingInt(job -> job.duration));

        int currentTime = 0;
        int totalTime = 0;
        int jobCount = jobs.length;

        while (!jobQueue.isEmpty() || !processQueue.isEmpty()) {
            while (!jobQueue.isEmpty() && jobQueue.peek().requestTime <= currentTime) {
                processQueue.offer(jobQueue.poll());
            }

            if (!processQueue.isEmpty()) {
                Job currentJob = processQueue.poll();
                currentTime += currentJob.duration;
                totalTime += currentTime - currentJob.requestTime;
            } else {
                currentTime++;
            }
        }

        answer = totalTime / jobCount;
        return answer;
    }

    class Job {
        int requestTime;
        int duration;

        public Job(int requestTime, int duration) {
            this.requestTime = requestTime;
            this.duration = duration;
        }
    }
}
/*
테스트 1 〉	통과 (0.40ms, 73.8MB)
테스트 2 〉	통과 (0.52ms, 72.6MB)
테스트 3 〉	통과 (0.71ms, 75.4MB)
테스트 4 〉	통과 (0.59ms, 69.1MB)
테스트 5 〉	통과 (0.45ms, 78.5MB)
테스트 6 〉	통과 (0.86ms, 74.3MB)
테스트 7 〉	통과 (78.36ms, 123MB)
테스트 8 〉	통과 (0.38ms, 73.6MB)
테스트 9 〉	통과 (0.38ms, 72.2MB)
테스트 10 〉	통과 (0.47ms, 71.5MB)
 */