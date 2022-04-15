import java.util.Random;

public class Woman extends OnePerson {
    protected static final int max_wait_time = 1;
    protected static final int max_use_time = 6;
    
    
    public Woman(int id, int gender, int time) {
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
        Bathroom.womanEnter(this);
        System.out.print("Woman " + this.getID() + " entered the toilet.\n");

        try {
			Thread.sleep((new Random()).nextInt(max_use_time * 1000));
		} catch (InterruptedException interruptedException) {
			interruptedException.printStackTrace();
		}

        System.out.print("Woman " + this.getID() + " left the bathroom.\n");
        Bathroom.womenExit(this);

    }
}
