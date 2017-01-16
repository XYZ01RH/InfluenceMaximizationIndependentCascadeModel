/**
 * 
 */
import java.util.*;

public class Graph {

	double adj[][];
	int n;
	
	public Graph(int n) {
		this.n = n;
		adj = new double[n][n];
	}
	
	public void setGraph(int u, int v, double p) {
		adj[u][v] = p;
	}
	
	public double getP(int u, int v) {
		return adj[u][v];
	}
 		
	public double f(boolean[] s){
		int T = 40000;
		double reachable = 0;
		for (int i = 0; i < T; i++) {
			boolean[] visited = s.clone();
			Stack<Integer> stk = new Stack<Integer>();
			for(int j = 0; j < s.length; j++) {
				if(s[j] == true) {
					stk.push(j);
					reachable++;
				}
			}
			
			while(!stk.isEmpty()){
				int current = (int) stk.pop();
				for(int l = 0; l < s.length; l++){
					if(visited[l] == false && Math.random() < adj[current][l]) {
						visited[l] = true;
						stk.push(l);
						reachable++;
					}
				}
			}
			
		} return reachable / T;
	}
}
