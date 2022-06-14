import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();

        for(int i=0 ; i <= 10001 ; i++  ){
            integerList.add(i);
        }

        ExecutorService pool1 = Executors.newFixedThreadPool(4);
        ExecutorService pool2 = Executors.newFixedThreadPool(4);
        ExecutorService pool3 = Executors.newFixedThreadPool(4);
        ExecutorService pool4 = Executors.newFixedThreadPool(4);

        List<Integer> p1 = integerList.subList(0,2500);
        List<Integer> p2 = integerList.subList(2500,5000);
        List<Integer> p3 = integerList.subList(5000,7500);
        List<Integer> p4 = integerList.subList(7500,10000);

        ThreadOperations t1 = new ThreadOperations(p1);
        pool1.execute(t1);
        ThreadOperations t2 = new ThreadOperations(p2);
        pool2.execute(t2);
        ThreadOperations t3 = new ThreadOperations(p3);
        pool3.execute(t3);
        ThreadOperations t4 = new ThreadOperations(p4);
        pool4.execute(t4);
    }
}
