package week_2.skwent77;

import java.util.*;

public class PGS_프로세스 {

    public int solution(int[] priorities, int location) {
        ArrayDeque<Integer> priority = new ArrayDeque<>();
        ArrayDeque<Integer> indexQueue = new ArrayDeque<>();

        List<Integer> turn = new ArrayList<>();
        int printOrder =0;
        for (int i = 0; i < priorities.length; i++) {
            priority.offer(priorities[i]);
            indexQueue.offer(i);
        }
        while (!priority.isEmpty()) {
            int currentPriority = priority.poll();
            int currentIndex = indexQueue.poll();
            boolean isHighestPriority = true;

            // 현재 문서가 가장 높은 우선순위인지 확인
            for (int target : priority) {
                if (target > currentPriority) {
                    isHighestPriority = false;
                    break;
                }
            }
            if (isHighestPriority) {
                printOrder+=1;
                if (currentIndex == location) {
                    return printOrder;
                }
            }else {
                priority.offer(currentPriority);
                indexQueue.offer(currentIndex);
            }
        }

        return -2;
    }
}
