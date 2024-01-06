package mergesorter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws Exception {
        Scanner sc =  new Scanner(System.in);
//        List<Integer> integerList = List.of(1, 5, 7, 1, 2, 4, 9, 11,
//                2, 4, 5, 90 ,45, 32, 1);
        List<Integer> integerList =  new ArrayList<>();
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            integerList.add(sc.nextInt());
        }
        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<List<Integer>> sortedListFuture = executorService.submit(new MergeSort(integerList, executorService));
        System.out.println(sortedListFuture.get());
        executorService.shutdown();
    }
}
