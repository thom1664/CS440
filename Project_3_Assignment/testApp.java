import java.security.*;
import java.util.*;
import java.util.Scanner;
import java.util.Random;

public class testApp extends Numbers{
    public static void main(String args[]){
        Scanner reader = new Scanner(System.in);


        System.out.println("Enter a seed value:");
        int seedVal = reader.nextInt();
        int seed = random(seedVal);
        System.out.println("Enter number of processes (2, 100):");
        processNum = reader.nextInt();
        if(processNum < 2 || > 100){
            System.out.println("Please only enter numbers between 2 and 100./n")
            System.out.println("Enter number of processes (2, 100):");
            processNum = reader.nextInt();
        }
        else{
            return processNum;
        }
        
        System.out.println("Enter last possible arrival time (0, 99):");
        int lastAT = reader.nextInt();
        if(lastAT < 0 || > 99){
            System.out.println("Please only enter numbers between 0 and 99./n")
            System.out.println("Enter last possible arrival time (0, 99):");
            lastAT = reader.nextInt();
        }
        else{
            return lastAT;
        }

        System.out.println("Enter max burst time (1, 100):");
        int maxBT = reader.nextInt();
        if(maxBT < 1 || > 100){
            System.out.println("Please only enter numbers between 1 and 100./n")
            System.out.println("Enter max burst time (1, 100):");
            maxBT = reader.nextInt();
        }
        else{
            return maxBT;
        }

        System.out.println("Enter quantum size (1, 100):");
        int quantSize = reader.nextInt();
        if(quantSize < 1 || > 100){
            System.out.println("Please only enter numbers between 1 and 100./n")
            System.out.println("Enter quantum size (1, 100):");
            quantSize = reader.nextInt();
        }
        else{
            return quantSize;
        }
        
        System.out.println("Enter latency (0, 10):");
        int latency = reader.nextInt();
        if(latency < 0 || > 10){
            System.out.println("Please only enter numbers between 0 and 10./n")
            System.out.println("Enter latency (0, 10):");
            latency = reader.nextInt();
        }
        else{
            return latency;
        }
        

        System.out.println("Your inputs included:");
        System.out.print(System.lineSeparator());
        System.out.println("Seed value of "+ seedVal);
        System.out.print(System.lineSeparator());
        /* System.out.println(processNum +" processes");
        System.out.print(System.lineSeparator());
        System.out.println("A last possible arrival time of "+ lastAT);
        System.out.print(System.lineSeparator());
        System.out.println("A max burst time of "+ maxBT);
        System.out.print(System.lineSeparator());
        System.out.println("A quantum size of "+ QuantSize);
        System.out.print(System.lineSeparator());
        System.out.println("A latency of "+ latency);*/

        System.out.println("The given seed value has generated the following seed: "+ seed);
    }

}