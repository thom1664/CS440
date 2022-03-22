import java.util.Scanner;

public class testApp{
    public static void main(String args[]){
        int seedVal, processNum, lastAT, maxBT, QuantSize, latency = 0;
        Scanner reader = new Scanner(System.in);

        System.out.println("Enter a seed value:");
        seedVal = reader.nextLine();
        System.out.println("Enter number of processes (2, 100):");
        processNum = reader.nextLine();
        System.out.println("Enter last possible arrival time (0, 99):");
        lastAT = reader.nextLine();
        System.out.println("Enter max burst time (1, 100):");
        maxBT = reader.nextLine();
        System.out.println("Enter quantum size (1, 100):");
        QuantSize = reader.nextLine();
        System.out.println("Enter latency (0, 10):");
        latency = reader.nextLine();

        System.out.println("Your inputs included:");
        System.out.print(System.lineSeparator());
        System.out.println("Seed value of"+ seedVal);
        System.out.print(System.lineSeparator());
        System.out.println(processNum +"processes");
        System.out.print(System.lineSeparator());
        System.out.print("A last possible arrival time of"+ lastAT);

    }

}