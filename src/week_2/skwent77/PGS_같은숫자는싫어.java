package week_2.skwent77;

import java.util.*;

public class PGS_같은숫자는싫어 {
    public int[] solution(int []arr) {
        int[] answer = {};
        ArrayList<Integer> result = new ArrayList<>();
        /*
          for 루프를 사용하여 배열 arr를 순회합니다.
            현재 원소 arr[i]와 다음 원소 arr[i+1]를 비교합니다.
            두 원소가 다르면 result 리스트에 현재 원소를 추가합니다.

         */
        for(int i=0;i< (arr.length-1) ; i++){
            if( arr[i]  != arr[i+1]){
                result.add(arr[i]);
            }
            // 1 1 3. 3 0. 1(5). 1(6) size=7 , arr.length-2 => 5
            if(i==arr.length-2){
// 마지막 원소 arr[arr.length - 1]를 result 리스트에 추가합니다.
                result.add(arr[i+1]);
//
            }

        }
        //result 리스트의 크기만큼 answer 배열을 초기화합니다.
        //        for 루프를 사용하여 result 리스트의 각 원소를 answer 배열에 복사합니다.
        answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }


        return answer;
    }
}



