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
            while(prices[j] >= prices[i]) {
                if(j == prices.length - 1)
                    break;
                j++;
            }
            answer[i] = j - i;

        }


        return answer;
    }
}
