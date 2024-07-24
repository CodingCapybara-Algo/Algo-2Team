package week_2.skwent77;

import java.util.*;
//어진 프로세스의 우선순위를 기준으로 실행 순서를 결정하는 것입니다. 목표는 특정 프로세스가 몇 번째로 실행되는지를 구하는 것입니다.
public class PGS_프로세스 {

    public int solution(int[] priorities, int location) {
        //priority 큐와 indexQueue 큐를 사용하여 각각 우선순위와 인덱스를 저장합니다.
        ArrayDeque<Integer> priority = new ArrayDeque<>();
        ArrayDeque<Integer> indexQueue = new ArrayDeque<>();

        List<Integer> turn = new ArrayList<>();
        int printOrder =0;
        //큐에 초기값 삽입

        for (int i = 0; i < priorities.length; i++) {
            priority.offer(priorities[i]);
            indexQueue.offer(i);
        }
        /*


        isHighestPriority 변수는 현재 문서가 가장 높은 우선순위인지 확인 위함.
        만약 priority 큐에 현재 우선순위보다 높은 우선순위가 있다면 isHighestPriority를 false로 설정합니다.
        현재 문서가 가장 높은 우선순위라면:
        printOrder를 1 증가시킵니다.
        만약 currentIndex가 location과 같다면 현재 문서가 실행되므로 printOrder를 반환합니다.
         */
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
                /*재 문서가 가장 높은 우선순위가 아니라면:
                현재 문서의 우선순위와 인덱스를 큐에 다시 삽입
                 */
                priority.offer(currentPriority);
                indexQueue.offer(currentIndex);
            }
        }

        return -2;
    }ref
}
/*
예시:
예시 1: priorities = [2, 1, 3, 2], location = 2
초기 상태:

priority = [2, 1, 3, 2]
indexQueue = [0, 1, 2, 3]
printOrder = 0
첫 번째 반복:

currentPriority = 2, currentIndex = 0
priority = [1, 3, 2]
indexQueue = [1, 2, 3]
isHighestPriority = false (우선순위 3이 있음)
priority = [1, 3, 2, 2]
indexQueue = [1, 2, 3, 0]
두 번째 반복:

currentPriority = 1, currentIndex = 1
priority = [3, 2, 2]
indexQueue = [2, 3, 0]
isHighestPriority = false (우선순위 3이 있음)
priority = [3, 2, 2, 1]
indexQueue = [2, 3, 0, 1]
세 번째 반복:

currentPriority = 3, currentIndex = 2
priority = [2, 2, 1]
indexQueue = [3, 0, 1]
isHighestPriority = true (가장 높은 우선순위)
printOrder = 1
currentIndex == location이므로 1 반환
이렇게 하여 주어진 프로세스가 몇 번째로 실행되는지 확인할 수 있습
 */