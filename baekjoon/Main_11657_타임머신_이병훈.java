import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 벨만포드 알고리즘
 * 단일 시작점 최단경로 알고리즘 - 음의 가중치 가능
 * */
public class Main_11657_타임머신_이병훈 {

	static int count, edgeCount;
	static final int INF = 9999999;
	static int[] distance;
	static Edge[] edges;

	static class Edge {
		int from, to, time;

		public Edge(int from, int to, int time) {
			this.from = from;
			this.to = to;
			this.time = time;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		count = Integer.parseInt(st.nextToken());
		edgeCount = Integer.parseInt(st.nextToken());
		distance = new int[count];// 1번 도시에서 각 도시로 오는 최소시간
		edges = new Edge[edgeCount];

		Arrays.fill(distance, INF);
		for (int i = 0; i < edgeCount; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			edges[i] = new Edge(Integer.parseInt(st.nextToken())-1,
								Integer.parseInt(st.nextToken())-1,
								Integer.parseInt(st.nextToken()));
		}
		distance[0] = 0; // 시작점은 0
		if(goNegativeCycle()) {
			System.out.println(-1);
		}else {
			for(int d=1; d<count;++d) {
				System.out.println(distance[d]==INF? -1: distance[d]);
			}
		}

	}

	private static boolean goNegativeCycle() {
		for (int i = 1; i <= count; ++i) {
			for(Edge e : edges) { // from -> to
				if(distance[e.from]==INF) continue; // 갱신이 한번도 안됐으면 continue;
				if(distance[e.from]+e.time < distance[e.to]) {
					distance[e.to] = distance[e.from]+e.time;
					if(i==count) return true; // V 번째에도 값이 갱신되면 -싸이클
				}	
			}
		}
		return false;
	}

}
