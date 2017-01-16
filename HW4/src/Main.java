import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * 
 */

/**
 * @author rileyZ
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File output = new File("im.txt");
		String input = null;
		String line = null;
		String regex = " ";
		double[][] adj;
		int k;
		ArrayList<Integer> seeds;
		int u = 0;
		int v = 0;
		double p = 0.0;
		
		if(args[0] != null) {
			input = args[0];
			BufferedReader br;

			try {
				br = new BufferedReader(new FileReader (input));
				line = br.readLine();
				String str[] = line.split(regex);
				int n = Integer.parseInt(str[0]);
				Graph g = new Graph(n);
				adj = new double[n][n];
				int m = Integer.parseInt(str[1]);
				k = Integer.parseInt(str[2]);	
				
				
				for(int i = 0; i < m; i++) {
					line = br.readLine();
					str = line.split(regex);
					//Node[] nodes = g.getNodes();
					u = Integer.parseInt(str[0]) - 1;
					v = Integer.parseInt(str[1]) - 1;
					p = Double.parseDouble(str[2]);
					g.setGraph(u, v, p);
					
				}
//				String str = "";
//				for(int i = 0; i < adj.length; i++) {
//					for(int j = 0; j < adj.length; j++) {
//						s+= "[" + adj[i][j] +"] ";
//					}
//					s+= "\n";
//				}
				
				//System.out.println(s);
				
				boolean[] s = new boolean[n];
				for(int i = 0; i < k; i++) {
					int bestV = -1;
					double bestD = -1;
					boolean[] s1 = s.clone();
					for(int v1 = 0; v1 < n; v1++) {
						if(!s[v1]) {
							s1[v1] = true;
							double dV = g.f(s1) - g.f(s);
							if (dV > bestD) {
								bestV = v1;
								bestD = dV;
							}
							s1[v1] = false;
						}
					} 
					s[bestV] = true;
				}
				
				PrintWriter pw = new PrintWriter(output);
				for (int t = 0; t < n; t++) {
					if(s[t] == true) {
						pw.print(t+1 +" ");
					}
				}
				pw.println();
				pw.println(g.f(s));
				pw.close();
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
