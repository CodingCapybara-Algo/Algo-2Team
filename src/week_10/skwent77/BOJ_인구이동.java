package week_10.skwent77;
import java.io.*;
import java.util.*;

public class BOJ_인구이동 {

    static int N, L, R;
    static int[][] adj;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1}; // 상, 하, 좌, 우 방향
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        adj = new int[N][N];

        // 인구수 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                adj[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int days = 0;

        // 인구 이동이 발생하는 동안 반복
        while (true) {
            visited = new boolean[N][N];
            boolean isMoved = false;

            // 모든 좌표에 대해 연합을 찾고 인구 이동
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        if (bfs(i, j)) {
                            isMoved = true;  // 인구 이동이 발생했다면 true
                        }
                    }
                }
            }

            if (!isMoved) {
                break;  // 인구 이동이 더 이상 발생하지 않으면 종료
            }

            days++;  // 하루 증가
        }

        System.out.println(days);
    }

    // BFS를 이용해 연합을 찾고 인구 이동을 처리
    static boolean bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        List<int[]> union = new ArrayList<>();
        q.add(new int[]{x, y});
        union.add(new int[]{x, y});
        visited[x][y] = true;

        int sum = adj[x][y];  // 연합의 총 인구 수
        int count = 1;      // 연합을 이루는 칸의 수

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int cx = current[0];
            int cy = current[1];
            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                    int diff = Math.abs(adj[cx][cy] - adj[nx][ny]);
                    if (diff >= L && diff <= R) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                        union.add(new int[]{nx, ny});
                        sum += adj[nx][ny];
                        count++;
                    }
                }
            }
        }

        if (count > 1) {
            int newPopulation = sum / count;
            // 연합에 속한 모든 칸의 인구를 새 인구 수로 변경
            for (int[] pos : union) {
                adj[pos[0]][pos[1]] = newPopulation;
            }
            return true; // 인구 이동이 발생함
        }

        return false; // 연합이 형성되지 않음
    }
}



//메모리 298512 시간 568