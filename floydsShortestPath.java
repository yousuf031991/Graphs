package floydsShortestPath;

import java.util.Scanner;

public class Solution {
	public static void floyds(int graph[][]) {
		int n = graph.length;
		int dp[][][] = new int[n + 1][n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				dp[0][i][j] = graph[i][j];
			}
		}
		for (int k = 1; k <= n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					dp[k][i][j] = Math.min(dp[k - 1][i][j],
							(dp[k - 1][i][k - 1] + dp[k - 1][k - 1][j]));
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.println(dp[n][i][j]);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no.of vertices");
		int n = sc.nextInt();
		int graph[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				graph[i][j] = sc.nextInt();
			}
		}
		floyds(graph);
		sc.close();
	}
}
