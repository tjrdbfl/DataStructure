package baekjoonGraphDFSandBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon1260 {
    static int N,M,V;
    static int[][] arr;
    static boolean[] check;
    static StringBuilder sb=new StringBuilder();
    static Queue<Integer> q=new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arr=new int[N+1][N+1];
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int row=Integer.parseInt(st.nextToken());
            int column=Integer.parseInt(st.nextToken());

            arr[row][column]=arr[column][row]=1;
        }

        check=new boolean[N+1];
        dfs(V);
        sb.append("\n");

        check=new boolean[N+1];
        bfs(V);
        System.out.println(sb);

    }

    private static void bfs(int v) {
        q.add(v);
        check[v]=true;

        while(!q.isEmpty()){
            v=q.poll();
            sb.append(v+" ");

            for(int i=1;i<=N;i++){
                if(!check[i] && arr[v][i]==1){
                    q.add(i);
                    check[i]=true;
                }
            }
        }
    }

    private static void dfs(int v) {
        check[v]=true;
        sb.append(v+" ");

        for(int i=1;i<=N;i++){
            if(!check[i] && arr[v][i]==1)
                dfs(i);
        }
    }

}
