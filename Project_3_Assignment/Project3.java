import java.util.*;

class Project3{

  public int seed;
  public int process;
  public int arrivalTime;
  public int burstTime;
  public int q;
  public int late;
  public ArrayList<Integer> arrival = new ArrayList<Integer>();
  public ArrayList<Integer> burst = new ArrayList<Integer>();
  public ArrayList<Integer> name = new ArrayList<Integer>();

  Project3(){
      this.seed = 0;
      this.process = 0;
      this.arrivalTime = 0;
      this.burstTime = 0;
      this.q = 0;
      this.late=0;
      
  }
 
  public void initializer(){
      int counter = 0;
      
      Random randnum = new Random();
      randnum.setSeed(123456789);
      
      while (counter < this.process)
      {
          this.arrival.add(randnum.nextInt(this.arrivalTime + 1));
          
          this.burst.add(randnum.nextInt(this.burstTime) + 1);
          
          this.name.add(counter + 1);
          
          counter++;
      }
      
      
      for(int i = 0; i < this.process; i++)
      {
          System.out.format("%-10s %8s %8s", "P" + name.get(i), arrival.get(i), burst.get(i) + "\n");
        }
      
    }
  
  public void fcfs(){
    ArrayList<Integer> arrivalList = this.arrival;
    ArrayList<Integer> burstList = this.burst;
    ArrayList<Integer> nameList = this.name;
      
    ArrayList<Integer> arrivalList1 = new ArrayList<Integer>();
    ArrayList<Integer> burstList1 = new ArrayList<Integer>();
    ArrayList<Integer> nameList1 = new ArrayList<Integer>();
    for (int i = 0; i < arrival.size(); i++)
    {
        arrivalList1.add(arrivalList.get(i));
        burstList1.add(burstList.get(i));
        nameList1.add(nameList.get(i));
    }
    
    int time = 0;
    int contextNum = 0;
    
    
    while(arrivalList1.size() > 0){
        int a = 1000;
        int counter = 0;
        int indexValueProcessing = 0;
        
        for (int i: arrivalList1)
        {
           if (i < a)
           {
               a = i;
               indexValueProcessing = counter;
           }
           counter++;
        }
        
        ArrayList<Integer> sames = new ArrayList<Integer>();
        int numSame = 0;
        int indexCounter = 0;
        for (int i: arrivalList1)
        {
           if (i == a)
           {
               numSame++;
               sames.add(name.get(indexCounter));
           }
           indexCounter++;
        }
        
        int processNum = 0;
        if (numSame > 1)
        {
            Random rand = new Random();
            int indi = rand.nextInt(numSame);
            processNum = sames.get(indi);
            for (int i=0; i<arrivalList1.size();i++)
            {
                if (nameList1.get(i) == processNum)
                {
                    indexValueProcessing = i;
                }
            }
        }

        
        
        System.out.println("@t=" + time + ", P" + nameList1.get(indexValueProcessing) + " selected for " 
            + burstList1.get(indexValueProcessing) + " units");
        
        time += burstList1.get(indexValueProcessing);
        
        arrivalList1.remove(indexValueProcessing);
        burstList1.remove(indexValueProcessing);
        nameList1.remove(indexValueProcessing);
        contextNum += 1;

        if (arrivalList1 != null)
        {
            System.out.println("@t=" + time + ", context switch " + contextNum + " occurs");
        }
        else{
            System.out.println("@t=" + time + ", all processes complete");
        }
        time += late;
    }
  }
  
  public void sjf(){
    ArrayList<Integer> arrivalList = this.arrival;
    ArrayList<Integer> burstList = this.burst;
    ArrayList<Integer> nameList = this.name;
      
    ArrayList<Integer> arrivalList1 = new ArrayList<Integer>();
    ArrayList<Integer> burstList1 = new ArrayList<Integer>();
    ArrayList<Integer> nameList1 = new ArrayList<Integer>();
    for (int i = 0; i < arrival.size(); i++)
    {
        arrivalList1.add(arrivalList1.get(i));
        burstList1.add(burstList1.get(i));
        nameList1.add(nameList1.get(i));
    }
    
    int time = 0;
    int contextNum = 0;
    
    
    while(burstList1.size() > 0){
        int a = 1000;
        int counter = 0;
        int indexValueProcessing = 0;
        
        for (int i: burstList1)
        {
           if (i < a)
           {
               a = i;
               indexValueProcessing = counter;
           }
           counter++;
        }
        
        ArrayList<Integer> sames = new ArrayList<Integer>();
        int numSame = 0;
        int indexCounter = 0;
        for (int i: burstList1)
        {
           if (i == a)
           {
               numSame++;
               sames.add(name.get(indexCounter));
           }
           indexCounter++;
        }
        
        int processNum = 0;
        if (numSame > 1)
        {
            Random rand = new Random();
            int indi = rand.nextInt(numSame);
            processNum = sames.get(indi);
            for (int i=0; i<burstList1.size();i++)
            {
                if (nameList1.get(i) == processNum)
                {
                    indexValueProcessing = i;
                }
            }
        }

        
        
        System.out.println("@t=" + time + ", P" + nameList1.get(indexValueProcessing) + " selected for " 
            + burstList1.get(indexValueProcessing) + " units");
        
        time += burstList1.get(indexValueProcessing);
        
        arrivalList1.remove(indexValueProcessing);
        burstList1.remove(indexValueProcessing);
        nameList1.remove(indexValueProcessing);
        contextNum += 1;
        
        
        if (arrivalList1 != null)
        {
            System.out.println("@t=" + time + ", context switch " + contextNum + " occurs");
        }
        else{
            System.out.println("@t=" + time + ", all processes complete");
        }
        time += late;
    }
    
  }
