package week_2.skwent77;

import java.util.LinkedList;
import java.util.Queue;

public class PGS_주식가격 {
    public int[] solution(int[] prices){
//        int size = prices.length;
//        int[] answer = new int[size];
//        for(int i=0; i<size; i++){
//            int count=0;
//            for(int j=i+1; j<size; j++){
//                if(prices[i]>prices[j]){
//                    count++;
//                    break;
//                }
//                count++;
//            }
//            answer[i] = count;
//        }
//        return answer;
        int s = prices.length;
        int[] result = new int[s];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int idx = stack.pop();
                result[idx] = i - idx;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int idx = stack.pop();
            result[idx] = s - idx - 1;
        }

        return result;
    }

/* 예시
prices = [1, 2, 3, 2, 3]
index:   0  1  2  3  4

Stack and answer computation:

Step 1:
stack: [0]
answer: [0, 0, 0, 0, 0]

Step 2:
stack: [0, 1]
answer: [0, 0, 0, 0, 0]

Step 3:
stack: [0, 1, 2]
answer: [0, 0, 0, 0, 0]

Step 4:
stack: [0, 3]
answer: [0, 2, 1, 0, 0]

Step 5:
stack: [0, 3, 4]
answer: [4, 1, 1, 1, 0]
*/


    public static void main(String[] args) throws Exception{
        int[] prices = {1,2,3,2,3};
        // 가격이 떨어지지 않은 기간
        int[] answer = new int[prices.size()];
        int[] answer
        solution(prices);

/* 끝났을 때 stack이 비어있지 않음

- stack에 남아있는 인덱스들은 끝까지 가격이 떨어지지 않음을 의미
- answer[4] = 4 - 4 = 0
- answer[3] = 4 - 3 = 1
- answer[0] = 4 - 0 = 4

### 최종 결과

- answer = [4, 1, 1, 1, 0]
*/

    }
}
