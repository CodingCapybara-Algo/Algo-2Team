package week_3.lsh981127;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class pgs_이중우선순위큐 {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Comparator.reverseOrder());  // 자바에서는 최대 힙을 역순으로 정렬하는 식으로 구현할 수 있었다.
        PriorityQueue<Integer> minPQ = new PriorityQueue<>((o1, o2) -> o1-o2);
        int max = 0;        // 최댓값
        int min = 0;        // 최솟값
        int count = 0;      // 출력한 횟수

        for(String i : operations) {
            String[] temp = i.split(" ");
            String func = temp[0];
            int num = Integer.parseInt(temp[1]);
            switch(func) {
                case "I":
                    maxPQ.offer(num);
                    minPQ.offer(num);
                    count++;
                    break;
                case "D":
                    if(count == 0)
                        continue;
                    if(num == 1) {
                        int search = maxPQ.poll();
                        if(minPQ.contains(search)) minPQ.remove(search);            // 반대 힙에 값이 존재하는지 확인하고 값을 제거한다.
                    } else {
                        int search = minPQ.poll();
                        if(maxPQ.contains(search)) maxPQ.remove(search);

                    }
                    count--;
            }
        }

        if(!maxPQ.isEmpty()) max = maxPQ.peek();
        if(!minPQ.isEmpty()) min = minPQ.peek();


        int[] answer = {max, min};
        return answer;
    }
}
