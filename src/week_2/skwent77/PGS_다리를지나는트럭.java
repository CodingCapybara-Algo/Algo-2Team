package week_2.skwent77;
import java.util.*;

//트럭 여러 대가 일차선 다리를 정해진 순으로 건너

//weight 견디되 시간 짧게 문제 이해

public class PGS_다리를지나는트럭 {

   public static int solution(int[] truck_weights,int bridge_length, int weight){
       ArrayList<Integer> bridge = new ArrayList<>();

       int time = 0, totalWeight = 0, index = 0;

       // 초기 다리 상태를 0으로 채움
       for (int i = 0; i < bridge_length; i++) {
           bridge.add(0);
       }

       while (index < truck_weights.length) {
           // 다리의 맨 앞의 트럭(또는 0)을 제거
           totalWeight -= bridge.remove(0);

           // 새로운 트럭이 다리에 올라갈 수 있는지 확인
           if (totalWeight + truck_weights[index] <= weight) {
               bridge.add(truck_weights[index]);
               totalWeight += truck_weights[index];
               index++;
           } else {
               bridge.add(0); // 트럭이 올라갈 수 없으면 0을 추가하여 대기
           }

           time++;
       }

       // 모든 트럭이 다리를 건너기 위해 추가로 필요한 시간을 더함
       return time + bridge_length;


   }
    public static void main(String[] args) {
        int answer =0;
        int[] truck_weights = new int[]{7,4,5,6};
        int weight = 10;
        int bridge_length =2;
    // 모든 트럭이 다리 건너는데 최소 몇초


        answer = solution(truck_weights,2,10);

        System.out.println(answer);

    }

}
