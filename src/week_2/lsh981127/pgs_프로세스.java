package week_2.lsh981127;

import java.util.*;
public class pgs_프로세스 {
    public int solution(int[] priorities, int location) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < priorities.length; i++) {
            q.offer(new int[]{i, priorities[i]});
            pq.offer(priorities[i] * -1);
        }

        int cur = pq.poll() * (-1);
        int count = 0;
        while(!q.isEmpty()) {
            int[] t = q.poll();
            if(t[1] != cur) {
                q.offer(t);
                continue;
            }
            if(t[0] != location) {
                count++;
                cur = pq.poll() * (-1);
            } else {
                count++;
                break;
            }
        }

        return count;
    }
}
