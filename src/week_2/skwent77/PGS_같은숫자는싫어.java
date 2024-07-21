package week_2.skwent77;

import java.util.*;

public class PGS_같은숫자는싫어 {
    public int[] solution(int []arr) {
        int[] answer = {};
        ArrayList<Integer> result = new ArrayList<>();
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        for(int i=0;i< (arr.length-1) ; i++){
            if( arr[i]  != arr[i+1]){
                result.add(arr[i]);
            }
            // 1 1 3. 3 0. 1(5). 1(6) size=7 , arr.length-2 => 5
            if(i==arr.length-2){
                // if( arr[i] != arr[i+1]){

                result.add(arr[i+1]);

            }

        }
        answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }


        return answer;
    }
}