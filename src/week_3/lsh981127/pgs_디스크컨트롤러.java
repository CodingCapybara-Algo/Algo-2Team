package week_3.lsh981127;
import java.util.*;
public class pgs_디스크컨트롤러 {
    public int solution(int[][] jobs) {
        int current = 0;        // 진행 시간
        int total = 0;          // 작업 총 시간
        int count = 0;          // 진행한 작업 수
        int index = 0;          // jobs에서 진행 중인 작업의 index


        Arrays.sort(jobs, (o1,o2) -> o1[0] - o2[0]);        // 작업 시작 시간 기준 정렬

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        // PQ에 2차원 배열을 넣어주는 경우, 무엇을 기준으로 정렬할지 조건을 안 넣어주면 ClassCastException 에러 발생
        // https://mygoodplace.tistory.com/191?category=1158480


        while(count < jobs.length) {
            while (index < jobs.length && current >= jobs[index][0]) {
                // 지금 진행할 수 있는 작업들에 대해서 힙에 넣기
                pq.offer(jobs[index++]);
            }

            if(pq.isEmpty()) {
                // 작업할 수 있는 게 없어서 가장 빠른 시간대에 있는 작업 진행
                current = jobs[index][0];  // 다음 작업의 시작점으로 current 옮기기
            } else {
                // 진행할 수 있는 작업들이 PQ에 있기에 해당 작업들 중 최소 작업 기간을 가지는 작업을 진행
                int[] temp = pq.poll();
                total += current + temp[1] - temp[0];
                count++;
                current += temp[1];
            }

        }

        int answer = total / jobs.length;
        return answer;
    }
}
