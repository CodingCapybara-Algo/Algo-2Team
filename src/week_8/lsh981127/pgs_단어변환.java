package week_8.lsh981127;

import java.util.*;

public class pgs_단어변환 {

    public int solution(String begin, String target, String[] words) {
        ArrayDeque<String> dq = new ArrayDeque<>();
        Set<String> set = new HashSet<>(Arrays.asList(words));

        int count = 0;
        if(!set.contains(target)) return count;

        dq.offer(begin);
        set.remove(begin);

        // BFS 방식
        // 사용가능한 단어들을 Set에 보관해서, 그때그때 1자리만 차이가 난다면 해당 단어를 큐에 넣고 탐색



        while(!dq.isEmpty()) {
            for(int i = 0; i < dq.size(); i++) {
                // dq에 남아있는 애들 중, set에 있는 애들과 1개밖에 차이 안나는 애들을 찾아야함
                String temp = dq.poll();
                if(temp.equals(target)) return count;


                for(String word : set.toArray(new String[set.size()])) {
                    int diff = 0;
                    for(int j = 0; j < word.length(); j++) {
                        if(word.charAt(j) != temp.charAt(j)) diff++;
                    }

                    if(diff == 1) {
                        dq.offer(word);
                        set.remove(word);
                    }
                }
            }
            count++;

        }
        return count;
    }
}

/**
 * 정확성  테스트
 * 테스트 1 〉	통과 (0.13ms, 70.9MB)
 * 테스트 2 〉	통과 (0.17ms, 74.8MB)
 * 테스트 3 〉	통과 (0.43ms, 71.3MB)
 * 테스트 4 〉	통과 (0.14ms, 72.6MB)
 * 테스트 5 〉	통과 (0.13ms, 74.3MB)
 */