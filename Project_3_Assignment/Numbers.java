import java.util.*;

public class Numbers {
    Random randNum;

    public Numbers() {
        randNum = new Random();
        randNum.setSeed(123456789);
    }

    public int random(int i){
        return randNum.nextInt(i);
    }
}