package baekjoonDivideAndConquer;

import java.io.*;
import java.util.*;

public class Baekjoon2261 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        ArrayList<Point> arrList = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arrList.add(new Point(x, y));
        }
        Collections.sort(arrList, (p1, p2) -> p1.x - p2.x);

        bw.write(divCon(arrList, 0, N - 1) + "\n");
        br.close();
        bw.close();
    }

    public static int getDist(Point p, Point q) {
        return (p.x - q.x) * (p.x - q.x) + (p.y - q.y) * (p.y - q.y);
    }

    static int bruteForce(ArrayList<Point> arrList, int start, int end) {
        int minDist = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            for (int j = i + 1; j <= end; j++) {
                int k = getDist(arrList.get(i), arrList.get(j));
                minDist = Math.min(k, minDist);
            }
        }

        return minDist;
    }


    private static int bruteForce(List<Point> arrList, int start, int end) {
        int minDist = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            for (int j = i + 1; j <= end; j++) {
                minDist = Math.min(getDist(arrList.get(i), arrList.get(j)), minDist);
            }
        }
        return minDist;
    }

    public static int divCon(ArrayList<Point> arrList, int start, int end) {
        int n = end - start + 1;

        if (n <= 3) {
            return bruteForce(arrList, start, end);
        }

        int mid = (start + end) / 2;

        int d = Math.min(divCon(arrList, start, mid), divCon(arrList, mid + 1, end));

        ArrayList<Point> band = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            int t = arrList.get(mid).x - arrList.get(i).x;

            if (t * t < d) {
                band.add(arrList.get(i));
            }
        }
        Collections.sort(band, (p1, p2) -> p1.y - p2.y);

        for (int i = 0; i < band.size() - 1; i++) {
            for (int j = i + 1; j < band.size(); j++) {
                int t = band.get(j).y - band.get(i).y;

                if (t * t < d) {
                    d = Math.min(d, getDist(band.get(i), band.get(j)));
                } else { 
                    break;
                }
            }
        }
        return d;
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}

