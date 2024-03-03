package baekjoonStack;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Baekjoon1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        String str=br.readLine();
        Stack<Character> originalStack=new Stack<>();
        Stack<Character> tempStack=new Stack<>();
        str.chars().forEach(c -> originalStack.push((char) c));

        int n=Integer.parseInt(br.readLine());

        while(n-->0){
            String command= br.readLine();
            switch (command.charAt(0)){
                case 'P':
                    originalStack.push(command.charAt(2));
                    break;
                case 'L':
                    if(!originalStack.empty())
                        tempStack.push(originalStack.pop());
                    break;
                case 'D':
                    if(!tempStack.empty())
                        originalStack.push(tempStack.pop());
                    break;
                case 'B':
                    if(!originalStack.empty())
                        originalStack.pop();
                    break;
            }
        }

        while(!originalStack.empty())
            tempStack.push(originalStack.pop());
        while(!tempStack.empty())
            bw.write(tempStack.pop());

        bw.flush();
        bw.close();
    }
}
