package week_2.lsh981127;

import java.util.*;

public class pgs_다리를지나는트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        ArrayDeque<Integer> q= new ArrayDeque<>();
        for(int i = 0; i < bridge_length; i++) q.offer(0);

        int cur_weight = 0;
        int cur_trucks = 0;
        int cur_index = 0;
        int answer = 0;
        while(!q.isEmpty()){
            int truck = q.poll();
            if (truck != 0) {
                cur_weight -= truck;
                cur_trucks -= 1;
            }
            if(cur_weight + truck_weights[cur_index] <= weight && cur_trucks + 1 <= bridge_length){
                // 들어올 수 있으면
                q.offer(truck_weights[cur_index]);
                cur_weight += truck_weights[cur_index];
                cur_trucks += 1;
                cur_index++;
                if(cur_index == truck_weights.length) { // 마지막 트럭이 들어간 경우
                    answer += bridge_length + 1;
                    break;
                }
            } else {
                q.offer(0);
            }

            answer++;


        }
        return answer;
    }
}
