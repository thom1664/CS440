import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

interface BathroomInterface{

    public static final int BATHROOM_SIZE = 5;
    void manExit();
    void manEnter();
    void womanEnter();
    void womanExit();
    
}

public class Bathroom implements BathroomInterface{
    private final int BATHROOM_CAPACITY = 20;
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
            break;
        }
    }
    public void womenExit(){
        lock.lock();
        womenUsingN--;
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
    public void menEnter(){
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
            break;
        }
    }
    public void menExit(){
        lock.lock();
        menUsingN--;
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
    @Override
    public void womanEnter() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void womanExit() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void manEnter() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void manExit() {
        // TODO Auto-generated method stub
        
    }
    public static void womanEnter(Woman enteringWoman) {
        ((BathroomInterface) enteringWoman).womanEnter();
    }
    public static void womenExit(Woman exitingWoman) {
        ((BathroomInterface) exitingWoman).womanExit();
    }
    public static void menEnter(Man enteringMan){
        ((BathroomInterface) enteringMan).manEnter();
    }
    public static void menExit(Man exitingMan){
        ((BathroomInterface) exitingMan).manExit();
    }
    
}

