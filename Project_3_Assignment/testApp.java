import java.util.Scanner;

public class testApp{
    public static void main(String args[]){
        String change1, change2java, change3, change4, change5, change6;
        Scanner reader = new Scanner(System.in);

        System.out.println("Enter a seed value:");
        change1 = reader.nextLine();
        Integer seedVal = Integer.valueOf(change1);
        System.out.println("Enter number of processes (2, 100):");
        change2 = reader.nextLine();
        Integer processNum = Integer.valueOf(change2);
        System.out.println("Enter last possible arrival time (0, 99):");
        change3 = reader.nextLine();
        Integer lastAT = Integer.valueOf(change3);
        System.out.println("Enter max burst time (1, 100):");
        change4 = reader.nextLine();
        Integer maxBT = Integer.valueOf(change4);
        System.out.println("Enter quantum size (1, 100):");
        change5 = reader.nextLine();
        Integer QuantSize = Integer.valueOf(change5);
        System.out.println("Enter latency (0, 10):");
        change6 = reader.nextLine();
        Integer latency = Integer.valueOf(change6);

        System.out.println("Your inputs included:");
        System.out.print(System.lineSeparator());
        System.out.println("Seed value of "+ seedVal);
        System.out.print(System.lineSeparator());
        System.out.println(processNum +" processes");
        System.out.print(System.lineSeparator());
        System.out.println("A last possible arrival time of "+ lastAT);
        System.out.print(System.lineSeparator());
        System.out.println("A max burst time of "+ maxBT);
        System.out.print(System.lineSeparator());
        System.out.println("A quantum size of "+ QuantSize);
        System.out.print(System.lineSeparator());
        System.out.println("A latency of "+ latency);
    }

}