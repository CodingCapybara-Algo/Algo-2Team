package week_5.lsh981127;

public class pgs_모의고사 {
    public int[] solution(int[] answers) {
        int c1 = 0, c2 = 0, c3 = 0;
        int[] a1 = {1,2,3,4,5}, a2 = {2,1,2,3,2,4,2,5}, a3 = {3,3,1,1,2,2,4,4,5,5};
        int s1 = a1.length, s2 = a2.length, s3 = a3.length;

        for(int i = 0; i < answers.length; i++) {
            if(a1[i % s1] == answers[i]) c1++;
            if(a2[i % s2] == answers[i]) c2++;
            if(a3[i % s3] == answers[i]) c3++;
        }

        int max = Math.max(c1,c2,c3);
        if(c1 != max)

        int[] result = {c1,c2,c3};
        int count = 0;
        Ararys.sort(result);

        for(int i =0; i<3;i++) {
            if(result[i] == max) {
                count++;
            }
        }

        return answer;
    }
}
