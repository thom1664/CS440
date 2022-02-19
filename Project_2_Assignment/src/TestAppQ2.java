class NewThread2 implements Runnable {
    
    Thread t;

    NewThread2() {
        
        t = new Thread(this, "Child Thread");
        t.start();
        
    }

    public void run() {
        try{
            for (int i = 5; i > 0; i--){
                System.out.println("Child Thread: " + i);
                
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }
        System.out.println("Destroying Child...");
    }

}

public class TestAppQ2 {
    public static void main(String[] args) {

        for (int j = 1; j < 500; j++) {
            new NewThread2();
        }
        
        try{
            for (int i = 5; i > 0; i--){
                System.out.println("Main Thread: " + i);
                
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }
        System.out.println("Destroying Main...");
    }
}