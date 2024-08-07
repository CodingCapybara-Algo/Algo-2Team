package week_5.skwent77;
import java.util.*;
public class PGS_모의고사 {
    static int c1, c2, c3;
    static int maxCnt;

    public int[] solution(int[] answers) {
        int[] answer; // 10000개까지 가능!
        //1, 2, 3, 4, 5, 1, 2, 3, 4, 5 (5개의 반복)
        //2, 1, 2, 3, 2, 4, 2, 5, (8개의 반복)
        // 3 3 1 1 2 2 4 4 5 5 (8개의 반복)
        // 문제별로 답을 맞힌 사람
        int len = answers.length;
        int[] ans1 = {1, 2, 3, 4, 5};  // 5개의 반복
        int[] ans2 = {2, 1, 2, 3, 2, 4, 2, 5};  // 8개의 반복
        int[] ans3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};  // 10개의 반복
        for (int i = 0; i < len; i++) {

            if (ans1[i % 5] == answers[i])
                c1++;
            if (ans2[i % 8] == answers[i])
                c2++;
            if (ans3[i % 10] == answers[i])
                c3++;


        }
        // 가장 많은 정답 개수 찾기
        maxCnt = Math.max(c1, c2);
        maxCnt = Math.max(maxCnt, c3);

        // 가장 많은 정답을 맞춘 학생들 찾기
        List<Integer> answerList = new ArrayList<>();
        if (maxCnt == c1)
            answerList.add(1);
        if (maxCnt == c2)
            answerList.add(2);
        if (maxCnt == c3)
            answerList.add(3);

        // ArrayList를 배열로 변환하여 반환
        answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}

