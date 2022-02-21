class RunApp implements Runnable {
   
   private boolean destroyThread;
   private Thread t;
   private String threadName;
   private long endTime;
 
      RunApp(String name) {
         threadName = name;
         t = new Thread(this, threadName);

         System.out.println("Creating ..." +  name);

         destroyThread = false;
         t.start();
      }
    
      public void run() {
         long destroyStart = System.nanoTime();
         int i = 100000;
         while (destroyThread) {
            
            i = i - 1;
            System.out.println("Destroying..." + i);
         
         if (i == 0){
            this.endTime = System.nanoTime();
            long desThreadTime = (this.endTime - destroyStart)/1000000;
         
            System.out.println("Time to Destroy: " + desThreadTime + " ms");
            break;
         } 
      }
   }

   public void stop() {
      if (threadName.equals("100000")){
         destroyThread = true;
      }
   }
}


 
public class TestApp {
   public static void main(String args[]) {
      System.out.println("- Application Start -");

      int iteration = 100000;
      long time1 = System.nanoTime();

         for (int i = 1; i <= iteration; i++){
            RunApp t1 = new RunApp(String.valueOf(i));
            t1.stop();
         }

      long time2 = System.nanoTime();
      long length = (time2 - time1)/iteration;
      System.out.println("Time to Create: " + length + " ms");

      System.out.println("- Application End -");
   }   
}