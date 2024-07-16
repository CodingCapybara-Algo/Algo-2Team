package week_2.lsh981127;

import java.util.*;

public class pgs_다리를지나는트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        ArrayDeque<Integer> q= new ArrayDeque<>();              // 다리의 상황을 표현하기 위한 덱
        for(int i = 0; i < bridge_length; i++) q.offer(0);   // 비어있는 다리를 표현하기 위해 0으로 초기화

        int cur_weight = 0;                                     // 현재 다리 위 차들의 무게
        int cur_trucks = 0;                                     // 현재 다리 위 트럭 갯수
        int cur_index = 0;                                      // 들어오는 트럭(truck_weights) index
        int answer = 0;                                         // 최소 시간 기록용 변수
        while(!q.isEmpty()){
            int truck = q.poll();
            if (truck != 0) {                                   // 트럭이 다리를 다 지나가는 경우
                cur_weight -= truck;        // 트럭 무게만큼 차감
                cur_trucks -= 1;            // 트럭 갯수 1 감소
            }
            if(cur_weight + truck_weights[cur_index] <= weight && cur_trucks + 1 <= bridge_length){     // 다음 들어오는 트럭이 최대 무게와 트럭 갯수를 잘 지키는지 확인 분기
                q.offer(truck_weights[cur_index]);
                cur_weight += truck_weights[cur_index];
                cur_trucks += 1;
                cur_index++;
                if(cur_index == truck_weights.length) {                         // 마지막 트럭이 들어온 경우
                    answer += bridge_length + 1;
                    break;
                }
            } else {                                                            // 트럭이 들어오지 못하는 상황이면 0을 그냥 넣는다.
                q.offer(0);
            }
            answer++;                                                           // 시간 증가
        }
        return answer;
    }
}
