package week_1.lsh981127;
import java.util.*;
public class pgs_완주하지못한선수 {
    public static String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < participant.length; i++) {
            if (map.containsKey(participant[i])) {
                map.put(participant[i], map.get(participant[i]) + 1);
            } else {
                map.put(participant[i], 1);
            }
        }

        for (int i = 0; i < completion.length; i++) {
            if (map.containsKey(completion[i])) {
                map.put(completion[i], map.get(completion[i]) - 1);
                if (map.get(completion[i]) == 0) {
                    map.remove(completion[i]);
                }
            }
        }

        // 1. 참가자에 대한 HashMap을 만들고
        // 2. 완주한 사람의 value값을 1씩 깎기, 해당 사람 value가 없으면 그냥 Key에서 제거
        // 3. 최종적으로 남아있는 1개의 Key를 출력
        for (String s : map.keySet()) {
            sb.append(s);
        }

        return sb.toString();
    }
}
