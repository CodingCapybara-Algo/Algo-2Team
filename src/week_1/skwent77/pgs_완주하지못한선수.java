package week_1.skwent77;

import java.util.Arrays;

public class pgs_완주하지못한선수 {

    class Solution {
        public String solution(String[] participant, String[] completion) {
            String answer = "";
            Arrays.sort(participant);
            Arrays.sort(completion);

            int i;
            for (i = 0; i < completion.length; i++) {
                if (!participant[i].equals(completion[i])) {
                    break;
                }
            }

            answer = participant[i];
            return answer;
        }
    }
}