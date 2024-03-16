package baekjoonBinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int left = 0;
        int right = arr[n-1]-arr[0];
        int result=0;

        while(left<=right){
            int mid=(left+right)/2;
            int prevHouse=arr[0];
            int cnt=1;

            for(int i=1;i<n;i++){
                int distance=arr[i]-prevHouse;
                if(distance>=mid){
                    prevHouse=arr[i];
                    cnt++;
                }
            }
            if(cnt>=c){
                result=mid;
                left=mid+1;
            }else right=mid-1;
        }
        System.out.println(result);
    }
}
