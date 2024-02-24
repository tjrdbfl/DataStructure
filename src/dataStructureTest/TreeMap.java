package dataStructureTest;

import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;

public class TreeMap {
    public static void main(String[] args) {
        java.util.TreeMap<String,Integer> treeMap=new java.util.TreeMap<>();

        treeMap.put("apple",10);
        treeMap.put("forever",60);
        treeMap.put("description",40);
        treeMap.put("ever",50);
        treeMap.put("zoo",80);
        treeMap.put("base",20);
        treeMap.put("guess",70);
        treeMap.put("cherry",30);

        //오름차순으로 정렬된 treeMap 출력하기
        System.out.println("<오름차순으로 정렬>");
        Set<Map.Entry<String,Integer>> entrySet=treeMap.entrySet();
        entrySet.forEach(i->{
            System.out.println(i.toString());
        });

        //내림차순으로 정렬된 treeMap 출력하기
        System.out.println("\n<내림차순으로 정렬>");
        NavigableMap<String,Integer> descendingMap=treeMap.descendingMap();
        Set<Map.Entry<String,Integer>> descendingEntrySet=descendingMap.entrySet();
        descendingEntrySet.forEach(i->{
            System.out.println(i.toString());
        });


        //특정 키에 대한 값 가져오기
        Map.Entry<String,Integer> entry=null;
        entry=treeMap.firstEntry();
        System.out.println("\n제일 앞 단어: "
                + entry.getKey()+ "-"+entry.getValue());
        entry=treeMap.lastEntry();
        System.out.println("제일 뒤 단어: "
                + entry.getKey()+ "-"+entry.getValue());
        entry=treeMap.lowerEntry("ever");
        System.out.println("ever 앞 단어"
                + entry.getKey()+ "-"+entry.getValue());
        System.out.println("제일 앞 단어: "
                + entry.getKey()+ "-"+entry.getValue());

        //범위 검색
        System.out.println("[c-h 사이의 단어 검색]");
        NavigableMap<String,Integer> randomMap=treeMap.subMap("c",true,"h",false);
        for(Map.Entry<String,Integer> i: randomMap.entrySet()){
            System.out.println(i.toString());
        }

    }
}
