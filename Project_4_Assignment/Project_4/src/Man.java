import java.util.*;

public class Man extends OnePerson{

    protected static final int max_wait_time = 1;
    protected static final int max_use_time = 6;

    public Man(int id, int gender, int time) {
        super(id, gender, time);
        //TODO Auto-generated constructor stub
    }
    
    public void run(){
        try{
            Thread.sleep((new Random()).nextInt(max_wait_time * 1000));
        }
        catch (InterruptedException interruptedException){
            interruptedException.printStackTrace();
        }
        Bathroom.manEnter(this);
        System.out.print("Man " + this.getID() + " entered the bathroom.\n");

        try {
			Thread.sleep((new Random()).nextInt(max_use_time * 1000));
		} catch (InterruptedException interruptedException) {
			interruptedException.printStackTrace();
		}

        System.out.print("Man " + this.getID() + " left the bathroom.\n");
        Bathroom.manExit(this);
    }
}
