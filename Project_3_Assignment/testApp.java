import java.security.*;
import java.util.*;
import java.util.Scanner;
import java.util.Random;

public class testApp extends Numbers{
    public static void main(String args[]){
        String seedVal, processNum, lastAT, maxBT, quantSize, latency;
        Scanner reader = new Scanner(System.in);
        Random r = new Random();

        System.out.println("Enter a seed value:");
        seedVal = reader.nextInt();
        System.out.println("Enter number of processes (2, 100):");
        processNum = reader.nextInt();
        System.out.println("Enter last possible arrival time (0, 99):");
        lastAT = reader.nextInt();
        System.out.println("Enter max burst time (1, 100):");
        maxBT = reader.nextInt();
        System.out.println("Enter quantum size (1, 100):");
        quantSize = reader.Int();
        System.out.println("Enter latency (0, 10):");
        latency = reader.nextInt();


        System.out.println("Your inputs included:");
        System.out.print(System.lineSeparator());
        System.out.println("Seed value of "+ seedVal);
        System.out.println(processNum +" processes");
        System.out.println("A last possible arrival time of "+ lastAT);
        System.out.println("A max burst time of "+ maxBT);
        System.out.println("A quantum size of "+ quantSize);
        System.out.println("A latency of "+ latency);
    }

}