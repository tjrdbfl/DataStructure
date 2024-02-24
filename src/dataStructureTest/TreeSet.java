package dataStructureTest;

import java.util.NavigableSet;
public class TreeSet<I extends Number> extends java.util.TreeSet<Integer> {
    public static void main(String[] args) {
        java.util.TreeSet<Integer> scores = new TreeSet<>();

        scores.add(87);
        scores.add(98);
        scores.add(75);
        scores.add(95);
        scores.add(80);

        //오름차순 정렬
        System.out.print("오름차순 정렬: ");
        for (Integer i : scores) {
            System.out.print(i.toString() + " ");
        }
        System.out.println();

        //내림차순 정렬
        System.out.print("내립차순 정렬: ");
        NavigableSet<Integer> descendingScores = scores.descendingSet();
        for (Integer s : descendingScores) {
            System.out.print(s.toString() + " ");
        }

        //특정 Integer 객체 가져오기
        System.out.println("\n\n===== Integer 가져오기 ======"
                + "\n가장 낮은 점수: " + scores.first()
                + "\n가장 높은 점수: " + scores.last()
                + "\n95점 아래 점수: " + scores.lower(95)
                + "\n95점 위의 점수: " + scores.higher(95)
                + "\n95점이거나 바로 아래 점수: " + scores.floor(95)
                + "\n85점이거나 바로 위의 점수: " + scores.ceiling(85)
                + "\n===== Integer 가져오기 ======");

        //범위 검색 1 ( >=80)
        System.out.print("\n80 이상 Integer 검색: ");
        NavigableSet<Integer> rangeSet = scores.tailSet(80, true);
        for (Integer s : rangeSet) {
            System.out.print(s.toString() + " ");
        }

        //범위 검색 1 ( 80 <=  &&  < 90)
        System.out.print("\n\n80 이상 90 미만 Integer 검색: ");
        NavigableSet<Integer> subSet = scores.subSet(80, true, 90, false);
        for (Integer s : subSet) {
            System.out.print(s.toString() + " ");
        }
    }
}
