package week_5.skwent77;

public class PGS_카펫 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int tot;
        tot= brown+yellow ;
        int w=0,h=0;
        //w>=3인 홀수 , h >=3 h는 꼭 홀수 x
        // prod = w*h  ===tot
        for ( int i =3;i<= Math.sqrt(tot); i++){

            if( tot%i==0  )  {
                h = i;
                w= tot/h;
                //카펫의 테두리는 모두 갈색 격자로 되어 있고, 그 안에 노란색 격자가 포함되어야 함 아래 라인 생각에 시간 걸림
                if ((w - 2) * (h - 2) == yellow) {
                    return new int[]{w, h};
                }
            }
        }
        answer[0]=w;
        answer[1]=h;
        return answer;
    }
}
//회고 w와 h기준을 잘못잡아서 풀었음, 개인적으로 오래 걸린 문제
/*
테스트 1 〉	통과 (0.02ms, 72.8MB)
테스트 2 〉	통과 (0.03ms, 74.3MB)
테스트 3 〉	통과 (0.06ms, 71MB)
테스트 4 〉	통과 (0.02ms, 76.5MB)
테스트 5 〉	통과 (0.03ms, 73.3MB)
테스트 6 〉	통과 (0.04ms, 84.2MB)
테스트 7 〉	통과 (0.07ms, 77.2MB)
테스트 8 〉	통과 (0.11ms, 74.8MB)
테스트 9 〉	통과 (0.12ms, 71.1MB)
테스트 10 〉	통과 (0.10ms, 81.9MB)
테스트 11 〉	통과 (0.04ms, 75.8MB)
테스트 12 〉	통과 (0.10ms, 76.2MB)
테스트 13 〉	통과 (0.03ms, 72.7MB)
    */