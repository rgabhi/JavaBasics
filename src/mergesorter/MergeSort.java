package mergesorter;

import org.w3c.dom.ls.LSInput;

import javax.swing.plaf.FontUIResource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MergeSort implements Callable<List<Integer>>{

    List<Integer> integerList;
    ExecutorService executorService;
    MergeSort(List<Integer> integerList, ExecutorService executorService){
        this.integerList = integerList;
        this.executorService = executorService;
    }
    @Override
    public List<Integer> call() throws Exception {
        int left = 0;
        int right = integerList.size() - 1;
        int mid = left + (right - left)/2;

        if(integerList.size() == 1){
            return integerList;
        }

        List<Integer> leftArray = new ArrayList<>();
        for(int i = left; i <= mid; i++){
            leftArray.add(integerList.get(i));
        }
        List<Integer> rightArray = new ArrayList<>();
        for(int i =mid+1; i <= right; i++){
            rightArray.add(integerList.get(i));
        }
        Future<List<Integer>> leftSortedListFuture = executorService.submit(new MergeSort(leftArray, executorService));
        Future<List<Integer>> rightSortedListFuture = executorService.submit(new MergeSort(rightArray, executorService));
        List<Integer> leftSortedList = leftSortedListFuture.get();
        List<Integer> rightSortedList = rightSortedListFuture.get();

        int i = 0, j = 0;
        List<Integer> sortedList = new ArrayList<>();
        while((i < leftSortedList.size()) && (j < rightSortedList.size())){
            if(leftSortedList.get(i) <= rightSortedList.get(j)){
                sortedList.add(leftSortedList.get(i++));
            }
            else{
                sortedList.add(rightSortedList.get(j++));
            }
        }
        while((i < leftSortedList.size())){
            sortedList.add(leftSortedList.get(i++));
        }
        while((j < rightSortedList.size())){
            sortedList.add(rightSortedList.get(j++));
        }
        return sortedList;
    }
}
