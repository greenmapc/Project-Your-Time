package entity;


import java.io.FileNotFoundException;

public class Day {
    private String date;
    private String usefulTime;
    private String uselessTime;

    public Day() {
        this.uselessTime = "00:00:00";
        this.usefulTime = "00:00:00";
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setUsefulTime(String usefulTime) {
        this.usefulTime = usefulTime;
    }

    public void setUselessTime(String uselessTime) {
        this.uselessTime = uselessTime;
    }

    public String getDate() {
        return date;
    }

    public String getUsefulTime() {
        return usefulTime;
    }

    public String getUselessTime() {
        return uselessTime;
    }

    @Override
    public String toString() {
        return date+" "+usefulTime+" "+uselessTime;
    }

    public int compareToUseful(Day day){
        if(day==null){
            return -1;
        }
        int result = 0;
        String [] current = this.getUsefulTime().split(":");
        int cur = Integer.parseInt(current[0])*360+Integer.parseInt(current[1])*60+Integer.parseInt(current[2]);
        current = day.getUsefulTime().split(":");
        int comp = Integer.parseInt(current[0])*360+Integer.parseInt(current[1])*60+Integer.parseInt(current[2]);
        if(cur>comp){
            result = 1;
        }
        return result;
    }

    public int compareToUseless(Day day){
        if(day==null){
            return -1;
        }
        int result = 0;
        String [] current = this.getUselessTime().split(":");
        int cur = Integer.parseInt(current[0])*360+Integer.parseInt(current[1])*60+Integer.parseInt(current[2]);
        current = day.getUselessTime().split(":");
        int comp = Integer.parseInt(current[0])*360+Integer.parseInt(current[1])*60+Integer.parseInt(current[2]);
        if(cur>comp){
            result = 1;
        }
        return result;
    }

    public static long getSec(String s){
        String [] current = s.split(":");
        return  (Integer.parseInt(current[0])*360+Integer.parseInt(current[1])*60+Integer.parseInt(current[2]))*1000;
    }
}
