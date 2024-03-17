package baekjoonDivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon2630 {
    public static int blue;
    public static int white;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());
        int[][] arr=new int[n][n];

        for(int i=0;i<arr.length;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<arr[i].length;j++) {
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        countSquare(arr);
        System.out.println(white);
        System.out.println(blue);
    }

    private static void countSquare(int[][] arr) {
        boolean b=Arrays.stream(arr)
                .flatMapToInt(Arrays::stream)
                .anyMatch(num -> num == 1);
        boolean w=Arrays.stream(arr)
                .flatMapToInt(Arrays::stream)
                .anyMatch(num -> num == 0);

        if(b&&w && arr.length>1) {
            countSquare(Arrays.stream(arr,0,arr.length/2)
                    .map(row->Arrays.copyOfRange(row,0,arr.length/2))
                    .toArray(int[][]::new));
            countSquare(Arrays.stream(arr,arr.length/2,arr.length)
                    .map(row->Arrays.copyOfRange(row,0,arr.length/2))
                    .toArray(int[][]::new));
            countSquare(Arrays.stream(arr,0,arr.length/2)
                    .map(row->Arrays.copyOfRange(row,arr.length/2,arr.length))
                    .toArray(int[][]::new));
            countSquare(Arrays.stream(arr,arr.length/2,arr.length)
                    .map(row->Arrays.copyOfRange(row,arr.length/2,arr.length))
                    .toArray(int[][]::new));
        }else{
            if(b==true && w==false) ++blue;
            else if(w==true && b==false) ++white;
        }
    }
}

