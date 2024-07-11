package week_2.lsh981127;

import java.util.Stack;

public class pgs_올바른관호 {
    public class Solution {
        public int[] solution(int []arr) {
            Stack<Integer> st = new Stack<>();
            st.push(arr[0]);
            for(int i = 1; i < arr.length; i++) {

                int temp = st.pop();
                if(temp == arr[i]) {
                    st.push(temp);
                } else {
                    st.push(temp);
                    st.push(arr[i]);
                }

            }
            int[] result = new int[st.size()];
            for(int i = st.size(); i > 0; i--) {
                result[i-1] = st.pop();
            }
            return result;

        }
    }
}
