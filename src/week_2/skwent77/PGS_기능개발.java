package week_2.skwent77;
//bridge length 1 10000
// weight
//truck weight
import java.util.ArrayList;
import java.util.Arrays;

public class PGS_기능개발 {
    static int sol[];
    public static void main(String[] args) {
        int[] progresses=new int[]{95, 90, 99, 99, 80, 99};
        int[] speeds =new int[]{1, 1, 1, 1, 1, 1};
        System.out.println(Arrays.toString(solution(progresses, speeds)));

    }
    public static int[] solution(int[] progresses, int[] speeds) {

        // 리스트를 큐처럼 활용
        ArrayList<Integer> progressList = new ArrayList<>();

        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer> speed = new ArrayList<>();
        // progresses 배열을 ArrayList로 변환
        for (int i : progresses) {
            progressList.add(i);
        }

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

            for( int i=0;i < progressList.size(); i++){

                if(progressList.get(i) >= 100) {

                    progressList.remove(i);
                    speed.remove(i);
                    counter++;
                    i-=1;
                }else{
                    break;
                }

            }
            if (counter > 0) {
                ans.add(counter);
            }

        }
        sol = new int[ans.size()];
        for(int i=0;i< ans.size();i++) {
            sol[i] = ans.get(i);
        }
        return sol;

        }
//
//        // 이미 완료된 작업 확인 및 제거
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i) >= 100) {
//                list.remove(i);
//                speed.remove(i);
//                counter++;
//                i = -1;  // 루프를 다시 시작
//            } else {
//                break;
//            }
//        }

 }