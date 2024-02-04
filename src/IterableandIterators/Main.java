package IterableandIterators;

import introtothreads.HelloWorldThread;

import java.util.*;
public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
        List<Integer> list = Arrays.asList(2, 4, 6, 1,3 ,5 );
        Iterator<Integer> itr = list.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
        //can't use iterators directly for hashMaps
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("k",(int)('k'- 'a'));
        hm.put("a", (int) ('a' - 'a'));
        hm.put("c", (int)('c' - 'a'));
        hm.put("b", (int)('b'- 'a'));
        //using for-each over Map.Entry<>
        for(Map.Entry<String, Integer> entry : hm.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        //using for each over keyset or values
        for(String key : hm.keySet()){
            System.out.println(key);
        }

        // using iterator
        Iterator<Map.Entry<String, Integer>> itr3 = hm.entrySet().iterator();
        while(itr3.hasNext()){
            Map.Entry<String, Integer> entry = itr3.next();
            System.out.println(entry.getKey() + " : " +  entry.getValue());
        }
        // using lambda
        hm.forEach((k,v) -> System.out.println(k +" : " + v));
    }
}