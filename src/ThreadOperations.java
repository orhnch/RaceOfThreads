import java.util.ArrayList;
import java.util.List;

public class ThreadOperations implements Runnable {
    List<Integer> oddNumbers =  new ArrayList<>();
    List<Integer> evenNumbers = new ArrayList<>();
    List<Integer> subArr;

    public ThreadOperations (List<Integer> subArr){
        this.subArr = subArr;
    }

    @Override
    public void run(){
        find(this.subArr);
        print(Thread.currentThread().getName());
    }

    private synchronized void find(List<Integer> subArr) {
        for (int i = 0 ; i < subArr.size(); i++){
            int number = subArr.get(i);
            if(number % 2 == 0){
                evenNumbers.add(number);
            }else {
                oddNumbers.add(number);
            }
        }
    }

    public void print(String threadName){
        System.out.println(threadName+":"+evenNumbers);
        System.out.println(threadName+":"+oddNumbers);
    }
}
