package week_2.lsh981127;
import java.util.*;
public class pgs_같은숫자는싫어 {
    public int[] solution(int []arr) {
        Stack<Integer> st = new Stack<>();
        st.push(arr[0]);                        // 시작값을 넣어주고 시작
        for(int i = 1; i < arr.length; i++) {
            int temp = st.pop();                // 제일 마지막에 들어온 값을 꺼낸다.
            if(temp == arr[i]) {                // 꺼낸 값과 현재 index의 값이 같다면 기존 값만 push
                st.push(temp);
            } else {                            // 다르다면 기존값과는 다른 값이므로 기존값 - 새로운 값 순서로 push
                st.push(temp);
                st.push(arr[i]);
            }

        }

        int[] result = new int[st.size()];
        for(int i = st.size(); i > 0; i--) {    // stack을 배열로 전환
            result[i-1] = st.pop();
        }
        return result;

    }
}
