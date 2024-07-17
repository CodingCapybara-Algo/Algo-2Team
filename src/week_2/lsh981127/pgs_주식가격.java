package week_2.lsh981127;

import java.util.Stack;

public class pgs_주식가격 {
    public int[] solution(int[] prices) {

        int[] answer = new int[prices.length];
        for(int i = 0; i < prices.length; i++) {
            if(i == prices.length - 1) break;
            // 제일 마지막은 더 올라가거나 내려갈 게 없어서 0
            // 그래서 바로 break를 써서 반복문을 끝낸다. (int[] default 값으로 이미 0이 들어있다.)

            int j = i;              // index 값 확인용
            while(prices[j] >= prices[i]) {     // 시작 index가 i부터이기에 탐색 범위를 계속 줄인다.
                if(j == prices.length - 1)      // 마지막 index 도달시 IndexOutOfRange 예외가 안나도록 미리 break
                    break;
                j++;
            }
            answer[i] = j - i;                  // j번째 index - i번째 index 크기만큼 감소하지 않았으므로 배열에 기록
        }
        return answer;
    }
}
