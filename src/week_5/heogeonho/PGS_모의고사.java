package week_5.heogeonho;

import java.util.ArrayList;

public class PGS_모의고사 {
	
	/*
	 */

	public ArrayList<Integer> solution(int[] answers) {
		int[] stu1=new int[] {1,2,3,4,5};           //5개 반복
		int[] stu2=new int[] {2,1,2,3,2,4,2,5};     //8개 반복
		int[] stu3=new int[] {3,3,1,1,2,2,4,4,5,5}; //10개 반복
		//answers 현재 인덱스를 활용 & stu.length로 나눈 나머지 인덱스 활용

		int[][] stuList=new int[][] {stu1, stu2, stu3};

		ArrayList<Integer> res=new ArrayList<>();
		int cnt, stu=1;
		int max=Integer.MIN_VALUE;
		for(int[] eachStu: stuList) {
			cnt=0;
			for(int i=0; i<answers.length; i++) {
				if(answers[i]==eachStu[i%eachStu.length]) {
					cnt++;
				}
			}
			System.out.println(cnt);
			if(cnt>max){
				max=cnt;
				res.clear();
				res.add(stu);
			} else if(cnt==max) res.add(stu);
			else {};
			stu++;
		}

		System.out.println(res.toString());
		// int[] answer = {};
		return res;
	}

	public static void main(String[] args) {
	}
}

/*
테스트 1 〉	통과 (0.20ms, 76.3MB)
테스트 2 〉	통과 (0.26ms, 76.1MB)
테스트 3 〉	통과 (0.21ms, 72.9MB)
테스트 4 〉	통과 (0.30ms, 76.1MB)
테스트 5 〉	통과 (0.33ms, 74.9MB)
테스트 6 〉	통과 (0.32ms, 70.7MB)
테스트 7 〉	통과 (0.62ms, 74.9MB)
테스트 8 〉	통과 (0.34ms, 73.4MB)
테스트 9 〉	통과 (1.43ms, 71.9MB)
테스트 10 〉	통과 (0.57ms, 77.3MB)
테스트 11 〉	통과 (0.95ms, 73.8MB)
테스트 12 〉	통과 (1.27ms, 74.9MB)
테스트 13 〉	통과 (0.28ms, 72.8MB)
테스트 14 〉	통과 (1.41ms, 75.5MB)
*/
