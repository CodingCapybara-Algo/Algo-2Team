package week_2.lsh981127;

import java.util.*;
public class pgs_프로세스 {
    public int solution(int[] priorities, int location) {
        ArrayDeque<int[]> q = new ArrayDeque<>();               // 우선순위를 기록하기 위한 덱
        PriorityQueue<Integer> pq = new PriorityQueue<>();      // 더 큰 값이 존재하는지 확인하기 위한 우선순위 큐

        for(int i = 0; i < priorities.length; i++) {
            q.offer(new int[]{i, priorities[i]});               // {기존 index, 우선순위}
            pq.offer(priorities[i] * -1);                    // 최소 힙이 아닌 최대 힙 구현을 위해 값들을 -1 을 곱해서 넣는다
        }

        int cur = pq.poll() * (-1);                             // -1을 곱했었기에 다시 -1을 곱해 원상태로 돌린다.
        int count = 0;
        while(!q.isEmpty()) {
            int[] t = q.poll();
            if(t[1] != cur) {                                   // 남아있는 가장 큰 우선순위값인지 분기
                q.offer(t);
                continue;
            }

            if(t[0] != location) {                              // 찾는 index와 동일 여부 확인 분기
                count++;
                cur = pq.poll() * (-1);
            } else {                                            // 찾은 경우 반복문 중단 후 결과값 출력
                count++;
                break;
            }
        }

        return count;
    }
}
