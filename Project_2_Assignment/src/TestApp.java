public class TestApp {
    public static void main(String[] args) throws Exception {
        RunApp R1 = new RunApp("Thread-1");
        R1.start();
        RunApp R2 = new RunApp("Thread-2");
        R2.start();
    }
}
