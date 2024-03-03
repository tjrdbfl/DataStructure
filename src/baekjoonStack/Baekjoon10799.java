package baekjoonStack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stack=new Stack<>();
        int total=0;

        String str= br.readLine();

        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='(') {
                stack.push('(');
                continue;
            }
            if(str.charAt(i)==')'){
                stack.pop();
                if(str.charAt(i-1)=='(')
                    total+=stack.size();
                else
                    total++;
            }
        }
        System.out.println(total);
    }
}