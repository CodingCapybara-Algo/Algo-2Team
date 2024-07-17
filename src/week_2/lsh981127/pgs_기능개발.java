package week_2.lsh981127;
import java.util.*;
public class pgs_기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] date = new int[progresses.length];
        // 작업에 필요한 요일 저장용 배열
        ArrayDeque<Integer> q = new ArrayDeque<>();

        for(int i = 0 ; i < progresses.length; i++) {
            // 연산 과정
            int due = 100 - progresses[i];
            int temp = due / speeds[i];
            int day = (due % speeds[i]) > 0 ? temp + 1 : temp;
            q.offer(day);
            date[i] = day;
        }

        List<Integer> re = new ArrayList<>();
        // 끝나는 작업의 갯수들을 기록하기 위한 용도


        // 긴 작업 기간을 보관하기 위한 용도
        int cur = q.poll();
        q.addFirst(cur);
        int count = 0;

        while(!q.isEmpty()) {
            int day = q.poll();
            if(cur >= day) {
                // 앞서서 더 오래 걸리는 작업이 존재하기에 크기가 작은 작업은 그냥 갯수만 측정
                count++;
                if(q.isEmpty()) {   // 마지막 날
                    re.add(count);
                }
            } else {
                // 기존 오래 걸리는 작업보다 더 오래 걸리는 작업 발생시, 완료된 작업들을 기록하고 count를 초기화해준다
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
