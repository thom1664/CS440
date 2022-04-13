public class OnePerson{
    private int id;
    private int gender;
    private int time;

    public OnePerson(int id, int gender, int time){
        this.id = id;
        this.gender = gender;
        this.time = time;
    }

    public int getID(){
        return id;
    }

    public int getGender(){
        return gender;
    }

    public int getTime(){
        return time;
    }

    public void setID(int id){
        this.id = id;
    }

    public void setGender(int gender){
        this.gender = gender;
    }

    public void setTime(int time){
        this.time = time;
    }

    public String toString(int gender){
        return "ID: " + id + " " + "Gender: " + gender + " " + "Time: " + time;
    }

}
