package BaekjoonStack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.StringTokenizer;

public class Baekjoon10828 {
    public static int[] stack;
    public static int size;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        StringTokenizer st;

        int n=Integer.parseInt(br.readLine());
        stack=new int[n];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine()," ");

            switch (st.nextToken()){
                case "push":push(Integer.parseInt(st.nextToken()));break;
                case "pop":sb.append(pop()).append('\n');break;
                case "size":sb.append(size()).append('\n');break;
                case "empty":sb.append(empty()).append('\n');break;
                case "top":sb.append(top()).append('\n');break;
            }
        }
        System.out.println(sb);

    }
    public static void push(int n){
        stack[size++]=n;
    }
    public static int pop(){
        if(size==0) return -1;
        else{
            int result=stack[size-1];
            stack[size-1]=0;
            size--;
            return result;
        }
    }
    public static int size(){
        return size;
    }
    public static int empty(){
        if(size==0) return 1;
        else return 0;
    }
    public static int top(){
        if(size==0) return -1;
        else return stack[size-1];
    }
}
