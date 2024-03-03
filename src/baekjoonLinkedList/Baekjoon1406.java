package baekjoonLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Baekjoon1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        List<Character> list=new LinkedList<>();
        str.chars().forEach(c -> list.add((char) c));

        int n=Integer.parseInt(br.readLine());
        int cursor=str.length();

        while(n-->0){
            String command= br.readLine();
            switch (command.charAt(0)){
                case 'P':
                    list.add(cursor,command.charAt(2));
                    cursor++;
                    break;
                case 'L':
                    if(cursor>0) cursor--;break;
                case 'D':
                    if(cursor<list.size()) cursor++;break;
                case 'B':
                    if(cursor>0) {
                        list.remove(cursor - 1);
                        cursor--;
                    }
                    break;
            }
        }
        list.forEach(i->{
            System.out.print(i.toString());
        });
    }
}
