package week_2.sapientia1007;

import java.io.*;
import java.util.*;


public class PGS_다리를지나는트럭 {
    static class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            int answer = 0;
            int totalWeightOnBridge = 0; // 다리 위 무게
            int index = 0;

            ArrayDeque<Integer> bridge = new ArrayDeque<>(); // 다리 위 트럭을 관리
            ArrayDeque<Integer> times = new ArrayDeque<>(); // 트럭이 다리를 완전히 지나가는 시간 기록

            while (index < truck_weights.length || !bridge.isEmpty()) {
                answer++;

                // 다리에서 트럭이 나가는 경우 => times의 가장 앞의 시간 기록이 현재 시간이라면,
                // 해당 times 값 빼고, 전체 트럭 무게에서 해당 트럭 무게 제외
                if (!times.isEmpty() && times.peek() == answer) {
                    times.poll();
                    totalWeightOnBridge -= bridge.poll();
                }

                // 새로운 트럭이 다리에 올라가는 경우 => 해당 인덱스의 트럭이 현재 다리를 지날 수 있다면
                if (index < truck_weights.length && totalWeightOnBridge + truck_weights[index] <= weight) {
                    bridge.add(truck_weights[index]);
                    totalWeightOnBridge += truck_weights[index]; // 현재 다리 위 트럭 무게 계산
                    times.add(answer + bridge_length); // 트럭이 다리를 완전히 건너는 시간 기록
                    index++;
                }
            }

            return answer;
        }
    }


    public static void main(String[] args) throws Exception {
        Solution s = new Solution();
        System.out.println(s.solution(2, 10, new int[] {7,4,5,6})); // 8
        System.out.println(s.solution(100, 100, new int[] {10})); // 101
        System.out.println(s.solution(100, 100, new int[] {10,10,10,10,10,10,10,10,10,10})); // 110
    }
}
