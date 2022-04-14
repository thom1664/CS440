import java.util.LinkedList;
import java.util.Random;

public class Process extends OnePerson{
    private LinkedList<Integer> list = new LinkedList();
    private final int LIMIT = 10;
    private Object lock = new Object();

    public Process(int id, int gender, int time) {
        super(id, gender, time);
        //TODO Auto-generated constructor stub
    }

    public void Arrive(int id, int gender) throws InterruptedException {
        Random random = new Random();
        while(true){
            synchronized(lock){
                while(list.size() == LIMIT){
                    lock.wait();
                }
            }
            list.add(id++);
            lock.notify();
            Thread.sleep(random.nextInt(1000));
        }
    }

    public void UseFacilities(int id, int gender, int time) throws InterruptedException{
        Random random = new Random();
        Thread.sleep(random.nextInt(time));
    }

    public void Depart(int id, int gender) throws InterruptedException {
        Random random = new Random();

        while(true){    
            synchronized(lock){
                while(list.size() == 0){
                    lock.wait();
                }
                System.out.print("List size is: " + list.size());
                id = list.removeFirst();
                System.out.println("; ");
                lock.notify();
            }
            Thread.sleep(random.nextInt(1000));
        }
        
    }

    public static void main(String[] args) throws Exception {
        OnePerson t = new OnePerson(1,2,3);
        System.out.print(t);
    }
}
