package baekjoonQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon10845 {
    static int[] arr;
    static int front = 0, back = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr = new int[n];

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");

            switch (st.nextToken()) {
                case "push":
                    push(Integer.parseInt(st.nextToken()));break;
                case "pop":
                    System.out.println(pop());break;
                case "size":
                    System.out.println(size());break;
                case "front":
                    System.out.println(front());break;
                case "back":
                    System.out.println(back());break;
                case "empty":
                    System.out.println(empty());break;
            }

        }
    }

    private static int empty() {
        if(back-front==0) return 1;
        else return 0;
    }

    private static void push(int n) {
        arr[back++] = n;
    }

    private static int pop() {
        if (back-front== 0) return -1;
        else return arr[front++];
    }

    private static int size() {
        return back-front;
    }

    private static int front() {
        if (back-front==0) return -1;
        else return arr[front];
    }

    private static int back() {
        if (back-front==0) return -1;
        else return arr[back-1];
    }
}
