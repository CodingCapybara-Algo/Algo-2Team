package week_2.sapientia1007;

import java.io.*;
import java.util.*;

public class PGS_올바른괄호 {
    static class Solution {
        boolean solution(String s) throws IOException {
            boolean answer = true;

            ArrayDeque<Character> st = new ArrayDeque<>();

            for (int i=0; i<s.length(); i++) {
                char inpt = s.charAt(i);

                if (st.isEmpty()) {
                    st.add(inpt);
                } else if (inpt == ')' && st.peekLast() == '(') { // )일때 스택에 (가 들어있으면, 빼버리기
                    st.pop();
                } else if (inpt == ')' && st.isEmpty()) { // )일때 비어있으면 false
                    answer = false;
                    break;
                } else if (inpt == '('){ // (일때는 스택에 추가
                    st.add(inpt);
                }
            }
            if (st.size() != 0) answer = false; // 스택이 비어있지 않으면 괄호가 맞지 않는 것 -> false
            return answer;
        }
    }
    public static void main(String[] args) throws Exception {
        Solution s = new Solution();
        System.out.println(s.solution("()()")); // true
        System.out.println(s.solution("(())()")); // true
        System.out.println(s.solution(")()(")); // false
        System.out.println(s.solution("(()(")); // false

    }

}