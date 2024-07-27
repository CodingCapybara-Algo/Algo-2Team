package week_2.skwent77;

public class PGS_올바른괄호 {
    public boolean solution(String s) {
        int count = 0; //count: 괄호의 균형을 맞추기 위한 변수
        for (int i = 0; i < s.length(); i++) {

            /* 내가 채택한 방식은 Sol2.
            Sol1. 스택을 이용한 풀이
            이 문제는 스택(Stack) 문제이다.
                만약 입력값이 (())()라고 할 때, Stack에 요소를 하나씩 push한다.
                그러다가 Stack에 ()가 생기면, pop해준다.

                push [(] → push [(,(] → push [ (,(,) ] → pop [(] → push [(,)] → pop [] → push [(] → push [(,)] → pop []

                마지막에 스택에 아무것도 남지 않으면 true
                스택에 요소가 남아있으면 false를 리턴해야 한다.
            Sol2. 스택의 원리를 이용하지만 스택을 사용하지는 않는 풀이
             */

            if (s.charAt(i ) == '(')
            {  // 여는 괄호일 경우 /count에 1 증가시킨다.

                count++;
                //('인 경우:
                //
                //count를 1 증가시킵니다.
                //열린 괄호가 하나 더 추가되었음을 의미합니다.
            } else
            { //)'인 경우:

//                count를 1 감소시킵니다.
//                    닫힌 괄호가 하나 추가되었음을 의미합니다.

                count--;
            }
            //중간에 count가 음수인 경우:

         // 닫힌 괄호가 열린 괄호보다 먼저 나오는 경우입니다. 밑의 예시 3 참고 바람 이 경우는 올바른 괄호 문자열이 될 수 없으므로 false를 반환합니다.
            if (count < 0)
            {
                return false;
            }
        }
        return count == 0;
    }
/*예시 2: s = "(())"
초기 상태:
count = 0
첫 번째 문자 '(':
count++ -> count = 1
두 번째 문자 '(':
count++ -> count = 2
세 번째 문자 ')':
count-- -> count = 1
네 번째 문자 ')':
count-- -> count = 0
문자열 순회 종료 후:
count == 0 -> true 반환
예시 3: s = "(()" (올바르지 않은 경우)
초기 상태:
count = 0
첫 번째 문자 '(':
count++ -> count = 1
두 번째 문자 '(':
count++ -> count = 2
세 번째 문자 ')':
count-- -> count = 1
문자열 순회 종료 후:
count != 0 -> false 반환
*/
}
