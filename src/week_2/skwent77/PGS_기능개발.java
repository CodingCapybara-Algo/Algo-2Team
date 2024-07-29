package week_2.skwent77;
//bridge length 1 10000
// weight
//truck weight
import java.util.ArrayList;
import java.util.Arrays;

public class PGS_기능개발 {
    static int sol[];
    public static void main(String[] args) {
        // 테스트 케이스: 초기 진행률과 각각의 속도
        int[] progresses=new int[]{95, 90, 99, 99, 80, 99};
        int[] speeds =new int[]{1, 1, 1, 1, 1, 1};
        System.out.println(Arrays.toString(solution(progresses, speeds)));

    }
    public static int[] solution(int[] progresses, int[] speeds) {

        ArrayList<Integer> progressList = new ArrayList<>();
        //progressList는 큐처럼 작용하여 작업의 진행 상황을 저장하고, 완료된 작업은 FIFO (First In, First Out) 방식으로 처리
        ArrayList<Integer> ans = new ArrayList<>();
        // 각 작업의 속도를 저장할 변수
        ArrayList<Integer> speed = new ArrayList<>();
        // progresses 배열을 ArrayList로 변환
        for (int i : progresses) {
            progressList.add(i);
        }
        //speed 배열을 Arraylist로 변환
        for (int i : speeds) {
            speed.add(i);
        }

//        가장 앞의 작업이 완료되었는지 확인하고, 완료된 작업을 제거합니다.
        while(!progressList.isEmpty()){
            int counter = 0;
            for( int i=0; i<progressList.size(); i++){

                int target;

                target =  progressList.get(i) +speed.get(i);
                progressList.set(i ,target);

            }
            // 큐의 가장 앞에 있는 작업부터 확인
            for( int i=0;i < progressList.size(); i++){

                if(progressList.get(i) >= 100) {
            // 가장 앞의 작업이 완료되었으면 큐에서 제거 (FIFO 방식)
                    progressList.remove(i);
                    speed.remove(i);
                    counter++;
                    i-=1;
                }else{
                    break; // 맨 앞의 작업만 제거할 수 있으므로 더 이상 확인하지 않음
                }

            }
            // 이번 반복에서 완료된 작업이 있으면 ans 리스트에 추가
            if (counter > 0) {
                ans.add(counter);
            }

        }
         // ans 리스트를 배열로 변환하여 반환
        sol = new int[ans.size()];
        for(int i=0;i< ans.size();i++) {
            sol[i] = ans.get(i);
        }
        return sol;

        }


 }