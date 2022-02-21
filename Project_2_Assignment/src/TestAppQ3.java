class RunApp3 extends Thread {
   
     
    public void run() {
    }
 
}
 
 
  
 public class TestAppQ3 {
    public static void main(String args[]) {
       System.out.println("- Application Start -");
        int mainThread = 10;
        int childThreads = 100;
        int grandChildThreads = 100;
        long time1 = System.nanoTime();
 
        for (int i = 1; i <= mainThread; i++){
            RunApp3 parentThread = new RunApp3();
            parentThread.start();
            System.out.println("Creating Parent Thread - " + i);

            for (int j = 1; j <= childThreads; j++){
                RunApp3 childThread = new RunApp3();
                childThread.start();
                System.out.println("Creating Child Thread - " + j);

                for (int k = 1; k <= grandChildThreads; k++){
                    RunApp3 grandChildThread = new RunApp3();
                    grandChildThread.start();
                    System.out.println("Creating Grandchild Thread - " + k);
                    grandChildThread.stop();
                    System.out.println("Destroying Grandchild Thread - " + k);
                    if (k == grandChildThreads){
                        childThread.stop();
                        System.out.println("Destroying Child Thread - " + j);
                    }
                }
                
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
