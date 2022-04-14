import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public interface BathroomInterface {

    public static final int BATHROOM_SIZE = 7;
    void manExit();
    void manEnter();
    void womanEnter();
    void womanExit();
}

public class Bathroom implements BathroomInterface{
    private final int BATHROOM_CAPACITY = 10;
    private int free_resources = BATHROOM_CAPACITY;

    private Lock lock = new ReentrantLock();

    private Condition womenWaitingQue = lock.newCondition();
    private Condition menWaitingQue = lock.newCondition();

    private int womenWaitingN = 0;
    private int menWaitingN = 0;
    private int womenUsingN = 0;
    private int menUsingN = 0;

    public void womenEnter(){
        lock.lock();
        while(true){
            if(free_resources > 0 && menUsingN == 0){
                womenUsingN++;
                womenWaitingN--;
                free_resources--;
            }
            else 
                try{
                womenWaitingQue.await();
            }
            catch(Exception e){
            }
        }
        lock.unlock();
    }
    public void womenExit(){
        lock.lock();
        womenUsingN--;
        womenWaitingN--;
        free_resources++;
        if(menWaitingN > 0){
            try{
                menWaitingQue.signal();
            }
            catch(Exception e){
            }
        }
        lock.unlock();
    }
    public void manEnter(){
        lock.lock();
        menUsingN++;
        menWaitingN--;
        free_resources--;
        while(true){
            if(free_resources > 0 && womenUsingN == 0){
                try{
                    menWaitingQue.await();
                }
                catch(Exception e){
                }
            }
        }
    }
    public void manExit(){
        lock.lock();
        menUsingN--;
        menWaitingN--;
        free_resources++;
        if(womenWaitingN > 0){
            try{
                womenWaitingQue.signal();
            }
            catch(Exception e){
            }
        }
        lock.unlock();
    }
}

