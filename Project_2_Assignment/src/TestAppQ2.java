class RunApp2 extends Thread {
   
     
    public void run() {
    }
 
}
 
 
  
 public class TestAppQ2 {
    public static void main(String args[]) {
       System.out.println("- Application Start -");
        int mainThread = 100;
        int childThreads = 1000;
        long time1 = System.nanoTime();
 
        for (int i = 1; i <= mainThread; i++){
            RunApp2 parentThread = new RunApp2();
            parentThread.start();
            System.out.println("Creating Parent Thread - " + i);

            for (int j = 1; j <= childThreads; j++){
                RunApp2 childThread = new RunApp2();
                childThread.start();
                System.out.println("Creating Child Thread - " + j);
                childThread.stop();
                System.out.println("Destroying Child Thread - " + j);
                if (j == childThreads){
                    parentThread.stop();
                    System.out.println("Destorying Parent Thread - " + i);
                }
            }
        }
 
       long time2 = System.nanoTime();
       long length = (time2 - time1)/100000;
       System.out.println("Time to Process: " + length + " ms.");
 
       System.out.println("- Application End -");
    }   
 }