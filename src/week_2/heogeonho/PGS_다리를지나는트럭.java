package week_2.heogeonho;

import java.util.*;
import java.io.*;

public class PGS_다리를지나는트럭 {
	
	/*
	큐를 활용 idea
	idea -> time을 기준으로 반복문 돌리기
		
		반복하면서 큐 내부 숫자의 합이  10을 넘기지 않게 돌린다
		10을 넘긴다면 0을 넣는다
		
		단 큐 사이즈가 다리 길이보다 커지지 않아야 하고
		사이즈가 꽉 찬 경우 값을 빼는 과정을 진행한다. (동시에 값 넣기도 수행해야 함)
	
	그렇게 반복해서 0이 아닌 수들은 결과 체크를 위한 cnt변수에 +1을 한다
	cnt가 트럭의 수만큼 차게되면 지금 반복했던 time을 리턴한다.
	 */
	
	/* 회고
	단순히 큐를 사용하는 것에 그치지 않고 
	코드를 어떻게 더 직관적으로 짤 수 있을지 고려해야 한다
	클래스와 자료구조를 적극 활용하는 능력이 부족하다
	함수, 클래스를 적재적소에 활용하기 위해 고민하는 시간을 가져야 할 것 같다.
	 */
	
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
    	ArrayDeque<Integer> q=new ArrayDeque<>();
    	q.offer(0);
    	int totalWeight=0;
    	int time=0;
    	int cnt=0; // 트럭이 전부 돌아왔는지 파악하기 위한 것
    	int num=0; // 어떤 인덱스의 트럭이 사용되는지 넣는 것
    	while(true) {
    		time++;
    		if(num<truck_weights.length) {
    			if(q.size()<bridge_length) {
    				if(totalWeight+truck_weights[num]<=weight) {
    					q.offer(truck_weights[num]);
    					totalWeight+=truck_weights[num];
    					num++;
    				} else q.offer(0);
    			} 
    			
    			else if(q.size()==bridge_length) {
    				int k=q.poll();
    				totalWeight-=k;
    				if(k!=0) {
    					cnt++;
    					if(cnt==truck_weights.length) {
    						break;
    					}
    				}
    				if(totalWeight+truck_weights[num]<=weight) {
    					q.offer(truck_weights[num]);
    					totalWeight+=truck_weights[num];
    					num++;
    				} else q.offer(0);
    			}
    		}
    		
    		else if(num==truck_weights.length-1) {
    			if(q.size()<bridge_length) {
    				if(totalWeight+truck_weights[num]<=weight) {
    					q.offer(truck_weights[num]);
    					totalWeight+=truck_weights[num];
    				} else q.offer(0);
    			} 
    			
    			else if(q.size()==bridge_length) {
    				int k=q.poll();
    				totalWeight-=k;
    				if(k!=0) {
    					cnt++;
    					if(cnt==truck_weights.length) {
    						break;
    					}
    				}
    				if(totalWeight+truck_weights[num]<=weight) {
    					q.offer(truck_weights[num]);
    					totalWeight+=truck_weights[num];
    				} else q.offer(0);
    			}
    		}
    		
    		else {
    			
    			if(q.size()<bridge_length) {
    				q.offer(0);
    			} 
    			
    			else if(q.size()==bridge_length) {
    				int k=q.poll();
    				totalWeight-=k;
    				if(k!=0) {
    					cnt++;
    					if(cnt==truck_weights.length) {
    						break;
    					}
    				}
    				q.offer(0);
    			}		
    		}
    	}
        return time;
    }

	public static void main(String[] args) {
		int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
		int bridge_length = 100;
		int weight = 100;
		
		System.out.println(solution(bridge_length, weight, truck_weights));
	}

}
