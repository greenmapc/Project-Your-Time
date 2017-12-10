package entity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StoreOfDays extends ArrayList<Day> {
    Scanner sc;
    FileWriter writer;

    public StoreOfDays() throws FileNotFoundException {
        sc = new Scanner(new File("src/repository/database"));
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            String[] parse = s.split(" ");
            Day day = new Day();
            day.setDate(parse[0]);
            day.setUsefulTime(parse[1]);
            day.setUselessTime(parse[2]);
            this.add(day);
        }
    }

    public String mostUsefulDay() {
        String result = "";
        Day day = null;
        if (this.size() > 0) {
            day = this.get(0);
        }
        for (int i = 0; i < this.size(); i++){
            if(this.get(i).compareToUseful(day)==1){
                day = this.get(i);
            }
        }
        if(day!=null){
            result = "Самый полезный день: " + day.getDate() + "\n" +
                    "Полезного времени " + day.getUsefulTime();
        }
            return result;
    }

    public String mostUselessDay() {
        String result = "";
        Day day = null;
        if (this.size() > 0) {
            day = this.get(0);
        }
        for (int i = 0; i < this.size(); i++){
            if(this.get(i).compareToUseless(day)==1){
                day = this.get(i);
            }
        }
        if(day!=null){
            result = "Самый бесполезный день: " + day.getDate() + "\n" +
                    "Бесполезного времени " + day.getUsefulTime();
        }
        return result;
    }

    public void save() throws IOException {
        writer = new FileWriter(new File("src/repository/database"));
        for (int i = 0; i < this.size(); i++) {
            writer.write(this.get(i).toString() + "\n");
        }
        writer.close();
    }
}
