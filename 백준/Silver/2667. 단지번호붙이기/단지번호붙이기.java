import java.io.*;
import java.util.*;

/**
 * 모든 점을 이동하면서 해당 칸의 숫자가 0인지, 방문 기록이 있는지  확인
 * 이동 가능한 점이면 해당 점부터 bfs or dfs 실행
 * 탐색이 끝나면 count를 1 추가
 * 다음 이동 가능한 점에서 탐색을 실행하면서 count로 숫자 변경
 *
 * 시간 복잡도
 * 최소 5x5 에서 25 x 25 배열이 만들어짐
 * 모든 점을 순회하는 횟수는 최대 625회 발생
 * 625개의 점 중에서도 숫자가 1인 점과 방문 처리가 안된 점만 방문하기에 625 * N번
 * 따라서 시간 복잡도는 O(N) 예상
 */
public class Main {
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {-1, 1, 0, 0};
    static int[][] graph;
    static boolean[][] visited;

    static int searchDfsCount = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int max = Integer.parseInt(br.readLine());

        List<Integer> apartmentCnts = new ArrayList<>();

        // 배열 초기화
        graph = new int[max][max];
        visited = new boolean[max][max];

        for (int i = 0; i < max; i++) {
            // String 타입 배열로 형 변환
            String[] array = br.readLine().split("");

            // graph 생성
            for (int j = 0; j < array.length; j++) {
                graph[i][j] = Integer.parseInt(array[j]);
            }
        }

        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max; j++) {
                // 방문 기록이 없고 1인 지점인 경우
                if (!visited[i][j] && graph[i][j] == 1) {
                    // 이웃 집 갯수 총합 추가
//                    apartmentCnts.add(bfs(i, j, max));
                    
                    dfs(i,j,max);
                    apartmentCnts.add(searchDfsCount);
                    searchDfsCount = 1;
                }
            }
        }

        bw.write(apartmentCnts.size() + "\n");

        Collections.sort(apartmentCnts);
        
        for (int i = 0; i < apartmentCnts.size(); i++) {
            bw.write(apartmentCnts.get(i) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int x, int y, int max) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx >= 0 && ny >= 0 && nx <= max - 1 && ny <= max - 1) {
                if (!visited[nx][ny] && graph[nx][ny] == 1) {
                    searchDfsCount++;
                    dfs(nx, ny, max);
                }
            }
        }
    }

    static int bfs(int x, int y, int max) {
        Queue<Integer[]> queue = new LinkedList<>();

        // x, y, 이동 횟수 배열
        queue.offer(new Integer[]{x, y, 1});

        // 이웃 수 총합 변수
        int searchCount = 0;

        // 시작점 방문 처리
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            // 현재 X, Y, 이동 횟수
            int cx = now[0];
            int cy = now[1];
            int num = now[2];

            // 이웃 수 갱신
            searchCount++;

            // 상 하 좌 우 탐색
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (ny >= 0 && nx >= 0 && nx <= max - 1 && ny <= max - 1) {
                    // 이전 문제와 달리 좌표를 프로그래밍 방식처럼 사용하고 있기에 y와 x의 위치를 바꾸지 않고 그대로 사용
                    if(!visited[nx][ny] && graph[nx][ny] != 0){
                        // x,y, 이웃 수 추가
                        queue.offer(new Integer[]{nx,ny,num + 1});

                        // 방문 기록
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return searchCount;
    }
}

