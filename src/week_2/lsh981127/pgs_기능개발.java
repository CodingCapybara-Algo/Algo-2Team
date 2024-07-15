package week_2.lsh981127;
import java.util.*;
public class pgs_기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] date = new int[progresses.length];
        ArrayDeque<Integer> q = new ArrayDeque<>();

        for(int i = 0 ; i < progresses.length; i++) {
            int due = 100 - progresses[i];
            int temp = due / speeds[i];
            int day = (due % speeds[i]) > 0 ? temp + 1 : temp;
            q.offer(day);
            date[i] = day;
        }

        List<Integer> re = new ArrayList<>();

        int cur = q.poll();
        q.addFirst(cur);
        int count = 0;

        while(!q.isEmpty()) {
            int day = q.poll();
            if(cur >= day) {
                count++;
                if(q.isEmpty()) {   // 마지막 날
                    re.add(count);
                }
            } else {
                cur = day;
                re.add(count);
                count = 1;
                if(q.isEmpty()) {   // 마지막 날
                    re.add(count);
                }
            }
        }

        int[] result = new int[re.size()];
        for(int i = 0; i < re.size(); i++) {
            result[i] = re.get(i);
        }
        return result;
    }
}
